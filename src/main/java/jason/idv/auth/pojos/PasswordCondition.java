package jason.idv.auth.pojos;

import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@Getter
public class PasswordCondition {
  private List<Function<String, Boolean>> conditions;

  public PasswordCondition(List<Function<String, Boolean>> conditions) {
    this.conditions = conditions;
  }
}
