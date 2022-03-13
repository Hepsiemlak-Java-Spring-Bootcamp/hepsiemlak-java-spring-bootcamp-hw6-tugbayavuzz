package emlakburada;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.entity.User;
import emlakburada.entity.enums.UserType;
import emlakburada.repository.AuthRepository;
import emlakburada.service.AuthService;
import emlakburada.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthRepository authRepository;

    @Mock
    private JwtUtil jwtUtil;

    @BeforeEach
    void init() {
        Mockito.when(authRepository.findByEmail("tugba@yandex.com")).thenReturn(prepareUser());
    }

    private User prepareUser() {
        User user = new User();
        user.setEmail("tugba@yandex.com");
        user.setUserType(UserType.INDIVIDUAL);
        user.setPassword("12345");
        return user;
    }

    private AuthRequest prepareAuthRequest() {

        return new AuthRequest("tugba@yandex.com", "12345");
    }

    private String jwtToken() {

        return jwtUtil.generateToken(prepareUser());
    }

    @Test
    void auth() throws Exception {

        AuthResponse response = authService.getToken(prepareAuthRequest());
        assertEquals(jwtToken(), response.getToken());

    }
}
