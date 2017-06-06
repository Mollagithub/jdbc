
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ReadData {
	public void tc() throws IOException{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://secure01b.chase.com/web/auth/dashboard#/dashboard/index/index");//https://secure01b.chase.com/web/auth/dashboard#/dashboard/index/index
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ArrayList<String> unserName=readExcelData(0);
		ArrayList<String> password=readExcelData(1);
		for(int i=0;i<unserName.size();i++){
			
		driver.findElement(By.id("userId")).sendKeys(unserName.get(i));
		driver.findElement(By.id("password")).sendKeys(password.get(i));
		driver.findElement(By.id("signin-button")).click();	
		driver.findElement(By.id("userNavigationLabel")).click();
		driver.findElement(By.id("show_me_how_logout_1")).click();
		}
	}
public ArrayList<String> readExcelData(int columon) throws IOException{
	FileInputStream file=new FileInputStream("/Users/muhammadamolla/Desktop/CDS.xlsx");
	Workbook wb=new XSSFWorkbook(file);
	XSSFSheet sheet= (XSSFSheet) wb.getSheet("CDS");
	Iterator<Row> rowit=sheet.iterator();
	rowit.next();
	ArrayList<String>list =new ArrayList<String>();
	while (rowit.hasNext()){
		list.add(rowit.next().getCell(columon).getStringCellValue());
	}
		System.out.println("list ;;;;;"+list);
		return list;
		
    }
public static void main(String[] args) throws IOException {
	ReadData data=new ReadData();
	data.tc();
}
}
