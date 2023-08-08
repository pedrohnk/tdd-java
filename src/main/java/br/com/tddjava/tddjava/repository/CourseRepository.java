package br.com.tddjava.tddjava.repository;

import br.com.tddjava.tddjava.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRepository implements ICourseRepository {
    @Autowired
    CourseJPARepository courseJPARepository;

    @Override
    public Course findByTitle(String name) {
        return this.courseJPARepository.findByTitle(name);
    }
    @Override
    public Course save(Course course) {
        return this.courseJPARepository.save(course);
    }

}