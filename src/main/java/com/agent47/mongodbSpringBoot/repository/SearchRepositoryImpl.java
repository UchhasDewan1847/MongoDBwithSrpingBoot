package com.agent47.mongodbSpringBoot.repository;

import com.agent47.mongodbSpringBoot.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository

public class SearchRepositoryImpl implements SearchRepository{
    @Autowired
    private MongoClient mongoClient;
    @Autowired
    private MongoConverter mongoConverter;
    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("MongoTesting");
        MongoCollection< Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", "Expert")
                                        .append("path", "profile"))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 2L)));
        result.forEach(document -> posts.add(mongoConverter.read(Post.class,document)));
        return posts;
    }
}
