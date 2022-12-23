package com.kvnbg.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Comment {

    @Id
    private String id;
    private String text;
    private String post;
    private Profile profile;
    private List<String> likes;
    private List<String> comments;
}
