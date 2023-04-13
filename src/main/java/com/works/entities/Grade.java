package com.works.entities;

import com.works.utils.ExamEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;

    private Integer id;

    @Enumerated(EnumType.STRING)
    private ExamEnum examName;

    @Max(message = "Maximum grade is 100.", value = 100)
    @Min(message = "Minimum grade is 0.", value = 0)
    private Integer examGrade;

}
