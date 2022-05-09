package efubtwitter.twitterclone.controller;

import efubtwitter.twitterclone.dto.UserReqDto;
import efubtwitter.twitterclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/{userNumber}")
    ResponseEntity<?> updateUser(@PathVariable("userNumber") Long userNumber, @RequestBody UserReqDto userDto){
        if(userService.update(userDto, userNumber))
            return new ResponseEntity<>("update success", HttpStatus.OK);
        return new ResponseEntity<>("duplicated id", HttpStatus.OK);
    }

    @GetMapping("/{userNumber}")
    ResponseEntity<?> getUser(@PathVariable("userNumber") Long userNumber){
        return new ResponseEntity<>(userService.getUser(userNumber), HttpStatus.OK);
    }
}
