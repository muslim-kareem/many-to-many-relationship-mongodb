package com.example.studentscoursrelationship.course;

import com.example.studentscoursrelationship.student.Student;
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
@Document("courses")
public class Course {
    private String id;
    private String name;

    @JsonIgnoreProperties("courses")
    @DBRef
    private List<Student> students;
}
