package com.works.services;

import com.works.entities.Grade;
import com.works.entities.JoinUserGrade;
import com.works.entities.User;
import com.works.repositories.GradeRepository;
import com.works.repositories.JoinUserGradeRepository;
import com.works.repositories.UserRepository;
import com.works.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class TeacherService {

    final UserRepository userRepository;
    final GradeRepository gradeRepository;
    final JoinUserGradeRepository joinUserGradeRepository;

    public TeacherService(UserRepository userRepository, GradeRepository gradeRepository, JoinUserGradeRepository joinUserGradeRepository) {
        this.userRepository = userRepository;
        this.gradeRepository = gradeRepository;
        this.joinUserGradeRepository = joinUserGradeRepository;
    }

    public ResponseEntity enterGrade(Grade grade){
        Map<REnum, Object> hm = new LinkedHashMap<>();

        Optional<User> user = userRepository.findById(grade.getId());
        if (user.isPresent()){
            gradeRepository.save(grade);
            List<JoinUserGrade> joinUserGrade = joinUserGradeRepository.listUserByGradeId(grade.getGradeId());
            hm.put(REnum.status, true);
            hm.put(REnum.result, joinUserGrade);
            return new ResponseEntity(hm, HttpStatus.OK);
        }else {
            hm.put(REnum.status, false);
            hm.put(REnum.message, "There is no user with this id.");
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
    }

}
