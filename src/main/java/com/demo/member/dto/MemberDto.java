package com.demo.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public class MemberDto {

    @NoArgsConstructor
    @Getter
    public static class CreateReq {
        @NotBlank
        private String name;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    @NoArgsConstructor
    public static class CreateRes {
        private Long id;
        private String name;
    }
}
