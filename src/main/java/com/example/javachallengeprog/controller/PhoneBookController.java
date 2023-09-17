package com.example.javachallengeprog.controller;

import com.example.javachallengeprog.dto.PersonReqDto;
import com.example.javachallengeprog.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class PhoneBookController {


    // 전화번호부 만들기
    // 1. 전화번호부에 사람을 추가할 수 있다.
    // 2. 사람은 이름과 전화번호를 가진다.
    // 3. 전화번호는 010-1234-5678과 같은 형식이다.
    // 4. 전화번호부에 있는 사람의 이름으로 검색할 수 있다.
    List<Person> personList = new ArrayList<>();

    public PhoneBookController() {
        // 기본적으로 몇 명의 초기 사람을 추가하고 시작합니다.
        Person person1 = new Person("홍길동");
        person1.addPhoneNumber("010-1234-5678");
        person1.addPhoneNumber("010-1234-5679");
        personList.add(person1);

        Person person2 = new Person("김철수");
        person2.addPhoneNumber("010-5555-5555");
        personList.add(person2);

        Person person3 = new Person("김영희");
        person3.addPhoneNumber("010-9999-9999");
        personList.add(person3);
    }

    @PostMapping("/add")
    public List<Person> addNumber(
            @RequestBody PersonReqDto personReqDto
    ) {
        log.info("personReqDto: {}", personReqDto);
        Person person = new Person(personReqDto.getName());
        person.addPhoneNumber(personReqDto.getPhoneNumber());
        personList.add(person);
        return personList;
    }

    @GetMapping("/search")
    public List<Person> search(
            @RequestParam String name
    ) {
        log.info("name: {}", name);
        // name에 숫자 또는 특수문자 포함 안돼, 영어, 한글만 되야
        String regex = "[a-zA-Z가-힣]*$";
        if(!name.matches(regex)) {
            throw new IllegalArgumentException("이름 형식이 맞지 않습니다.");
        }
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (person.getName().toLowerCase().equals(name.toLowerCase().trim())) {
                result.add(person);
            }
        }
        return result;
    }


}
