package br.com.tddjava.tddjava.repository;

import java.util.UUID;

import br.com.tddjava.tddjava.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJPARepository extends JpaRepository<Course, UUID> {
    public Course findByTitle(String name);
}