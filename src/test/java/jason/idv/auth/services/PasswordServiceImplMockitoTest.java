package jason.idv.auth.services;

import jason.idv.auth.entity.PasswordCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PasswordServiceImplMockitoTest {

  private static final String PASSWORD = "abcd1234";

  @InjectMocks private PasswordServiceImpl passwordService;

  @Test
  public void shouldReturnTrue() {
    boolean result =
        passwordService.verify(PASSWORD, new PasswordCondition(List.of()));
    Assertions.assertThat(result).isTrue();
  }
}
