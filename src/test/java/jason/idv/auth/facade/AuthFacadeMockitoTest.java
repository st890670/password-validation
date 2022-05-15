package jason.idv.auth.facade;

import jason.idv.auth.entity.PasswordResult;
import jason.idv.auth.entity.PasswordRule;
import jason.idv.auth.service.PasswordServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthFacadeMockitoTest {

  private static final String PASSWORD = "abcd1234";

  @Mock private PasswordServiceImpl passwordService;

  @InjectMocks private AuthFacade authFacade;

  @BeforeEach
  void setup() {
    when(passwordService.verify(anyString(), any(PasswordRule.class)))
        .thenReturn(new PasswordResult(true, List.of()));
  }

  @Test
  public void shouldReturnTrue() {
    PasswordResult result = authFacade.verifyPassword(PASSWORD);
    Assertions.assertThat(result).isExactlyInstanceOf(PasswordResult.class);
  }
}
