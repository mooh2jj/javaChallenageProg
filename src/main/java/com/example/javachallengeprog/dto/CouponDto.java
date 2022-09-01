package com.example.javachallengeprog.dto;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponDto {

    private String title;
    private String content;
    private String beginDt;
    private String endDt;

    @Builder
    public CouponDto(String title, String content, String beginDt, String endDt ) {
        this.title = title;
        this.content = content;
        this.beginDt = beginDt;
        this.endDt = endDt;
    }

    @Getter
    @RequiredArgsConstructor
    public enum CouponStatus {

        ENABLE("사용가능"),
        UNABLE("사용불가");

        private final String description;

    }

    @Getter
    @NoArgsConstructor
    public static class CouponDetails{

        private String title;
        private String content;
        private String beginDt;
        private String endDt;
        private CouponStatus couponStatus;

        @Builder
        public CouponDetails(
                String title,
                String content,
                String beginDt,
                String endDt,
                CouponStatus couponStatus
        ) {

            this.title = title;
            this.content = content;
            this.beginDt = beginDt;
            this.endDt = endDt;
            this.couponStatus = couponStatus;
        }
    }
}
