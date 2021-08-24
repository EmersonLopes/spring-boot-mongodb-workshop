package com.example.springbootmongodbworkshop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandartError {

    private Long timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
