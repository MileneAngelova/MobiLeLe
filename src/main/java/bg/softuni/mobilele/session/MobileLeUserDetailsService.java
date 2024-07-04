package bg.softuni.mobilele.session;

import bg.softuni.mobilele.models.entities.UserEntity;
import bg.softuni.mobilele.models.entities.UserRole;
import bg.softuni.mobilele.models.enums.RoleEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
//        return User
//                .withUsername(userEntity.getEmail())
//                .password(userEntity.getPassword())
//                .authorities(List.of())
//                .disabled(false)
//                .build();
        return new MobileleUserDetails(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map(UserRole::getRole).map(MobileLeUserDetailsService::map).toList(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );
    }

    private static GrantedAuthority map(RoleEnum roleEnum) {
        return new SimpleGrantedAuthority("ROLE_" + roleEnum);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
