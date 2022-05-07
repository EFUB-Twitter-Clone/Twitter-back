package efubtwitter.twitterclone.service;

import efubtwitter.twitterclone.domain.entity.Post;
import efubtwitter.twitterclone.domain.entity.User;
import efubtwitter.twitterclone.domain.repository.PostRepository;
import efubtwitter.twitterclone.domain.repository.UserRepository;
import efubtwitter.twitterclone.dto.PostReqDto;
import efubtwitter.twitterclone.dto.PostResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 트윗 작성
    @Transactional
    public Long createPost(PostReqDto postReqDto){
        Post post = postReqDto.toEntity(userRepository);
        postRepository.save(post);
        return post.getPostNumber();
    }

    // 트윗 전체 조회
    @Transactional
    public List<PostResDto> getPostList() {
        List<Post> postList = postRepository.findAll();
        List<PostResDto> postResDtoList = new ArrayList<>();
        for (Post post : postList) {
            PostResDto postResDto = new PostResDto(post);
            postResDtoList.add(postResDto);
        }
        return postResDtoList;
    }

    // 트윗 userNumber로 조회
    @Transactional
    public List<PostResDto> findAllById(Long userNumber) {
        List<Post> postList = postRepository.findByNumber(userNumber);
        List<PostResDto> postResDtoList = new ArrayList<>();
        for (Post post : postList) {
            PostResDto postResDto = new PostResDto(post);
            postResDtoList.add(postResDto);
        }
        return postResDtoList;

    }

    //트윗 postNumber로 삭제
    @Transactional
    public void deletePost(Long postNumber){
//        User user = postRepository.findById(userNumber).get().getUser();
//        if (userNumber == user.getUserNumber())
            postRepository.deleteById(postNumber);
    }
}

