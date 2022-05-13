package jason.idv.auth.services;

import jason.idv.auth.pojos.PasswordCondition;

public interface PasswordService {
    boolean verifyPassword(String password, PasswordCondition condition);

}
