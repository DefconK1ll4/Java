package com.divby0exc.jsontest.controller;

import com.divby0exc.jsontest.model.Course;
import com.divby0exc.jsontest.model.CourseNameDetails;
import com.divby0exc.jsontest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
    private List<Course> courses;

    public CourseController() {
        courses = new ArrayList<>();

        courses.add(new Course(1, "Math", "Best subject", 25));
        courses.add(new Course(2, "Math 2", "Best subject", 25));
        courses.add(new Course(3, "P.E.", "Awesome subject", 35));
    }

    @GetMapping("course/search/{query}")
    public List<Course> getSearchResult(@PathVariable String query) {
        return courses.stream().filter(course -> course.getName().contains(query)).toList();
    }

    @GetMapping("course")
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping("course/{courseId}")
    public CourseNameDetails getCourse(@PathVariable int courseId) {

        Course matchedCourse = courses.stream().filter(course -> course.getId() == courseId).findFirst().get();

        return new CourseNameDetails(matchedCourse);
    }

    @PostMapping("course")
    public ResponseEntity<List<Course>> createCourse(@RequestBody Course course) {
        course.setId(courses.size() + 1);
        courses.add(course);
        return ResponseEntity.status(201).body(courses);
    }

    @DeleteMapping("course/{courseId}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int courseId) {

        if(courseId > courses.size()) {
            return ResponseEntity
                    .status(400)
                    .header("x-error-msg", "Id is out of bounds, course does not exist with such id")
                    .build();
        }


        Course matchedCourse = courses.stream().filter(course -> course.getId() == courseId).findFirst().get();
        courses.removeIf(course -> course.getId() == courseId);

        return ResponseEntity.status(200).body(matchedCourse);
    }
    @PatchMapping("course/update/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        courseService.update(course);

        return ResponseEntity.status(200).body(course);

        }
    }