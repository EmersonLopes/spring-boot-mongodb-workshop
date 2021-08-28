package com.example.springbootmongodbworkshop.resources;

import com.example.springbootmongodbworkshop.domain.Post;
import com.example.springbootmongodbworkshop.domain.User;
import com.example.springbootmongodbworkshop.dto.UserDTO;
import com.example.springbootmongodbworkshop.resources.util.URL;
import com.example.springbootmongodbworkshop.service.PostService;
import com.example.springbootmongodbworkshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post post = postService.findbyId(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitleContaining(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);

        return ResponseEntity.ok().body(postService.findByTitleContaining(text));
    }

}
