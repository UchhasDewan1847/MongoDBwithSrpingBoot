package com.agent47.mongodbSpringBoot.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Setter
@Getter
@Document(collection = "JobPost")
public class Post {
    @Id
    private String id;
    private String desc;
    private String[] techs;
    private String profile;
    private Integer exp;

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "desc='" + desc + '\'' +
                ", tech=" + Arrays.toString(techs) +
                ", profile='" + profile + '\'' +
                ", exp=" + exp +
                '}';
    }
}
