package jason.idv.auth.components;

import jason.idv.auth.constants.PasswordConditionCode;
import jason.idv.auth.pojos.PasswordCondition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

@Component
@Scope("prototype")
public class PasswordConditionBuilder {
  private final List<Function<String, Boolean>> conditions = new ArrayList<>();

  public PasswordConditionBuilder add(int conditionCode) {
    switch (conditionCode) {
      case PasswordConditionCode.SENSITIVE:
        conditions.add(str -> Pattern.compile("[a-z]+[0-9]+").matcher(str).matches());
        break;
      case PasswordConditionCode.LENGTH:
        conditions.add(str -> Pattern.compile(".{5,12}").matcher(str).matches());
        break;
      case PasswordConditionCode.DUPLICATE:
        conditions.add(
            str -> {
              var duplicatePass = true;
              var dividedPassword = str.split("");
              for (int i = 0; i < dividedPassword.length - 1; i++) {
                if (dividedPassword[i].equals(dividedPassword[i + 1])) {
                  duplicatePass = false;
                  break;
                }
              }
              return duplicatePass;
            });
      default:
        break;
    }
    return this;
  }

  public PasswordCondition build() {
    return new PasswordCondition(this.conditions);
  }
}
