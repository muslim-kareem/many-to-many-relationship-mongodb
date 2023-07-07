package com.example.studentscoursrelationship.student;

import com.example.studentscoursrelationship.course.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("students")
public class Student {
    private String id;
    private String name;

    @JsonIgnoreProperties("students")
    @DBRef
    private List<Course> courses;
}
