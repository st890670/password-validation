package jason.idv.auth.entity;

import jason.idv.auth.entity.rule.SensitiveRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PasswordRuleMockitoTest {

  @InjectMocks private PasswordRule passwordRule;

  @Test
  public void testPasswordRule() {
    PasswordRule rule = new PasswordRule(List.of());
    Assertions.assertThat(rule.getRules()).isInstanceOf(List.class);
    rule.setRules(List.of(new SensitiveRule("")));
    Assertions.assertThat(rule.getRules().size()).isEqualTo(1);
  }

  @Test
  public void testNewInstanceByBuilder() {
    Assertions.assertThat(new PasswordRule.Builder().build()).isExactlyInstanceOf(PasswordRule.class);
  }
}
