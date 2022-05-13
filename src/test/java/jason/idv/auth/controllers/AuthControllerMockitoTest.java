package jason.idv.auth.controllers;

import jason.idv.auth.facades.AuthFacade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerMockitoTest {

    private final static String PASSWORD = "abcd1234";

    @Mock
    private AuthFacade authFacade;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        when(authFacade.verifyPassword(PASSWORD)).thenReturn(true);
    }

    @Test
    public void shouldReturnTrue(){
        when(authFacade.verifyPassword(PASSWORD)).thenReturn(true);
        boolean response = authController.verifyPassword(PASSWORD);
        Assertions.assertThat(response).isTrue();
    }
}
