package com.example.javachallengeprog.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Stduent {

    private String name;
    private int age;

    List<Subject> subjectList = new ArrayList<>();

    public void print(int age) {
        if (age > 10) {
            this.age = 10;
            System.out.println("아! 10이상 넘으시면 10이죠!");
        }
    }

    public void addSubject(String subjectName, int score) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subject.setScore(score);

        subjectList.add(subject);
    }

}
