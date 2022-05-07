package efubtwitter.twitterclone.dto;

import efubtwitter.twitterclone.domain.entity.Post;
import efubtwitter.twitterclone.domain.repository.UserRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostReqDto {
    private Long userNumber;
    private LocalDateTime postAt;
    private String contents;

    @Builder
    public PostReqDto(Post post){
        userNumber = new UserResDto().getUserNumber();
        postAt = post.getPostAt();
        contents = post.getContents();
    }

    public Post toEntity(UserRepository userRepository) {
        return Post.builder()
                .user(userRepository.findById(userNumber).orElseThrow(RuntimeException::new))
                .postAt(postAt)
                .contents(contents)
                .build();
    }

}


