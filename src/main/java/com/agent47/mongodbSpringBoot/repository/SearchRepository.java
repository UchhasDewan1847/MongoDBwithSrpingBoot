package com.agent47.mongodbSpringBoot.repository;

import com.agent47.mongodbSpringBoot.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
