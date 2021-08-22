package com.example.springbootmongodbworkshop.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    private String id;
    private String name;
    private String email;
}
