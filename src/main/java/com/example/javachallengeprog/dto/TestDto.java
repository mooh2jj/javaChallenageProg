package com.example.javachallengeprog.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class TestDto {

    private String testName;
    private String content;

    private String phone;

    private String createdDt;

    @Builder
    public TestDto(String testName, String content, String phone, String createdDt) {
        this.testName = testName;
        this.content = content;
        this.phone = phone;
        this.createdDt = createdDt;
    }
}
