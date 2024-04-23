package bg.softuni.mobilele.serveces;

import bg.softuni.mobilele.models.dtos.UserLoginDTO;
import bg.softuni.mobilele.models.dtos.UserRegisterDTO;
import bg.softuni.mobilele.models.entities.User;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean isLoggedIn(UserLoginDTO userLoginDTO) {
        Optional<User> byEmail = this.userRepository.findByEmail(userLoginDTO.getUsername());

        if (byEmail.isEmpty()) {
            LOGGER.info("User with name {} not fount", userLoginDTO.getUsername());
            return false;
        }

        boolean success = byEmail.get().getPassword().equals(userLoginDTO.getPassword());

        if (success) {
            login(byEmail.get());
        } else {
            logout();
        }
        return success;
    }

    public void login(User user) {
        currentUser.setLoggedIn(true)
                .setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }

    public void register(UserRegisterDTO userRegisterDTO) {
        Optional<User> optUser = this.userRepository.findByEmail(userRegisterDTO.getUsername());

        if (optUser.isPresent()) {
            LOGGER.info("User " + userRegisterDTO.getUsername() + " already exist");
        }



    }
}
