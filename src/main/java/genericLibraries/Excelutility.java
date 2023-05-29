package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains reusable methods to perform operations on excel
 * @author ajaib
 *
 */

public class Excelutility {
	private Workbook workbook;
	/**
	 * This method is used to initialize excel file
	 * @param excelpath
	 */

	public void excelInit(String excelpath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(excelpath);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fis);
			
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
			
			
		}
	}
	/**
	 * This method is used to read single data from excel
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getDataFromExcel(String sheetname,int rowNum,int cellNum)
	{
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetname).getRow(rowNum).getCell(cellNum));
		return data;}
	
	/**
	 * This method is used to fetch multiple data from excel
	 * @param sheetname
	 * @return
	 */
		public Map<String,String> getDataFromCell(String sheetname)
		{
			DataFormatter df=new DataFormatter();
		    Map<String,String>	map=new HashMap<>();
		   Sheet sheet = workbook.getSheet(sheetname);
		   
		   
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			  String key=df.formatCellValue(sheet.getRow(i).getCell(0));
			  String value = df.formatCellValue(sheet.getRow(i).getCell(1));
			  map.put(key, value);
		}
		return map;
		   
		   
		
		
			
	}
		public void close() throws IOException
		{
			workbook.close();
		}

}