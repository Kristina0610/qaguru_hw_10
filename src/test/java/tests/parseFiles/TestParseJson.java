package tests.parseFiles;


import com.fasterxml.jackson.databind.ObjectMapper;
import models.TestJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

public class TestParseJson {
  public ClassLoader cl = TestParseJson.class.getClassLoader();

  @DisplayName("Чтение и проверка содержимого файла json")
  @Test
  void jsonParseTest() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    try (InputStream is = cl.getResourceAsStream("test.json");
         InputStreamReader isr = new InputStreamReader(is);) {
      TestJson testJson = objectMapper.readValue(isr, TestJson.class);
      Assertions.assertEquals("John", testJson.getName());
      Assertions.assertEquals(31, testJson.getAge());
      Assertions.assertEquals("dog", testJson.getPets().get(0).getAnimal());
      Assertions.assertEquals("Felix", testJson.getPets().get(1).getPetsName());
    }
  }
}
