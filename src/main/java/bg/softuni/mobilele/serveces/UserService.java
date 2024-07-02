package bg.softuni.mobilele.serveces;

import bg.softuni.mobilele.models.dtos.UserRegisterDTO;
import bg.softuni.mobilele.models.entities.UserEntity;
import bg.softuni.mobilele.repositories.UserRepository;
//import bg.softuni.mobilele.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
//    private final CurrentUser currentUser;
//    private final UserMapper userMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
//                       CurrentUser currentUser,
                       ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
//        this.currentUser = currentUser;
//        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

//    public boolean isLoggedIn() {
//        return this.currentUser.isLoggedIn();
//    }

//    public boolean login(UserLoginDTO loginDTO) {
//        Optional<UserEntity> byEmail= this.userRepository.findByEmail(loginDTO.getEmail());
//
//        if (byEmail.isEmpty()) {
//            return false;
//        }
//
//        if (!loginDTO.getPassword().equals(byEmail.get().getPassword())) {
//            return false;
//        }
//        this.currentUser.login(byEmail.get().getId(), loginDTO.getEmail());
//
//        return true;
//    }
//
//    public void logout() {
//        currentUser.clear();
//    }

    public void register(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = this.modelMapper.map(userRegisterDTO, UserEntity.class);
        newUser.setPassword(this.passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);
    }
}