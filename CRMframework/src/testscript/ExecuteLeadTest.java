package testscript;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.testng.Assert;

public class ExecuteLeadTest {
	@Test
	public void leadTest() throws Exception{
		Keywords key = new Keywords();
		ArrayList a = new ArrayList();
		FileInputStream file = new FileInputStream("F:\\LeadSuite.xlsx");
		XSSFWorkbook b = new XSSFWorkbook(file);
		Sheet s = b.getSheet("TestSteps");
		Iterator itr = s.iterator();
		while(itr.hasNext()) {
			Row rowitr = (Row)itr.next();
			Iterator cellitr = rowitr.cellIterator();
			while(cellitr.hasNext()) {
				Cell celldata = (Cell)cellitr.next();
				
				switch(celldata.getCellType()) {
				
				case Cell.CELL_TYPE_STRING:
				  a.add(celldata.getStringCellValue());
                  break;
                  
				case Cell.CELL_TYPE_NUMERIC: 
					a.add(celldata.getNumericCellValue());
					break;
				
				case Cell.CELL_TYPE_BOOLEAN:
					a.add(celldata.getBooleanCellValue());
					break;
					
				}
			}
		}
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i).equals("openbrowser")) {
				String keyword = (String)(a.get(i));
				String data = (String)(a.get(i+1));
				String objectName = (String)(a.get(i+2));
				String runmode = (String)(a.get(i+3));
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
				key.openbrowser();
				}
			}
			if(a.get(i).equals("navigate")) {
				String keyword = (String)(a.get(i));
				String data = (String)(a.get(i+1));
				String objectName = (String)(a.get(i+2));
				String runmode = (String)(a.get(i+3));
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
				key.navigate(data);
				}
			}
			if(a.get(i).equals("input")) {
				String keyword = (String)(a.get(i));
				String data = (String)(a.get(i+1));
				String objectName = (String)(a.get(i+2));
				String runmode = (String)(a.get(i+3));
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
				key.input(data,objectName);
				}
		}
			if(a.get(i).equals("click")) {
				String keyword = (String)(a.get(i));
				String data = (String)(a.get(i+1));
				String objectName = (String)(a.get(i+2));
				String runmode = (String)(a.get(i+3));
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
				key.click(objectName);
				}
	}
			
			if(a.get(i).equals("verifyTitle")) {
				String keyword = (String)(a.get(i));
				String data = (String)(a.get(i+1));
				String objectName = (String)(a.get(i+2));
				String runmode = (String)(a.get(i+3));
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
				String actualValue = key.verifyTitle();
				Assert.assertEquals( data, actualValue);
				}
	}
			if(a.get(i).equals("verifyPageText")) {
				String keyword = (String)(a.get(i));
				String data = (String)(a.get(i+1));
				String objectName = (String)(a.get(i+2));
				String runmode = (String)(a.get(i+3));
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
				String actualValue = key.verifyPageText(objectName);
				Assert.assertEquals( data, actualValue);
				}
	}
}
}
}
