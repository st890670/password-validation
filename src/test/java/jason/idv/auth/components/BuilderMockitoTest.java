package jason.idv.auth.components;

import jason.idv.auth.entity.PasswordCondition;
import jason.idv.auth.entity.rule.DuplicateRule;
import jason.idv.auth.entity.rule.LengthRule;
import jason.idv.auth.entity.rule.SensitiveRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BuilderMockitoTest {

  @InjectMocks private PasswordCondition.Builder builder;

  @Test
  public void testSensitiveCondition() {
    PasswordCondition condition = builder.add(new SensitiveRule()).build();
    boolean pass = condition.getConditions().stream().allMatch(rule -> rule.verify("abcd1234"));
    Assertions.assertThat(pass).isTrue();
    boolean uppercaseFail =
        condition.getConditions().stream().allMatch(rule -> rule.verify("Abcd1234"));
    Assertions.assertThat(uppercaseFail).isFalse();
    boolean onlyLetterFail =
        condition.getConditions().stream().allMatch(rule -> rule.verify("abcd"));
    Assertions.assertThat(onlyLetterFail).isFalse();
    boolean onlyNumberFail =
        condition.getConditions().stream().allMatch(rule -> rule.verify("1234"));
    Assertions.assertThat(onlyNumberFail).isFalse();
  }

  @Test
  public void testLengthCondition() {
    PasswordCondition condition = builder.add(new LengthRule()).build();
    boolean pass = condition.getConditions().stream().allMatch(rule -> rule.verify("abcd1234"));
    Assertions.assertThat(pass).isTrue();
    boolean shortFail = condition.getConditions().stream().allMatch(rule -> rule.verify("ab12"));
    Assertions.assertThat(shortFail).isFalse();
    boolean longFail =
        condition.getConditions().stream().allMatch(rule -> rule.verify("abcdefg123456"));
    Assertions.assertThat(longFail).isFalse();
  }

  @Test
  public void testDuplicateCondition() {
    PasswordCondition condition = builder.add(new DuplicateRule()).build();
    boolean pass = condition.getConditions().stream().allMatch(rule -> rule.verify("abc123abc123"));
    Assertions.assertThat(pass).isTrue();
    boolean fail = condition.getConditions().stream().allMatch(rule -> rule.verify("aabbcc112233"));
    Assertions.assertThat(fail).isFalse();
  }
}
