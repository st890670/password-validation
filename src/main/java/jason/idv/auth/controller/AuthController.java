package jason.idv.auth.controller;

import io.swagger.annotations.ApiOperation;
import jason.idv.auth.entity.PasswordResult;
import jason.idv.auth.facade.AuthFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired private AuthFacade authFacade;

  @ApiOperation("密碼驗證")
  @PostMapping("/verify")
  public PasswordResult verifyPassword(@RequestParam String password) {
    return authFacade.verifyPassword(password);
  }
}
