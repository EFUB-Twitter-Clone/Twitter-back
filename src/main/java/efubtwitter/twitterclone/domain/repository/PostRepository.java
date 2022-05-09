package efubtwitter.twitterclone.domain.repository;

import efubtwitter.twitterclone.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //List<Post> findByUserNumber(Long UserNumber);
    //Optional<Post> findByUserNumber(Long userNumber);
    void deleteByPostNumber(Long postNumber);

    //List<Post> findAllByUserNumber(Long user);
    List<Post> findAllByUserNumber(Long userNumber);


}
