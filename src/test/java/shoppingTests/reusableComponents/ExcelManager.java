package shoppingTests.reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	
	
	//Identify the test case column
	
	
	//Once column is found scan the entire column
	
	//

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\eclipse-ws\\selenium-java\\src\\test\\java\\shoppingTests\\data\\TestData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		int sheetCount = wb.getNumberOfSheets();
		
		for(int i=0; i<sheetCount ; i++) {
			
			if(wb.getSheetName(i).equalsIgnoreCase("TestCases")) {
				
				XSSFSheet sheet = wb.getSheetAt(i);
				
				//Identify the test case column
				
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				
				int k=0;
				int col=0;
				
				while(ce.hasNext());
				{
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {	
						//
						
						col = k;
					}
					
					k++;
				}
				
				System.out.println("+++++++++++++++++++++++==" +col);
				
			}	
		}
		
		
	

	}

}
