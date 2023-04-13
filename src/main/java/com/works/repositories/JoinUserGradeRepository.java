package com.works.repositories;

import com.works.entities.JoinUserGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinUserGradeRepository extends JpaRepository<JoinUserGrade, Integer> {

    @Query(value = "SELECT g.grade_id, u.id, u.first_name, u.last_name, g.exam_name, g.exam_grade FROM grade AS g INNER JOIN user AS u ON g.id=u.id WHERE g.grade_id=?1", nativeQuery = true)
    List<JoinUserGrade> listUserByGradeId(Integer gradeId);

    @Query(value = "SELECT g.grade_id, u.id, u.first_name, u.last_name, g.exam_name, g.exam_grade FROM grade AS g INNER JOIN user AS u ON g.id=u.id WHERE u.id=?1", nativeQuery = true)
    List<JoinUserGrade> listGradeByUser(Integer id);

}