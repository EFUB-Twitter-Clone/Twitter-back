package efubtwitter.twitterclone.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String name;
    private String readme;

    @Builder
    public User(Long id, String userId, String name, String readme){
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.readme = readme;
    }
}
