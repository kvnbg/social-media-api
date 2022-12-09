package com.kvnbg.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Profile {

    @Id
    private String id;
    private String name;
    private String user;
    private List<String> posts;
    private List<String> followers;
    private List<String> following;
}
