package com.example.springbootmongodbworkshop.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document
public class User {

    @Id
    private String id;
    private String name;
    private String email;
}
