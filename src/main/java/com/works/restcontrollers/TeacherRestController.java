package com.works.restcontrollers;

import com.works.entities.Grade;
import com.works.services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherRestController {

    final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/enterGrade")
    public ResponseEntity enterGrade(@RequestBody Grade grade){
        return teacherService.enterGrade(grade);
    }

}
