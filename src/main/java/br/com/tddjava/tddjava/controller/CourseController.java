package br.com.tddjava.tddjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tddjava.tddjava.domain.Course;
import br.com.tddjava.tddjava.repository.CourseRepository;
import br.com.tddjava.tddjava.service.CreateCourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository repository;

    @PostMapping("/")
    public Course createCourse(@RequestBody Course course) {
        CreateCourseService createCourseService = new CreateCourseService(repository);
        return createCourseService.execute(course);
    }

}