package jason.idv.auth.facades;

import jason.idv.auth.entity.PasswordCondition;
import jason.idv.auth.entity.rule.DuplicateRule;
import jason.idv.auth.entity.rule.LengthRule;
import jason.idv.auth.entity.rule.SensitiveRule;
import jason.idv.auth.services.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthFacade {

  @Autowired private PasswordServiceImpl passwordService;
  @Autowired private PasswordCondition.Builder passwordConditionBuilder;

  public boolean verifyPassword(String password) {
    return passwordService.verify(
        password,
        passwordConditionBuilder
            .add(new SensitiveRule())
            .add(new LengthRule())
            .add(new DuplicateRule())
            .build());
  }
}
