package com.example.springbootmongodbworkshop.resources;

import com.example.springbootmongodbworkshop.domain.Post;
import com.example.springbootmongodbworkshop.resources.util.URL;
import com.example.springbootmongodbworkshop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullsearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {
        text = URL.decodeParam(text);
        Date min  = URL.convertDate(minDate, new Date(0L));
        Date max  = URL.convertDate(maxDate, new Date(0L));
        return ResponseEntity.ok().body(postService.fullSearch(text, min, max));
    }

}
