package com.example.springbootmongodbworkshop.service;
import com.example.springbootmongodbworkshop.domain.Post;
import com.example.springbootmongodbworkshop.domain.User;
import com.example.springbootmongodbworkshop.dto.UserDTO;
import com.example.springbootmongodbworkshop.exception.ObjectNotFoundException;
import com.example.springbootmongodbworkshop.repository.PostRepository;
import com.example.springbootmongodbworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findbyId(String id){
        Optional<Post> post = postRepository.findById(id);
        if(!post.isPresent()){
            throw new ObjectNotFoundException("Post não encontrado");

        }

        return post.get();
    }

    public List<Post> findByTitleContaining(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }


}
