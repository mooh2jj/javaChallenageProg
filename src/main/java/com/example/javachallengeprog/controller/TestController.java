package com.example.javachallengeprog.controller;

import com.example.javachallengeprog.dto.Stduent;
import com.example.javachallengeprog.dto.Subject;
import com.example.javachallengeprog.dto.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @GetMapping("/get")
    public String get() {
        return "gettest";
    }

    // 생성자 방식, Class A = new Class() => 점진적 생성자 방식
    // 빌더패턴 => 1) static 2) 필드의 제약 순서
    // 빌더패턴 사용 구성 NoArgsCo, AllArgsCo
    @PostMapping("/builderTest")
    public TestDto builderTest(@RequestBody TestDto testDto) {

//        String[] phoneArr = testDto.getPhone().split("-");
//        String phoneJoin = String.join("", phoneArr);

        String replacePhone = testDto.getPhone().replaceAll("-", "");
        String replaceCreatedDt = testDto.getCreatedDt().replaceAll("/", "");

//        => replace -> replaceAll, 데이터파싱의 정수: 정규표현식 ~ 리눅스, String, LocalDateTime

        return TestDto.builder()
                .content(testDto.getContent())
                .testName(testDto.getTestName())
                .phone(replacePhone)
                .createdDt(replaceCreatedDt)
                .build();
    }

    // String += , append()
    // String vs StringBuffer, StringBuilder
    // 상수풀



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

        requestDto.addSubject("Math", 70);
        requestDto.addSubject("영어", 100);
        requestDto.addSubject("Korean", 80);
//        System.out.println("requestDto: " + requestDto);

//        stream API 필터링
//        requestDto.getSubjectList().stream()
//                .filter(s -> s.getSubjectName().contains("수"))
//                .forEach(System.out::println);

        List<Subject> subjectList = requestDto.getSubjectList().stream()
                .filter(s -> s.getScore() > 70)
                .filter(s -> s.getSubjectName().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"))    // 한글만
                .peek(System.out::println)
                .collect(Collectors.toList());

        long count = subjectList.size();
        double average = subjectList.stream()
                .mapToDouble(Subject::getScore)
                .average()
                .orElse(0.0);

        requestDto.setSubjectCount(count);
        requestDto.setSubjectAverage(average);

        requestDto.setSubjectList(subjectList);

        return requestDto;

    }

}
