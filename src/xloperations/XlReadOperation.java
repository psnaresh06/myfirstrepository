package xloperations;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;

public class XlReadOperation {
	
	
	 
	@Test
	public void xlReadTest() throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\sai naresh\\Desktop\\myworkbook.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row> row=ws.iterator();
		while(row.hasNext())
		{
			Row r=row.next();
			Iterator<Cell> cols=r.iterator();
					while(cols.hasNext())
					{
						Cell c=cols.next();
						if(c.getCellType()==Cell.CELL_TYPE_STRING)
						{
							System.out.print(c.getStringCellValue()+"     ");
						}
						if(c.getCellType()==Cell.CELL_TYPE_NUMERIC)
						{
							System.out.print(c.getNumericCellValue());
						}
						
					}
					System.out.println();
		}
		
		
	}
}
