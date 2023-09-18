package com.example.javachallengeprog.entity;

import com.example.javachallengeprog.enums.Gender;
import lombok.*;

import java.util.*;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@Data
@Value // final 필드만 가지고 생성자, getter, equals, hashCode, toString 메소드를 만들어준다.
public class Person {

    private final String name;
    //    private String address;
    private final Gender gender;
    private final Set<String> phoneNumberList;

    public Person(String name) {
        this.name = name;
        this.gender = Gender.FEMALE;
        this.phoneNumberList = new HashSet<>();
    }

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.phoneNumberList = new HashSet<>();
    }

    public void addPhoneNumber(String phoneNumber) {
        // phoneNumber 정규표현식 010-8810-1234 같은 형식이어야 한다.
        String regex = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("전화번호 형식이 올바르지 않습니다.");
        }
        this.phoneNumberList.add(phoneNumber);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name) && Objects.equals(phoneNumberList, person.phoneNumberList);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, phoneNumberList);
//    }
}
