package com.example.studentscoursrelationship.student;

import com.example.studentscoursrelationship.course.Course;
import com.example.studentscoursrelationship.course.CourseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final CourseService courseService;

    public List<Student> getAll(){
        return this.studentRepo.findAll();
    }

    public Student createStudent(Student student){
        return this.studentRepo.save(student);
    }

    public Student getStudentById(String id){
        return this.studentRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Student addCourseToStudent(String studentId, String courseId){
          Student theStudent = this.studentRepo.findById(studentId).orElseThrow(NoSuchElementException::new);
          Course theCourse = this.courseService.getCourseById(courseId);

          if(theStudent.getCourses() == null){
              theStudent.setCourses(new ArrayList<>());
              theStudent.getCourses().add(theCourse);
              this.studentRepo.save(theStudent);
          }else {
              theStudent.getCourses().add(theCourse);
              this.studentRepo.save(theStudent);
          }

          return theStudent;
    }
}
