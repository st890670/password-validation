package jason.idv.auth.entity.rule;

import java.util.regex.Pattern;

public class SensitiveRule extends Rule {

  @Override
  public boolean verify(String password) {
    return Pattern.compile("[a-z]+[0-9]+").matcher(password).matches();
  }
}
