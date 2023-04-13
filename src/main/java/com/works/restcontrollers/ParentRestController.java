package com.works.restcontrollers;

import com.works.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class ParentRestController {

    final StudentService studentService;

    public ParentRestController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/listGrades/{id}")
    public ResponseEntity listGrades(@PathVariable Integer id){
        return studentService.listGrades(id);
    }

}
