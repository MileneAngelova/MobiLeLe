package bg.softuni.mobilele.serveces;

import bg.softuni.mobilele.models.dtos.UserLoginDTO;
import bg.softuni.mobilele.models.dtos.UserRegisterDTO;
import bg.softuni.mobilele.models.entities.User;
import bg.softuni.mobilele.models.mapper.UserMapper;
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
    private final UserMapper userMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, CurrentUser currentUser, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userMapper = userMapper;
    }

    public boolean isLoggedIn(UserLoginDTO userLoginDTO) {
        Optional<User> byEmail = this.userRepository.findByEmail(userLoginDTO.getEmail());

        if (byEmail.isEmpty()) {
            LOGGER.info("User with name {} not fount", userLoginDTO.getEmail());
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
                .setName(user.getFirstName() + " " + user.getLastName())
                .setEmail(user.getEmail());
    }

    public void logout() {
        currentUser.clear();
    }

    public void register(UserRegisterDTO userRegisterDTO) {
        User newUser = userMapper.userDtoToUser(userRegisterDTO);
        newUser.setPassword(userRegisterDTO.getPassword());
//        Optional<User> optUser = this.userRepository.findByEmail(userRegisterDTO.getEmail());
//
//        if (optUser.isPresent()) {
//            LOGGER.info("User " + userRegisterDTO.getEmail() + " already exist");
//        }
//
//        User newUser = new User()
//                .setEmail(userRegisterDTO.getEmail())
//                .setPassword(userRegisterDTO.getPassword())
//                .setFirstName(userRegisterDTO.getFirstName())
//                .setLastName(userRegisterDTO.getLastName());
        this.userRepository.save(newUser);
        login(newUser);
    }

    public boolean userExist(String email, String password) {
        Optional<User> byEmail = this.userRepository.findByEmail(email);
        if (byEmail.isPresent() && (byEmail.get().getPassword().equals(password))) {
            currentUser.setLoggedIn(true);
            return true;
        }
       return false;
    }

}
