package efubtwitter.twitterclone.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserReqDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    private String readme;
    @NotBlank
    private String userId;

    @Builder
    public UserReqDto(Long id, String name, String readme, String userId){
        this.id = id;
        this.name = name;
        this.readme = readme;
        this.userId = userId;
    }
}
