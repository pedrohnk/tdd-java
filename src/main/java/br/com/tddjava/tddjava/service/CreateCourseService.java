package br.com.tddjava.tddjava.service;

import org.springframework.stereotype.Service;

import br.com.tddjava.tddjava.domain.Course;
import br.com.tddjava.tddjava.repository.ICourseRepository;

@Service
public class CreateCourseService {
    private ICourseRepository repository;

    public CreateCourseService(ICourseRepository repository) {
        this.repository = repository;
    }

    public Course execute(Course course) {
        Course courseAlreadyExists = this.repository.findByTitle(course.getTitle());
        if (courseAlreadyExists != null) {
            throw new Error("Course already exists!");
        }
        return this.repository.save(course);
    }
}