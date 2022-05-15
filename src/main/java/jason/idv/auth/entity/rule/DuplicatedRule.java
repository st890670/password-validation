package jason.idv.auth.entity.rule;

public class DuplicatedRule extends Rule {
  public DuplicatedRule(String failReason) {
    super(failReason);
  }

  @Override
  public boolean verify(String password) {
    var duplicatePass = true;
    var dividedPassword = password.split("");
    for (int i = 0; i < dividedPassword.length - 1; i++) {
      if (dividedPassword[i].equals(dividedPassword[i + 1])) {
        duplicatePass = false;
        break;
      }
    }
    return duplicatePass;
  }
}
