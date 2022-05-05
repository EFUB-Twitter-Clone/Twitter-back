package efubtwitter.twitterclone.service;

import efubtwitter.twitterclone.domain.entity.User;
import efubtwitter.twitterclone.domain.repository.UserRepository;
import efubtwitter.twitterclone.dto.UserReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean update(UserReqDto userDto, Long userNumber){
        if (!findDuplicatedId(userDto.getUserId())){        //중복 id가 없는 경우
            Optional<User> optionalUser = userRepository.findById(userNumber);
            optionalUser.ifPresent(user -> user.updateProfile(
                    userDto.getName(),
                    userDto.getReadme(),
                    userDto.getUserId()));
            return true;
        }
        return false;       //중복 id가 있는 경우
    }

    private boolean findDuplicatedId(String userId){
        return userRepository.findByUserId(userId).isPresent();
    }
}
