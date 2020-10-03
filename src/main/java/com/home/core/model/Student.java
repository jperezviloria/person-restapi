package com.home.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "student")
public class Student {

    @Id
    private int idStudent;

    private String nameStudent;

    private String coursesStudent;

    public Student(int idStudent, String nameStudent, String coursesStudent) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.coursesStudent = coursesStudent;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getCoursesStudent() {
        return coursesStudent;
    }

    public void setCoursesStudent(String coursesStudent) {
        this.coursesStudent = coursesStudent;
    }
}
