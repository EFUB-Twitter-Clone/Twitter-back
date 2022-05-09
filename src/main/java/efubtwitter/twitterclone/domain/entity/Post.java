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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNumber;

    @JoinColumn(name = "userNumber", nullable = false)
    //private User user;
    private Long userNumber;

    @Column(length = 280, nullable = false)
    private String contents;

    @Column(nullable = false)
    private LocalDateTime postAt;

    @PrePersist
    public void createDate(){
        this.postAt = LocalDateTime.now();
    }


    @Builder
    public Post(Long userNumber, LocalDateTime postAt, String contents){
        this.userNumber = userNumber;
        this.postAt = postAt;
        this.contents = contents;
    }

}
