package bg.softuni.mobilele.config;

import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.session.MobileLeUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                authorizeHttpRequests -> authorizeHttpRequests
                        // all static resources are available to anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/users/login", "/users/login-error", "users/register", "/offers/all", "/brands/all", "/offers/{id}").permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(formLogin -> {
                    formLogin
                            // redirect here when we access something that is not allowed.
                            .loginPage("/users/login")
                            // The names of the input fields (auth-login.html)
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/", true)
                            .failureForwardUrl("/users/login-error");
                })
                .logout(logout -> {
                    logout.logoutUrl("/users/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true);
                }).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Bean
    public MobileLeUserDetailsService userDetailsService(UserRepository userRepository) {
        return new MobileLeUserDetailsService(userRepository);
    }
}
