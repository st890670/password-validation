package jason.idv.auth.facades;

import jason.idv.auth.components.PasswordConditionBuilder;
import jason.idv.auth.services.PasswordServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Answers.RETURNS_SELF;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthFacadeMockitoTest {

  private static final String PASSWORD = "abcd1234";

  @Mock private PasswordServiceImpl passwordService;

  @Mock(answer = RETURNS_SELF)
  private PasswordConditionBuilder passwordConditionBuilder;

  @InjectMocks private AuthFacade authFacade;

  @BeforeEach
  void setUp() {
    when(passwordService.verifyPassword(PASSWORD, passwordConditionBuilder.build()))
        .thenReturn(true);
  }

  @Test
  public void shouldReturnTrue() {
    boolean result = authFacade.verifyPassword(PASSWORD);
    Assertions.assertThat(result).isTrue();
  }
}
