package com.sudal.springexample.jpa.domain;

import jakarta.persistence.*;
import lombok.*;
import org.apache.ibatis.annotations.Update;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder(toBuilder = true) // 빌더 패턴 (toBuilder : 특정 객체 수정을 빌터 패턴으로 가능)
@NoArgsConstructor //기본생성자 추가
@AllArgsConstructor // 생성자 추가
@Getter
@Table(name="`new_student`")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String dreamJob;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
