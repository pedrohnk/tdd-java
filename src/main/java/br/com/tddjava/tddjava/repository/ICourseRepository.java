package br.com.tddjava.tddjava.repository;

import br.com.tddjava.tddjava.domain.Course;

public interface ICourseRepository {
    public Course findByTitle(String name);
    public Course save(Course course);
}