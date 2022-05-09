package efubtwitter.twitterclone.dto;

import efubtwitter.twitterclone.domain.entity.User;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserReqDto {
    @NotBlank
    private String name;
    private String readme;
    @NotBlank
    private String userId;

    @Builder
    public UserReqDto(String name, String readme, String userId){
        this.name = name;
        this.readme = readme;
        this.userId = userId;
    }

    public User toEntity(UserReqDto user){
        return User.builder()
                .name(user.getName())
                .userId(user.getUserId())
                .readme(user.getReadme())
                .build();
    }
}
