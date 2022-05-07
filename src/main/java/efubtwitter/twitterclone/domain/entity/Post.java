package efubtwitter.twitterclone.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue
    private Long postNumber;

    @ManyToOne
    @JoinColumn(name = "userNumber", nullable = false)
    private User user;

    @Column(length = 280, nullable = false)
    private String contents;

    private LocalDateTime postAt;

    @PrePersist
    public void postAt(){
        this.postAt = LocalDateTime.now();
    }


    @Builder
    public Post(User user, LocalDateTime postAt, String contents){
        this.user = user;
        this.postAt = postAt;
        this.contents = contents;
    }

}
