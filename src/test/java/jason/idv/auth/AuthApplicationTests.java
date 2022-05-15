package jason.idv.auth;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthApplicationTests {

  @Test
  void contextLoads() {}

  @Test
  public void testApplicationContext() {
    AuthApplication.main(new String[] {});
  }
}
