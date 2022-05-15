package jason.idv.auth.entity.rule;

import java.util.regex.Pattern;

public class LengthRule extends Rule {
    public LengthRule(String failReason) {
        super(failReason);
    }

    @Override
    public boolean verify(String password) {
        return Pattern.compile(".{5,12}").matcher(password).matches();
    }
}
