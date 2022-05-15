package jason.idv.auth.service;

import jason.idv.auth.entity.PasswordResult;
import jason.idv.auth.entity.PasswordRule;
import jason.idv.auth.entity.rule.Rule;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PasswordServiceImpl implements PasswordService {

  @Override
  public PasswordResult verify(String password, PasswordRule passwordRule) {
    var failReasons =
        passwordRule.getRules().stream()
            .filter(rule -> !rule.verify(password))
            .map(Rule::getFailReason)
            .collect(Collectors.toList());
    return new PasswordResult(failReasons.isEmpty(), failReasons);
  }
}
