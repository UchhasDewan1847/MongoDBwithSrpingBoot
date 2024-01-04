package com.agent47.mongodbSpringBoot.repository;

import com.agent47.mongodbSpringBoot.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
