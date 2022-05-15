package jason.idv.auth.service;

import jason.idv.auth.entity.PasswordResult;
import jason.idv.auth.entity.PasswordRule;

public interface PasswordService {
    PasswordResult verify(String password, PasswordRule condition);
}
