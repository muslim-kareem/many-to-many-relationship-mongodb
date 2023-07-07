package com.example.studentscoursrelationship.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;


    public List<Course> getAll(){
        return this.courseRepo.findAll();
    }

    public Course createCourse(Course course){
        return this.courseRepo.save(course);
    }

    public Course getCourseById(String id){
        return this.courseRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
