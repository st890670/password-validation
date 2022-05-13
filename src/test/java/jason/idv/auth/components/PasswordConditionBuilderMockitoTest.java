package jason.idv.auth.components;

import jason.idv.auth.constants.PasswordConditionCode;
import jason.idv.auth.pojos.PasswordCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PasswordConditionBuilderMockitoTest {

  @InjectMocks private PasswordConditionBuilder passwordConditionBuilder;

  @Test
  public void testSensitiveCondition() {
    PasswordCondition condition =
        passwordConditionBuilder.add(PasswordConditionCode.SENSITIVE).build();
    boolean pass = condition.getConditions().stream().allMatch(func-> func.apply("abcd1234"));
    Assertions.assertThat(pass).isTrue();
    boolean uppercaseFail = condition.getConditions().stream().allMatch(func-> func.apply("Abcd1234"));
    Assertions.assertThat(uppercaseFail).isFalse();
    boolean onlyLetterFail = condition.getConditions().stream().allMatch(func-> func.apply("abcd"));
    Assertions.assertThat(onlyLetterFail).isFalse();
    boolean onlyNumberFail = condition.getConditions().stream().allMatch(func-> func.apply("1234"));
    Assertions.assertThat(onlyNumberFail).isFalse();
  }

  @Test
  public void testLengthCondition() {
    PasswordCondition condition =
            passwordConditionBuilder.add(PasswordConditionCode.LENGTH).build();
    boolean pass = condition.getConditions().stream().allMatch(func-> func.apply("abcd1234"));
    Assertions.assertThat(pass).isTrue();
    boolean shortFail = condition.getConditions().stream().allMatch(func-> func.apply("ab12"));
    Assertions.assertThat(shortFail).isFalse();
    boolean longFail = condition.getConditions().stream().allMatch(func-> func.apply("abcdefg123456"));
    Assertions.assertThat(longFail).isFalse();
  }

  @Test
  public void testDuplicateCondition() {
    PasswordCondition condition =
            passwordConditionBuilder.add(PasswordConditionCode.DUPLICATE).build();
    boolean pass = condition.getConditions().stream().allMatch(func-> func.apply("abc123abc123"));
    Assertions.assertThat(pass).isTrue();
    boolean fail = condition.getConditions().stream().allMatch(func-> func.apply("aabbcc112233"));
    Assertions.assertThat(fail).isFalse();
  }
}
