package jason.idv.auth.entity.rule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SensitiveRuleMockitoTest {

  @InjectMocks private SensitiveRule sensitiveRule;

  @Test
  public void testPassed() {
    Assertions.assertThat( sensitiveRule.verify("abcd1234")).isTrue();
    Assertions.assertThat( sensitiveRule.verify("1234abcd")).isTrue();
    Assertions.assertThat( sensitiveRule.verify("abc123abc")).isTrue();
  }

  @Test
  public void testUppercaseFailed() {
    Assertions.assertThat(sensitiveRule.verify("Abcd1234")).isFalse();
  }

  @Test
  public void testOnlyLetterFailed() {
    Assertions.assertThat(sensitiveRule.verify("abcd")).isFalse();
  }

  @Test
  public void testOnlyNumberFailed() {
    Assertions.assertThat(sensitiveRule.verify("1234")).isFalse();
  }
}
