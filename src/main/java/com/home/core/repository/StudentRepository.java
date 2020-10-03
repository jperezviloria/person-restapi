package com.home.core.repository;

import com.home.core.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

    @Query(value="{ 'coursesStudent' : ?0 }")
    List<Student> findByCourse(String coursesStudent);

}
