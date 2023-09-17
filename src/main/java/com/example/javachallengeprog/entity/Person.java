package com.example.javachallengeprog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Person {

    private String name;
    private List<String> phoneNumberList;

    public Person(String name) {
        this.name = name;
        this.phoneNumberList = new ArrayList<>();
    }

    public void addPhoneNumber(String phoneNumber) {
        // phoneNumber 정규표현식 010-8810-1234 같은 형식이어야 한다.
        String regex = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("전화번호 형식이 올바르지 않습니다.");
        }
        this.phoneNumberList.add(phoneNumber);
    }
}
