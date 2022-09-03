package com.example.javachallengeprog;

import com.example.javachallengeprog.dto.CouponDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        String str = "test";
        Optional<String> strOptional = Optional.of(str);

        System.out.println("strOptional: " + strOptional.get());


        // 실제로 null 값이 들어오면
//        String nullStr = null;
//
//        Optional<String> nullStrOptional = Optional.ofNullable(nullStr);
////        Optional<String> nullStrOptional = Optional.empty();
//        System.out.println(nullStrOptional.orElseGet(() -> "null"));
//        nullStrOptional.orElseThrow(() -> new NullPointerException("null is comming!"));
//
//        Optional<String> any = Arrays.asList("dsg", "bhk").stream()
//                .findFirst(); // findAny() 병렬시 차이가 남!


        List<Integer> arrInts = Arrays.asList(1, 2, 3, 4, 5, 6);

//        1) 연산
        Integer reduce = arrInts.stream()
                .filter(i -> i % 2 == 0)
                .peek(System.out::println)
                .reduce(0, Integer::sum);

//        2) 데이터 파싱

        List<String> arrString = Arrays.asList("1", "2", "3", "4", "5", "6");

        System.out.println("reduce: "+ reduce);

        arrString.stream()
                        .mapToInt(Integer::parseInt)
//                        .peek(System.out::println)
                        .filter(i -> i%2 ==1)
                        .forEach(System.out::println);

//        3) Dto 다루나?
        List<CouponDto> collect = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> CouponDto.builder()
                        .title("title_" + i)
                        .content("content_" + i)
                        .beginDt("2020-08-22")
                        .endDt("2020-08-27")
                        .build()).collect(Collectors.toList());

        System.out.println("collect: "+ collect);

        String strTest = "test";

        boolean hasText = StringUtils.hasText(strTest);
        System.out.println("hasText: "+ hasText);

    }

}
