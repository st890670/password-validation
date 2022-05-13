package jason.idv.auth.services;

import jason.idv.auth.pojos.PasswordCondition;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

  @Override
  public boolean verifyPassword(String password, PasswordCondition condition) {
    return condition.getConditions().stream().allMatch(func -> func.apply(password));
  }
}
