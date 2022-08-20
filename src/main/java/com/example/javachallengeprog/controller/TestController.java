package com.example.javachallengeprog.controller;

import com.example.javachallengeprog.dto.Stduent;
import com.example.javachallengeprog.dto.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @PostMapping("/post")
    public Stduent posttest(@RequestBody Stduent requestDto) {

        System.out.println("posttest == start!!!==");

//        단순 조건문 -> 도메인으로 로직 이동 가능
//        if (requestDto.getAge() > 10) {
//            requestDto.setAge(10);
//            System.out.println("아! 10이상 넘으시면 10이죠!");
//        }



//        도메인 주도 패턴 방식
        requestDto.print(requestDto.getAge());

        requestDto.addSubject("수학", 70);
        requestDto.addSubject("영어", 100);
        requestDto.addSubject("국어", 80);
//        System.out.println("requestDto: " + requestDto);

//        stream API 필터링
//        requestDto.getSubjectList().stream()
//                .filter(s -> s.getSubjectName().contains("수"))
//                .forEach(System.out::println);

        List<Subject> subjectList = requestDto.getSubjectList().stream()
                .filter(s -> s.getScore() > 70)
                .peek(System.out::println)
                .collect(Collectors.toList());

        requestDto.setSubjectList(subjectList);

        return requestDto;

    }

}
