package xloperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XlWriteOperation {
	@Test
	public void xlWriteTest() throws IOException
	{
		
		FileInputStream f=new FileInputStream("C:\\Users\\sai naresh\\Desktop\\KESITOURS.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Row r=null;
		Cell c=null;
		r=ws.getRow(0);
		c=r.getCell(1);
		System.out.println(c.getStringCellValue());
		
		
		
		
		
		FileOutputStream f1=new FileOutputStream("C:\\Users\\sai naresh\\Desktop\\KESITOURS.xlsx");
		wb.write(f1);
		f1.close();
		
	}

}
