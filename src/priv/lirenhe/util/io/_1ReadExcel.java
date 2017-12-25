package priv.lirenhe.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class _1ReadExcel {
	public static void main(String[] args) {
		File file = new File("C:/Users/User/Desktop/打包历史/2017-12-14 任鹤/171213新增网站-分配表.xlsx");
		readExcel(file);

	}

	public static void readExcel(File xlsFile) {
		try {
			InputStream is=new FileInputStream(xlsFile);
			XSSFWorkbook workBook = new XSSFWorkbook(is);
			int sheetNum = workBook.getNumberOfSheets();
			
			for (int sheetIndex = 0; sheetIndex<sheetNum;sheetIndex++){
				String sheetName = null;
				sheetName = workBook.getSheetName(sheetIndex);
				XSSFSheet sheet=workBook.getSheetAt(sheetIndex);
				if(sheet==null){
					continue;
				}
				int rowNum = sheet.getLastRowNum() + 1;
				int cols = 0;
			/*	
				XSSFRow rows=sheet.getRow(1);
				cols=rows.getPhysicalNumberOfCells();
				System.out.println(cols);
				for(int colIndex = 0; colIndex < cols; colIndex++){
					Cell cell = rows.getCell(colIndex);
					if (cell == null) {
						continue;
					}
					String cellValue = cell.getStringCellValue();
					System.out.printf("%10s", cellValue);
				}
				*/
				
				for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
					XSSFRow row = sheet.getRow(rowIndex);
					if (row == null) {
						continue;
					}
					cols = row.getPhysicalNumberOfCells();
					
					for (int colIndex = 0; colIndex < cols; colIndex++) {
						Cell cell = row.getCell(colIndex);
						if (cell == null) {
							continue;
						}
						int cellType=cell.getCellType();
						String cellValue=null;
						if(cellType==Cell.CELL_TYPE_STRING){
							cellValue = cell.getStringCellValue();
						}else{
							continue;
						}
						System.out.printf("%10s", cellValue);
					}
					System.out.println();
				}

			
			}

		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
