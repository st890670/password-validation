package jason.idv.auth.services;

import jason.idv.auth.entity.PasswordCondition;

public interface PasswordService {
    boolean verify(String password, PasswordCondition condition);
}
