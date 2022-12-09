package com.kvnbg.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Post {

    @Id
    private String id;
    private String text;
    private Profile profile;
    private List<String> likes;
    private List<String> comments;
}
