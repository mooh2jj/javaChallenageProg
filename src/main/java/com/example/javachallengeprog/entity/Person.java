package com.example.javachallengeprog.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
//@EqualsAndHashCode
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phoneNumberList, person.phoneNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumberList);
    }
}
