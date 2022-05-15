package jason.idv.auth.entity.rule;

import java.util.regex.Pattern;

public class SensitiveRule extends Rule {

  public SensitiveRule(String failReason) {
    super(failReason);
  }

  @Override
  public boolean verify(String password) {
    return Pattern.compile("^(?=.+[0-9])(?=.+[a-z])[a-z0-9]+$").matcher(password).matches();
  }
}
