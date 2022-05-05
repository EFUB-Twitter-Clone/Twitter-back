package efubtwitter.twitterclone.domain.repository;

import efubtwitter.twitterclone.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
