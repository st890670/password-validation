package jason.idv.auth.controller;

import jason.idv.auth.entity.PasswordResult;
import jason.idv.auth.facade.AuthFacade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerMockitoTest {

  private static final String PASSWORD = "abcd1234";

  @Mock private AuthFacade authFacade;

  @InjectMocks private AuthController authController;

  @BeforeEach
  void setUp() {
    when(authFacade.verifyPassword(anyString())).thenReturn(new PasswordResult(true, List.of()));
  }

  @Test
  public void shouldReturnPasswordResult() {
    PasswordResult result = authController.verifyPassword(PASSWORD);
    Assertions.assertThat(result).isExactlyInstanceOf(PasswordResult.class);
  }
}
