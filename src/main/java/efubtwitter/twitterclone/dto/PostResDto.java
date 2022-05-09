package efubtwitter.twitterclone.dto;

import efubtwitter.twitterclone.domain.entity.Post;
import efubtwitter.twitterclone.domain.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResDto {
    private Long postNumber;
    private Long userNumber;
    private LocalDateTime postAt;
    private String contents;

    public PostResDto(Post post){
        this.postNumber = post.getPostNumber();
        this.userNumber = post.getUserNumber();
        this.postAt = post.getPostAt();
        this.contents = post.getContents();
    }


}
