package jason.idv.auth.entity.rule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DuplicatedRuleMockitoTest {

  @InjectMocks private DuplicatedRule duplicatedRule;

  @Test
  public void testPassed() {
    Assertions.assertThat(duplicatedRule.verify("abcd1234")).isTrue();
    Assertions.assertThat(duplicatedRule.verify("abcd1234a")).isTrue();
  }

  @Test
  public void testDuplicatedFailed() {
    Assertions.assertThat(duplicatedRule.verify("aabc123")).isFalse();
    Assertions.assertThat(duplicatedRule.verify("abc1123")).isFalse();
  }
}
