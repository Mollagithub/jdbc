package Data.insertintoDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadxcelfileandgetvlauefrotestUI {
	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("/Users/muhammadamolla/Desktop/CDS.xlsx");
		Workbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet= (XSSFSheet) wb.getSheet("CDS");
		Iterator<Row> rowit=sheet.iterator();
		rowit.next();
		while (rowit.hasNext()){
			System.out.println(rowit.next().getCell(1));
			
		}
		
	}
}
