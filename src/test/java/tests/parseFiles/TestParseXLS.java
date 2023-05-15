package tests.parseFiles;


import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestParseXLS {
  public ClassLoader cl = TestParseXLS.class.getClassLoader();


  @DisplayName("Чтение и проверка содержимого файла xls")
  @Test
  void xlsParseTest() throws Exception {
    try (InputStream is = cl.getResourceAsStream("test.zip");
         ZipInputStream zs = new ZipInputStream(is)) {
      ZipEntry entry;
      while ((entry = zs.getNextEntry()) != null) {
        if (entry.getName().contains("test2.xlsx")) {
          XLS xls = new XLS(zs);
          Assertions.assertTrue(
                  xls.excel.getSheetAt(0).getRow((0)).getCell(2)
                          .getStringCellValue().contains("Это всё тест"));
        }
      }
    }
  }
}
