package com.sudal.springexample.jpa.service;

import com.sudal.springexample.jpa.domain.Student;
import com.sudal.springexample.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(
            String name
            , String phoneNumber
            , String email
            , String dreamJob
    ){

        Student student = Student.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .dreamJob(dreamJob)
                .build();

        Student result = studentRepository.save(student);
        return result;

    }

    public Student updateStudent(int id, String dramJob){

        // 수정 행 조회
        // 조회 된 객체 얻어오기
        // 객체 수정사항 적용
        // 수정된 객체를 저장

        // Optional
        // null일수도 있는 객체를 감싸 놓은 객체
        // null과 관련된 처리를 위한 기능이 포함 되어있음
        // null인 객체 변수를 다루는 과정에서 NullFointerException의 위험을 줄이기 위한 용도.
        // null을 리턴할 수도 있는 메서드에서 리턴 타입으로 활용
        // (내가 리턴할 객체가 null일수 있으니 조심해서 다뤄라는것을 알려주려는 목적임)
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()){
            //true면 null이 아니다.
            Student student = optionalStudent.get();
            student = student.toBuilder().dreamJob(dramJob).build(); //수정된 새로운 객체를 만들어서 덮어 씌우기

            Student result = studentRepository.save(student);

            return result;
        } else{
            // false면 null이다
            return null;
        }
    }

    public void deleteStudent(int id) {
        // 삭제할 대상 행 조회
        // 조회된 객체로 삭제

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
        }
    }
}
