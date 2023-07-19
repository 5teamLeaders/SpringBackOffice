package com.example.springbackoffice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto {
    private String msg;
    private Integer statusCode;
}
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto {

    private int status;
    private String message;
    private Object data;

    public ApiResponseDto(int status, String message) { // data까지 보내지 않을 때
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public ApiResponseDto(int status,String message, Object data) { // data까지 실어보낼 때
        this.status = status;
        this.message = message;
        this.data = data;
    }
}


