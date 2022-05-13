package jason.idv.auth.controller;

import jason.idv.auth.controllers.AuthController;
import jason.idv.auth.facade.AuthFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThat(String.valueOf(response)).isEqualTo("true");
    }
}
