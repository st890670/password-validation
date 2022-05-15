package jason.idv.auth.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PasswordResult {
  private boolean isPassed;
  private List<String> failedReasons;

  public PasswordResult(boolean isPassed, List<String> failedReason) {
    this.isPassed = isPassed;
    this.failedReasons = failedReason;
  }
}
