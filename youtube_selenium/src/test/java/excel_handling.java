import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_handling {
	public void readExcelData() throws IOException
	{
		
		File f=new File("C:\\Users\\Nishant Kumar\\Documents\\testcases.xlsx"); // file object
		FileInputStream in=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(in);
		XSSFSheet sheet=wb.getSheetAt(0);
		int r=sheet.getPhysicalNumberOfRows();
		for(int i=0;i<r;i++) 
		{
			XSSFRow row=sheet.getRow(i);				
			int c=row.getPhysicalNumberOfCells();
			for(int j=0;j<c;j++) 
			{
				XSSFCell cell=row.getCell(j);
				System.out.println(cell.getStringCellValue());
			}

		}
		
		
	}
	public void readExcelData_particularRow() throws IOException
	{
		
		File f=new File("C:\\Users\\Nishant Kumar\\Documents\\testcases.xlsx"); // file object
		FileInputStream in=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(in);
		XSSFSheet sheet=wb.getSheetAt(0);
		
			XSSFRow row=sheet.getRow(1);				
			int c=row.getPhysicalNumberOfCells();
			for(int j=0;j<c;j++) 
			{
				XSSFCell cell=row.getCell(j);
				System.out.println(cell.getStringCellValue());
			

		    }
		
		
	}	public void readExcelData_particularCell() throws IOException
	{
		
		File f=new File("C:\\Users\\Nishant Kumar\\Documents\\testcases.xlsx"); // file object
		FileInputStream in=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(in);
		XSSFSheet sheet=wb.getSheetAt(0);
		int r=sheet.getPhysicalNumberOfRows();
		for(int i=0;i<r;i++) 
		{
			XSSFRow row=sheet.getRow(i);				
			
				XSSFCell cell=row.getCell(0);
				System.out.println(cell.getStringCellValue());
			

		}
		
		
	}
	public void write_Excel() throws IOException
	{
		File f=new File("C:\\Users\\Nishant Kumar\\Documents\\testcases.xlsx"); // file object
        FileOutputStream op=new FileOutputStream(f);
        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet sheet=wb.createSheet("youtube");
         for(int i=0;i<5;i=i+1) {
        	 XSSFRow row=sheet.createRow(i);
        	 for(int j=0;j<3;j=j+1) {
        		 XSSFCell cell=row.createCell(j);
        		 cell.setCellValue("kajal verma");
        	 }
         }
        wb.write(op);
        op.flush();
        op.close();
	}
	
	public static void main(String[] args) throws IOException 
	{
	 excel_handling e=new excel_handling();
//	 e.readExcelData();
//	 e.readExcelData_particularRow();
	 e.readExcelData_particularCell();
//	 e.write_Excel();
	}


}
