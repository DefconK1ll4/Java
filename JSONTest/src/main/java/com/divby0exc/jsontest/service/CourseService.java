package com.divby0exc.jsontest.service;

import com.divby0exc.jsontest.model.Course;
import com.divby0exc.jsontest.repository.CourseRepository;

import java.util.List;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService() {
        courseRepository = new CourseRepository();
    }

    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    public Course get(int id) {
        return courseRepository.get(id);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        return courseRepository.patch(course);
    }

}
