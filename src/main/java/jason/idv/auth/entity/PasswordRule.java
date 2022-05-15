package jason.idv.auth.entity;

import jason.idv.auth.entity.rule.Rule;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PasswordRule {
  private List<Rule> rules;

  public PasswordRule(List<Rule> conditions) {
    this.rules = conditions;
  }

  public static class Builder {
    private final List<Rule> rules = new ArrayList<>();

    public Builder add(Rule rule) {
      this.rules.add(rule);
      return this;
    }

    public PasswordRule build() {
      return new PasswordRule(this.rules);
    }
  }
}
