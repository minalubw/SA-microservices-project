package saproject.avatar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AvatarApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvatarApplication.class, args);
    }

}
