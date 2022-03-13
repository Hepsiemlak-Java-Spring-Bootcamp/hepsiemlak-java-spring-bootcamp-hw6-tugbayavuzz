package emlakburada;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.model.enums.UserType;
import emlakburada.repository.UserRepository;
import emlakburada.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup() {

        Mockito
                .when(userRepository.findAll())
                .thenReturn(prepareMockUserList());

    }

    private List<User> prepareMockUserList() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(UserType.INDIVIDUAL, "cem", "cem@patika.com"));
        userList.add(new User(UserType.INDIVIDUAL, "emre", "emre@patika.com"));
        return userList;
    }


    @Test
    void whenGetAllUser_thenReturnTrue() {

        List<UserResponse> allUser = userService.getAllUser();

        assertNotNull(allUser);

        assertThat(allUser.size()).isNotZero();
    }

    @Test
    void whenSaveUser_thenReturnTrue() {

        userService.saveUser(prepareUser());

        Mockito.verify(userRepository).save(any());

    }

    @Test
    void whenUpdateUsers_thenReturnTrue() {
        UserRequest userRequest = prepareUserRequest();
        Mockito
                .when(userRepository.save(any()))
                .thenReturn(prepareUser());
        UserResponse userResponse = userService.updateUser(userRequest);
        assertEquals("tugbaa", userResponse.getName());
    }


    @Test
    void whenDeleteUserById_thenReturnTrue() {
        Mockito
                .doNothing().when(userRepository)
                .deleteById(1);
        userService.deleteUser(1);
        verify(userRepository).deleteById(1);
    }


    private UserRequest prepareUserRequest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserType(UserType.INDIVIDUAL);
        userRequest.setEmail("tyvz@yandexx.com");
        userRequest.setName("tugba");
        return userRequest;
    }

    private UserRequest prepareUser() {
        return new UserRequest(UserType.INDIVIDUAL, "tugba", "yvz@yandex.com");
    }

}
