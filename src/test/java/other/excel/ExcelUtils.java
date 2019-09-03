package other.excel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class ExcelUtils {
    /**
     * 创建excel
     */
    public static void createExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        try {
            FileOutputStream out = new FileOutputStream(new File("src/test/resources/excel/workbook.xlsx"));
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    public static void openFile() throws IOException {
        File file = new File("openworkbook.xlsx");
        FileInputStream fIP = new FileInputStream(file);
        //Get the workbook instance for XLSX file
        XSSFWorkbook workbook = new XSSFWorkbook(fIP);
        if (file.isFile() && file.exists()) {
            System.out.println("openworkbook.xlsx file open successfully.");
        } else {
            System.out.println("Error to open openworkbook.xlsx file.");
        }
    }

    public static void dropDownList(String filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("下拉列表");
        String[] data = new String[]{"维持", "回复", "调整"};
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        DataValidationConstraint dvConstraint = dvHelper.createExplicitListConstraint(data);
        CellRangeAddressList addressList = null;
        DataValidation validation = null;

        addressList = new CellRangeAddressList(0, 1000, 2, 2);
        for (int i = 0; i < 100; i++) {
            validation = dvHelper.createValidation(dvConstraint, addressList);
            sheet.addValidationData(validation);
        }
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);
        out.close();
    }

}
