package emlakburada.service;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends UserBaseService {

    @Autowired
    private UserRepository userRepository;

    //gel all users
    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> convertToUserEntity(user)).collect(Collectors.toList());
    }

    //create user
    public UserResponse saveUser(UserRequest userRequest) {
        User user = userRepository.save(userRequest.getUser());
        return convertToUserEntity(user);
    }

    //delete user
    public void deleteUser(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
        }
    }

    //find by id user
    public UserResponse getUserByUserId(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            UserResponse userResponse = new UserResponse();
            userResponse.setUser(null);
            return userResponse;
        }

        return convertToUserEntity(user.get());
    }

    public UserResponse updateUser(UserRequest userRequest) {
        Optional<User> user = userRepository.findById(userRequest.getUser().getId());
        User updatedUser = userRepository.save(userRequest.getUser());
        return convertToUserEntity(updatedUser);
    }


}
