package tests.example.workWithFile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideFileClass {

    @Test
    void downloadFileTest () throws Exception {
        open("https://github.com/junit-team/junit-framework/blob/main/README.md");
        // Тип file - для работы с путями к файлам и папкам на диске, а не содержимым файла.
        File downloaded =
                $(".react-blob-header-edit-and-raw-actions [href*='main/README.md']")
                        .download();

        // Работа с файлами IO (Input/Output Чтение/запись) в Java
        // InputStream и Reader - чтение (Работа с байтами)
        // OutputStream и Riter - запись

        try (InputStream is = new FileInputStream(downloaded)) {
            byte[] data = is.readAllBytes();
            String dataAsString = new String(data, StandardCharsets.UTF_8);
            Assertions.assertTrue(dataAsString.contains("Contributions to JUnit are both welcomed and appreciated."));
        }

        System.out.println();
    }

    @Test
    void uploadFileTest() {
        open("https://demoqa.com/automation-practice-form");
        $("input[type='file']").uploadFromClasspath("Uaaa.png");
    }
}
