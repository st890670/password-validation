package jason.idv.auth.facade;

import jason.idv.auth.components.PasswordConditionBuilder;
import jason.idv.auth.constants.PasswordConditionCode;
import jason.idv.auth.services.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthFacade {

  @Autowired private PasswordServiceImpl passwordService;
  @Autowired private PasswordConditionBuilder passwordConditionBuilder;

  public boolean verifyPassword(String password) {
    return passwordService.verifyPassword(password, passwordConditionBuilder
            .add(PasswordConditionCode.SENSITIVE)
            .add(PasswordConditionCode.LENGTH)
            .add(PasswordConditionCode.DUPLICATE)
            .build());
  }
}
