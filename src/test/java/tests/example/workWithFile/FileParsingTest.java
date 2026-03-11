package tests.example.workWithFile;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileParsingTest {

    @Test
    void pdfFileParsingTest() throws Exception {
        open("https://www.gazprombank.ru/documents-and-tariffs/?sectionId=119&subSectionId=445-447-4659");
        File downloaded = $("[href*='/upload/files/iblock/6a4/clsg4n9jzr4e11jhhumtv31f7j3bf434/Tarif-Banka-GPB-_AO_-na-vypusk-i-obsluzhivanie-raschetnykh-bankovskikh-kart-kategorii-UnionPay_-MIR-s-predostavleniem-kredita-v-form.pdf']").download();

        PDF pdf = new PDF(downloaded);

        //Проверяем наличие текста
        Assertions.assertTrue(pdf.text.contains("Тариф Банка ГПБ (АО) на выпуск и обслуживание расчетных банковских карт"));

        System.out.println();
    }

    @Test
    void xlsFileParsingTest() throws Exception {
        open("https://excelvba.ru/programmes/Teachers");
        File downloaded = $("[href*='https://ExcelVBA.ru/sites/default/files/teachers.xls']").download();

        XLS xls = new XLS(downloaded);
        String actualValue = xls.excel.getSheetAt(0).getRow(4).getCell(2).getStringCellValue();

        Assertions.assertTrue(actualValue.contains("Xnj"));
        System.out.println("");
    }
}
