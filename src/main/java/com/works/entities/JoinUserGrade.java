package com.works.entities;

import com.works.utils.ExamEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
public class JoinUserGrade {

    @Id
    private Integer grade_id;

    private Integer id;

    @Enumerated(EnumType.STRING)
    private ExamEnum exam_name;
    private String first_name;
    private String last_name;
    private Integer exam_grade;

}
