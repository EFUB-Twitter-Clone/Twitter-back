package efubtwitter.twitterclone.controller;

import efubtwitter.twitterclone.domain.entity.Post;
import efubtwitter.twitterclone.dto.PostReqDto;
import efubtwitter.twitterclone.dto.PostResDto;
import efubtwitter.twitterclone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    ResponseEntity<?> createPost(@RequestBody PostReqDto postReqDto){
        return new ResponseEntity<>(postService.createPost(postReqDto), HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<?> findPosts(){
        return new ResponseEntity<>(postService.getPostList(), HttpStatus.OK);
    }

    @GetMapping("/{userNumber}")
    ResponseEntity<?> findPostByNumber(@PathVariable Long userNumber){
        return new ResponseEntity<>(postService.getPostListByUser(userNumber), HttpStatus.OK);
    }

    @DeleteMapping("/{postNumber}")
    ResponseEntity<?> deletePost(@PathVariable Long postNumber){
        postService.deletePost(postNumber);
        return new ResponseEntity<>("delete success", HttpStatus.OK);
    }

}
