package jason.idv.auth.facades;

import jason.idv.auth.constants.PasswordConditionCode;
import jason.idv.auth.entity.PasswordCondition;
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
            .add(PasswordConditionCode.SENSITIVE)
            .add(PasswordConditionCode.LENGTH)
            .add(PasswordConditionCode.DUPLICATE)
            .build());
  }
}
