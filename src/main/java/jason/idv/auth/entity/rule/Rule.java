package jason.idv.auth.entity.rule;

public abstract class Rule {
  public abstract boolean verify(String password);
}
