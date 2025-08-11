package com.example.SBCRUDJPAPSql.Repository;

import com.example.SBCRUDJPAPSql.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByTechnology(String technology);

    @Query(nativeQuery = true,value = "SELECT * FROM student WHERE gender =:gender AND technology=:technology")
    List<Student> findByGenderTechnology(@Param("gender") String gender,@Param("technology") String technology);
}
