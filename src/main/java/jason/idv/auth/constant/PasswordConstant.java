package jason.idv.auth.constant;

public interface PasswordConstant {
    String SENSITIVE_FAILED = "The password must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.";
    String LENGTH_FAILED = "The password must be between 5 and 12 characters in length.";
    String DUPLICATED_FAILED = "The password must not contain any sequence of characters immediately followed by the same sequence.";
}
