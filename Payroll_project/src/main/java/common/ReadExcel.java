package common;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
public XSSFSheet sh;

	public String readData(int i, int j) throws IOException {
		FileInputStream f;
		try {
			f = new FileInputStream("C:\\Users\\acer\\Desktop\\Excel\\excelread.xlsx");
			XSSFWorkbook w= new XSSFWorkbook(f);
			sh= w.getSheet("Sheet1");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Row r= sh.getRow(i);
		Cell c= r.getCell(j); //Import Cell of apache poi not Table
		int celltype=c.getCellType();
		switch(celltype) 
		{
		case Cell.CELL_TYPE_NUMERIC:
		{
			double a=c.getNumericCellValue();
			return String.valueOf(a);
		}
		case Cell.CELL_TYPE_STRING:
		{
			return c.getStringCellValue();
		}
		}
		return null; 
		
	}

}
