package jason.idv.auth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "密碼驗證結果")
public class PasswordResult {
  @ApiModelProperty(value = "是否通過驗證", required = true)
  private boolean passed;
  @ApiModelProperty(value = "驗證失敗原因", required = true)
  private List<String> failedReasons;

  public PasswordResult(boolean passed, List<String> failedReason) {
    this.passed = passed;
    this.failedReasons = failedReason;
  }
}
