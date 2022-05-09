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
    public PostReqDto(Long userNumber,  String contents){
        this.userNumber = userNumber;
        this.contents = contents;
    }

    public Post toEntity(UserRepository userRepository) {
        return Post.builder()
                .userNumber(userNumber)
                .contents(contents)
                .build();
    }

}


