package efubtwitter.twitterclone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResDto {
    private Long id;
    private String userId;
    private String name;
    private String readme;

    @Builder
    public UserResDto(Long id, String userId, String name, String readme){
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.readme = readme;
    }
}
