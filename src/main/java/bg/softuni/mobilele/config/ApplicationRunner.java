package bg.softuni.mobilele.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
//private PasswordEncoder passwordEncoder;
//
//    public ApplicationRunner(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(passwordEncoder.encode("topsecret"));
    }
}
