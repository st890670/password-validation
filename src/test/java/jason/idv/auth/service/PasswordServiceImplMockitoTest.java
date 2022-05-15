package jason.idv.auth.service;

import jason.idv.auth.entity.PasswordResult;
import jason.idv.auth.entity.PasswordRule;
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
  public void shouldReturnPasswordResult() {
    PasswordResult result = passwordService.verify(PASSWORD, new PasswordRule(List.of()));
    Assertions.assertThat(result).isExactlyInstanceOf(PasswordResult.class);
  }
}
