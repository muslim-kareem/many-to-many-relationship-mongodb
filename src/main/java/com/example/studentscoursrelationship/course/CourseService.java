package com.example.studentscoursrelationship.course;

import com.example.studentscoursrelationship.student.Student;
import com.example.studentscoursrelationship.student.StudentRepo;
import com.example.studentscoursrelationship.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {
    private final CourseRepo courseRepo;
    private final StudentService studentService;
    public CourseService(CourseRepo courseRepo, @Lazy StudentService studentService) {
        this.courseRepo = courseRepo;
        this.studentService = studentService;
    }
    public List<Course> getAll(){
        return this.courseRepo.findAll();
    }

    public Course createCourse(Course course){
        return this.courseRepo.save(course);
    }

    public Course getCourseById(String id){
        return this.courseRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Course addStudentToCourse(String courseId, String studentId) {
        Student theStudent = this.studentService.getStudentById(studentId);
        Course theCourse = this.getCourseById(courseId);
        if (theCourse.getStudents() == null) {
            theCourse.setStudents(new ArrayList<>());
            theCourse.getStudents().add(theStudent);
            this.courseRepo.save(theCourse);
        } else {
            theCourse.getStudents().add(theStudent);
            this.courseRepo.save(theCourse);
        }
        return theCourse;
    }
}
