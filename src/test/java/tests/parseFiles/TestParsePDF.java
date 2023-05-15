package tests.parseFiles;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestParsePDF {
  public ClassLoader cl = TestParsePDF.class.getClassLoader();


  @DisplayName("Чтение и проверка содержимого файла PDF")
  @Test
  void pdfParseTest() throws Exception {
    try (InputStream is = cl.getResourceAsStream("test.zip");
         ZipInputStream zs = new ZipInputStream(is)) {
      ZipEntry entry;
      while ((entry = zs.getNextEntry()) != null) {
        if (entry.getName().contains("test1.pdf")) {
          PDF pdf = new PDF(zs);
          Assertions.assertTrue(pdf.text.contains("Работа с PDF"));
        }
      }
    }
  }
}
