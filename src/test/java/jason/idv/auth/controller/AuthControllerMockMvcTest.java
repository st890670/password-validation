package jason.idv.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jason.idv.auth.entity.PasswordResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerMockMvcTest {

  private static final String VALID_PASSWORD = "abcd1234";
  private static final String INVALID_PASSWORD = "Aabbcdefg1234567";
  private static final ObjectMapper mapper = new ObjectMapper();

  @Autowired private MockMvc mockMvc;

  @Test
  public void testVerifyPassed() throws Exception {
    var mvcResult =
        mockMvc
            .perform(MockMvcRequestBuilders.post("/verify").param("password", VALID_PASSWORD))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    String responseStr = mvcResult.getResponse().getContentAsString();
    PasswordResult result = mapper.readValue(responseStr, PasswordResult.class);
    Assertions.assertThat(result.isPassed()).isTrue();
  }

  @Test
  public void testVerifyFailed() throws Exception {
    var mvcResult =
        mockMvc
            .perform(MockMvcRequestBuilders.post("/verify").param("password", INVALID_PASSWORD))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    String responseStr = mvcResult.getResponse().getContentAsString();
    PasswordResult result = mapper.readValue(responseStr, PasswordResult.class);
    Assertions.assertThat(result.isPassed()).isFalse();
  }
}
