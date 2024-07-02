package bg.softuni.mobilele.serveces;

import bg.softuni.mobilele.models.entities.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import bg.softuni.mobilele.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;


import java.util.List;

public class MobileLeUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MobileLeUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return userRepository.findByEmail(email)
                .map(MobileLeUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("UserEntity " + email + " not found!"));
    }

    private static UserDetails map(UserEntity userEntity) {
        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of())
                .disabled(false)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
