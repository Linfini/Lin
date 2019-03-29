package other.excel;

import org.junit.Test;

import java.io.IOException;

public class ExcelUtilsTest {

    static String filePath = "src/test/resources/excel/workbook.xlsx";

    @Test
    public void testCreateExcel() {
        ExcelUtils.createExcel();
    }

    @Test
    public void test2() throws IOException {
        ExcelUtils.dropDownList(filePath);
    }
}
