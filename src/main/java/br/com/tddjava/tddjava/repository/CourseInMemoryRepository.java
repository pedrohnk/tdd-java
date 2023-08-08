package br.com.tddjava.tddjava.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.tddjava.tddjava.domain.Course;

public class CourseInMemoryRepository implements ICourseRepository {
    private List<Course> courses;

    public CourseInMemoryRepository() {
        this.courses = new ArrayList<>();
    }

    @Override
    public Course findByTitle(String name) {
        Optional<Course> optionalCourse = this.courses.stream()
                .filter(course -> course.getTitle().equals(name))
                .findFirst();
        return optionalCourse.orElse(null);
    }

    @Override
    public Course save(Course course) {
        this.courses.add(course);
        course.setId(UUID.randomUUID());
        return course;
    }
}