package com.example.javachallengeprog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaChallengeProApplication {

    public static void main(String[] args) {

//        String ab = "";
//        StringBuffer sbf = new StringBuffer("");
//        StringBuilder sbr = new StringBuilder("");
//
//        // StringBuffer vs StringBuilder 차이 동기화블록 schronized
//
//        // String => StringBuilder
//        // for문 => x => Stream API
//
//        long start1 = System.currentTimeMillis();
//        for(int i =0; i<100000; i++){
//            ab += "hello";
//
//        }
//        long end1 = System.currentTimeMillis();
//
//        long start2 = System.currentTimeMillis();
//        for(int i =0; i<100000; i++){
//            sbf.append("hello");
//
//        }
//        long end2 = System.currentTimeMillis();
//
//        long start3 = System.currentTimeMillis();
//        for(int i =0; i<100000; i++){
//            sbr.append("hello");
//
//        }
//        long end3 = System.currentTimeMillis();
//
//
//        System.out.println("1ab: "+(end1-start1));  // 4849 => 4.849초
//        System.out.println("2ab: "+(end2-start2));  // 11 => 0.011초
//        System.out.println("3ab: "+(end3-start3));  // 6 => 0.006초


//        System.out.println("안녕하세요. 자바챌린지 스터디 모임 여러분!");
        SpringApplication.run(JavaChallengeProApplication.class, args);
    }

}
