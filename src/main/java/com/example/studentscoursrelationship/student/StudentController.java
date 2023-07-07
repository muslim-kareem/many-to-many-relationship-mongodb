package com.example.studentscoursrelationship.student;

import com.example.studentscoursrelationship.course.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return this.studentService.getAll();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable String id){
        return this.studentService.getStudentById(id);
    }

    @GetMapping("/{studentId}/{courseId}")
    public Student addCourse(@PathVariable String studentId, @PathVariable String courseId){
        return this.studentService.addCourseToStudent(studentId, courseId);
    }
    @PostMapping
    public Student createCourse(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }




}
