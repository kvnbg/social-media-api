package com.kvnbg.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document
public class User {

    @Id
    private String id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
}
