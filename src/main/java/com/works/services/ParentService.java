package com.works.services;

import com.works.entities.JoinUserGrade;
import com.works.entities.User;
import com.works.repositories.JoinUserGradeRepository;
import com.works.repositories.UserRepository;
import com.works.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParentService {

    final JoinUserGradeRepository joinUserGradeRepository;
    final UserRepository userRepository;

    public ParentService(JoinUserGradeRepository joinUserGradeRepository, UserRepository userRepository) {
        this.joinUserGradeRepository = joinUserGradeRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity listGrades(Integer id){
        Map<REnum, Object> hm = new LinkedHashMap<>();
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            List<JoinUserGrade> grades = joinUserGradeRepository.listGradeByUser(id);
            List<Integer> ls = new ArrayList<>();
            for (JoinUserGrade grade : grades){
                ls.add(grade.getExam_grade());
            }
            int exam1 = ls.get(0);
            int exam2 = ls.get(1);
            int exam3 = ls.get(2);
            int exam4 = ls.get(3);

            int result = avarageGrade(ls.get(0), ls.get(1), ls.get(2), ls.get(3));
            if (result>=50){
                hm.put(REnum.status, true);
                hm.put(REnum.result, grades);
                hm.put(REnum.avarage, result);
                hm.put(REnum.passedOrFailed, "Passed! Successful!");
            }else {
                hm.put(REnum.status, true);
                hm.put(REnum.result, grades);
                hm.put(REnum.avarage, result);
                hm.put(REnum.passedOrFailed, "Failed! Unsuccessful!");
            }
            return new ResponseEntity(hm, HttpStatus.OK);
        }else {
            hm.put(REnum.status, false);
            hm.put(REnum.message, "There is no user with this id.");
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
    }
    private Integer avarageGrade(int exam1, int exam2, int exam3, int exam4){
        int sum = exam1+exam2+exam3+exam4;
        int avarage = sum/4;
        return avarage;
    }

}
