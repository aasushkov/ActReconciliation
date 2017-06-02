package Comparison;

import Model.DataAct;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ActReconciliationLogic {

    private static XSSFSheet createXLSheet(String filePath) throws IOException {
        XSSFWorkbook actRec = new XSSFWorkbook(new FileInputStream(filePath));
        return actRec.getSheetAt(actRec.getActiveSheetIndex());
    }

    public static List<DataAct> readExcel() throws IOException {

        XSSFSheet xssfSheet = createXLSheet("D:\\Гастроном ТК.XLSX");

        String docNumString = "";
        double debet;
        double credit;
        int lastRow = xssfSheet.getLastRowNum();
        List<DataAct> dataActList = new ArrayList<DataAct>();

        for(int i = 14; i < lastRow; i++)
        {
            XSSFRow row = xssfSheet.getRow(i);
            try {
                if (row.getCell(2) != null) {
                    docNumString = row.getCell(2).getStringCellValue();
                }
                if(row.getCell(5) != null && row.getCell(5).getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                {
                    debet = row.getCell(5).getNumericCellValue();
                }
                else debet = 0;

                if(row.getCell(6) != null && row.getCell(6).getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                {
                    credit = row.getCell(6).getNumericCellValue();
                }
                else credit = 0;

                dataActList.add(new DataAct(docNumString,i,debet,credit));
            }
            catch (NullPointerException ignored){}
        }


        for (DataAct act : dataActList) {
            System.out.println(act.toString());
        }
        return dataActList;
    }
}
