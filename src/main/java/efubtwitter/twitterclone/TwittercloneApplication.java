package efubtwitter.twitterclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TwittercloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwittercloneApplication.class, args);
	}

}
