package jason.idv.auth.entity.rule;

import lombok.Getter;

@Getter
public abstract class Rule {
  private final String failReason;

  public Rule(String failReason) {
    this.failReason = failReason;
  }

  public abstract boolean verify(String password);
}
