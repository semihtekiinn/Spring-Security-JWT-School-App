package com.works.restcontrollers;

import com.works.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/listGrades/{id}")
    public ResponseEntity listGrades(@PathVariable Integer id){
        return studentService.listGrades(id);
    }

}
