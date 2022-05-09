package efubtwitter.twitterclone.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue
    private Long userNumber;
    private String userId;
    private String name;
    private String readme;

    @Builder
    public User(Long userNumber, String userId, String name, String readme){
        this.userNumber = userNumber;
        this.userId = userId;
        this.name = name;
        this.readme = readme;
    }

    public void updateProfile(String name, String readme, String userId){
        this.name = name;
        this.readme = readme;
        this.userId = userId;
    }


}
