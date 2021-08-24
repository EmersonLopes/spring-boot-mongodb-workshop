package com.example.springbootmongodbworkshop.repository;

import com.example.springbootmongodbworkshop.domain.Post;
import com.example.springbootmongodbworkshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
