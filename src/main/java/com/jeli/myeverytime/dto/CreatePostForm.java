package com.jeli.myeverytime.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostForm {
    private String type;
    private String title;
    private String contents;
}
