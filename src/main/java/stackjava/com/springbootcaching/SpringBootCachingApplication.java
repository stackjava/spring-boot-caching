package stackjava.com.springbootcaching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import stackjava.com.springbootcaching.services.UserService;

@SpringBootApplication
@EnableCaching
public class SpringBootCachingApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootCachingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCachingApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) {
        logger.info("find user with id = 1: {}", userService.findUserById(1));
        logger.info("find user with id = 1: {}", userService.findUserById(1));
        logger.info("find user with id = 2: {}", userService.findUserById(2));
        logger.info("find user with id = 2: {}", userService.findUserById(2));
        logger.info("find user with id = 1: {}", userService.findUserById(1));
    }
}
