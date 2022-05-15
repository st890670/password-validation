package jason.idv.auth.entity.rule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LengthRuleMockitoTest {

  @InjectMocks private LengthRule lengthRule;

  @Test
  public void testPassed() {
    Assertions.assertThat(lengthRule.verify("abcd1234")).isTrue();
  }

  @Test
  public void testTooLongFailed() {
    Assertions.assertThat(lengthRule.verify("abcdef1234567")).isFalse();
  }

  @Test
  public void testTooShortFailed() {
    Assertions.assertThat(lengthRule.verify("ab12")).isFalse();
    Assertions.assertThat(lengthRule.verify("")).isFalse();
  }
}
