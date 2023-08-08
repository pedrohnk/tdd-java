package br.com.tddjava.tddjava.service;

import br.com.tddjava.tddjava.domain.Course;
import br.com.tddjava.tddjava.repository.CourseInMemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateCourseServiceTests {
    private CourseInMemoryRepository repository;
    private CreateCourseService createCourseService;

    @BeforeEach
    public void setUp() {
        repository = new CourseInMemoryRepository();
        createCourseService = new CreateCourseService(repository);
    }

    @Test
    public void should_be_able_to_create_a_new_course() {
        Course course = new Course();
        course.setDescription("any_description");
        course.setTitle("any_title");
        course.setWorkload(100);

        Course createdCourse = createCourseService.execute(course);

        Assertions.assertNotNull(createdCourse.getId());
    }

    @Test
    public void should_not_be_able_to_create_a_course_if_already_exists() {
        Course course = new Course();
        course.setDescription("error_description");
        course.setTitle("error_course");
        course.setWorkload(100);

        createCourseService.execute(course);
        Assertions.assertThrows(Error.class, () -> createCourseService.execute(course));
    }
}
