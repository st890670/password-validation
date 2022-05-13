package jason.idv.auth.pojos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;

@Getter
@Setter
public class PasswordCondition {
  private List<Function<String, Boolean>> conditions;

  public PasswordCondition(List<Function<String, Boolean>> conditions) {
    this.conditions = conditions;
  }
}
