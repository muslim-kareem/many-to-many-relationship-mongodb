package com.example.studentscoursrelationship.course;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll(){
        return this.courseService.getAll();
    }


    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return this.courseService.createCourse(course);
    }
}
