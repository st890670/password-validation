package jason.idv.auth.facade;

import jason.idv.auth.constant.PasswordConstant;
import jason.idv.auth.entity.PasswordResult;
import jason.idv.auth.entity.PasswordRule;
import jason.idv.auth.entity.rule.DuplicatedRule;
import jason.idv.auth.entity.rule.LengthRule;
import jason.idv.auth.entity.rule.SensitiveRule;
import jason.idv.auth.service.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthFacade {

  @Autowired private PasswordServiceImpl passwordService;

  public PasswordResult verifyPassword(String password) {
    PasswordRule passwordRule =
        new PasswordRule.Builder()
            .add(new SensitiveRule(PasswordConstant.SENSITIVE_FAILED))
            .add(new LengthRule(PasswordConstant.LENGTH_FAILED))
            .add(new DuplicatedRule(PasswordConstant.DUPLICATED_FAILED))
            .build();
    return passwordService.verify(password, passwordRule);
  }
}
