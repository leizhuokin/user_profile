package cn.edu.zut.userprofile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("cn.edu.zut.userprofile.mapper")
public class UserProfileManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProfileManagerApplication.class, args);
    }

}
