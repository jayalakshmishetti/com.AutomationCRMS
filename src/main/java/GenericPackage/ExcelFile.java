package GenericPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile implements FrameworkConstant{
	public String toReadDataFromExcelFile(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(excel);
		Workbook wb = WorkbookFactory.create(fis);
		String testdata = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return testdata;
	}
}
