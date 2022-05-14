package jason.idv.auth.entity;

import jason.idv.auth.entity.rule.Rule;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PasswordCondition {
  private final List<Rule> conditions;

  public PasswordCondition(List<Rule> conditions) {
    this.conditions = conditions;
  }

  @Component
  @Scope("prototype")
  public static class Builder {
    private final List<Rule> conditions = new ArrayList<>();

    public Builder add(Rule rule) {
      this.conditions.add(rule);
      return this;
    }

    public PasswordCondition build() {
      return new PasswordCondition(this.conditions);
    }
  }
}
