package efubtwitter.twitterclone.controller;

import efubtwitter.twitterclone.dto.PostReqDto;
import efubtwitter.twitterclone.dto.PostResDto;
import efubtwitter.twitterclone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public String createPost(@RequestBody PostReqDto postReqDto){
        postService.createPost(postReqDto);
        return "created";
    }

    @GetMapping("")
    public List<PostResDto> findAllPost(){
        return postService.getPostList();
    }

    @GetMapping("/{userNumber}")
    public List<PostResDto> findPostByNumber(@PathVariable Long userNumber){
        return postService.findAllById(userNumber);
    }

    @DeleteMapping("/{postNumber}")
    public String deletePost(@PathVariable Long postNumber){
        postService.deletePost(postNumber);
        return "deleted";
    }



}
