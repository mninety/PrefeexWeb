package MethodsRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import StartwithPrefeex.VariableModule;


public class MyMethods {
	static Logger logMyMethods = Logger.getLogger(MyMethods.class.getName());
	static int RowCount=1;
	static int initvalue=0;
	static String init="";
	
	public static void FolderCreateAction(File T) {
        if(!T.exists()){  
        	if(T.mkdir()){ 
        		//System.out.println("directory is  created"); 
        		}
        	}  
        else { 
        	//System.out.println("directory exist");  
        	}
	}
	
    public static String getCurrentDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateobject = new SimpleDateFormat("ddMMyyyy-HHmmss");
        return dateobject.format(date);
    }
    
	public static void FileBackupAction() {
        

        File fileexcel = new File(VariableModule.driverlog+"/Reports");
		String currentDate = getCurrentDate();
        FolderCreateAction(fileexcel);
        ExcelFileCreateAction();
	}
	
	public static void ExcelFileCreateAction() {
			 try {
					String currentDate = getCurrentDate();
					int randomValue = (int )(Math.random() * 500 + 1);
			        File oldName = new File(VariableModule.driverlog+"/Reports/Report.xlsx");
			        File newName = new File(VariableModule.driverlog+"/Reports/Report"+'-'+currentDate+'-'+randomValue+".xlsx");
			        oldName.renameTo(newName);
				XSSFWorkbook workbook = new XSSFWorkbook();
				FileOutputStream out = new FileOutputStream(new File(VariableModule.driverlog+"/Reports/Report.xlsx"));
				XSSFSheet Spreadsheet = workbook.createSheet("Report-"+currentDate);
				XSSFRow header = Spreadsheet.createRow(0);
				//XSSFCellStyle style = workbook.createCellStyle();
				header.createCell(0).setCellValue("Feature");
			    header.createCell(1).setCellValue("Test Case");
			    header.createCell(2).setCellValue("Testing Result");
			    header.createCell(3).setCellValue("Execution Time");
			    header.createCell(4).setCellValue("Message");
			    header.createCell(5).setCellValue("Input Paramters");
	/*			    style.setBorderTop(BorderStyle.THIN);
			    style.setBorderBottom(BorderStyle.MEDIUM);
			    style.setBorderLeft(BorderStyle.MEDIUM);
			    style.setBorderRight(BorderStyle.MEDIUM);*/
				workbook.write(out);
				out.close();
			}
			catch(Exception e) {
				System.out.println(e);
				
			}
		}
	public static void Sleep(long milis)
	{
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void PrintMe(String str1, String str2)
	{
		System.out.println(str1+str2);
	}

	public static void ExcelFileWriteAction(String feature, String testcase, String result, String date, String message, String param, int noofCase) {
		
		if(result!="") { //Cases added
		       

			XSSFCell cell = null; 
		
				//System.out.println("Writer Enabled"+RowCount);
				try {
					
					
					
					FileInputStream fIPS= new FileInputStream(VariableModule.driverlog+"/Reports/Report.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(fIPS);
					XSSFSheet worksheet = workbook.getSheetAt(0);
					
					fIPS.close();
					FileOutputStream out = new FileOutputStream(new File(VariableModule.driverlog+"/Reports/Report.xlsx"));
					//XSSFSheet worksheet = workbook.getSheetAt(0);
			        XSSFCellStyle headerStyle = workbook.createCellStyle();
			        Font headerFont = workbook.createFont();
					XSSFRow row = worksheet.createRow(RowCount);

				       //indexOf return -1 if String does not contain specified word
				       if(result.indexOf("Failed") != -1){
				           //System.err.printf("Yes '%s' contains word 'Failed' %n" , result);
					        //font.setColor(IndexedColors.RED.getIndex());
					        //style.setFont(font);
							row.createCell(0).setCellValue(feature);
						    //header.createCell(1).setCellValue(result);
						    cell = row.createCell(1);
						    cell.setCellValue(testcase);
						    
						    
						    cell = row.createCell(2);
						    cell.setCellValue(result);
						    
						    cell = row.createCell(3);
						    cell.setCellValue(date);
						    
						    cell = row.createCell(4);
						    cell.setCellValue(message);
						    
						    cell = row.createCell(5);
						    cell.setCellValue(param);
					        //headerStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					        
					        //headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
						    //headerFont.setColor(IndexedColors.RED.getIndex());
					        headerStyle.setFont(headerFont);
					        
					        
				       }
				       else if(result.indexOf("null") != -1){
				           //System.err.printf("Yes '%s' contains word 'null' %n" , result);
					        //font.setColor(IndexedColors.RED.getIndex());
					        //style.setFont(font);
							row.createCell(0).setCellValue(feature);
						    //header.createCell(1).setCellValue(result);
						    cell = row.createCell(1);
						    cell.setCellValue("");

						    cell = row.createCell(2);
						    cell.setCellValue(result);
						    
						    cell = row.createCell(3);
						    cell.setCellValue(date);
						    
						    cell = row.createCell(4);
						    cell.setCellValue(message);
						    
						    cell = row.createCell(5);
						    cell.setCellValue(param);
					        //headerStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					        headerFont.setColor(IndexedColors.BLUE.getIndex());
					        //headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					        headerStyle.setFont(headerFont);
					        
					        
				       }
				       else {
							row.createCell(0).setCellValue(feature);
						    //header.createCell(1).setCellValue(result);
						    cell = row.createCell(1);
						    cell.setCellValue(testcase);

						    cell = row.createCell(2);
						    cell.setCellValue(result);
						    
						    cell = row.createCell(3);
						    cell.setCellValue(date);
						    
						    cell = row.createCell(4);
						    cell.setCellValue(message);
						    
						    cell = row.createCell(5);
						    cell.setCellValue(param);
				       }
				    cell.setCellStyle(headerStyle);
				    
				    if(noofCase>1)
				    {
				    	initvalue++;
				    	init=init+String.valueOf(RowCount)+",";
					    if(noofCase==initvalue)
					    {
					    	String[] initstr=init.split(",");
					    	//MyMethods.PrintMe("Row1: ", String.valueOf(RowCount));
					    	worksheet.addMergedRegion(new CellRangeAddress(Integer.valueOf(initstr[0]),RowCount,0,0));
					    	initvalue=0;
					    	init="";
					    }
				    }
					workbook.write(out);
					out.close();
					
					
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				//MyMethods.PrintMe("Row2: ", String.valueOf(RowCount));
				RowCount++;
		}
		else //Module name added
		{
			
			RowCount=RowCount+3;
			//System.out.println("Writer Enabled with null"+RowCount);
			XSSFCell cell = null; 
			try {
				FileInputStream fIPS= new FileInputStream(VariableModule.driverlog+"/WebDriver/Reports/Report.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fIPS);
				XSSFSheet worksheet = workbook.getSheetAt(0);
				
				fIPS.close();
				
				FileOutputStream out = new FileOutputStream(new File(VariableModule.driverlog+"/WebDriver/Reports/Report.xlsx"));
				XSSFRow row = worksheet.createRow(RowCount);
				cell = row.createCell(0);
				//cell = row.createCell(1);

				worksheet.addMergedRegion(new CellRangeAddress(RowCount,RowCount,0,1));
			    cell.setCellValue(testcase);
				workbook.write(out);
				out.close();
				
				
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			RowCount=RowCount+3;
		}
	}

	@SuppressWarnings("null")
	public static String ExcelFileReadAction(String fileName)
	{
		String input="";
		try {
			
			FileInputStream fs = new FileInputStream(VariableModule.driverlog+"/InputFiles/"+fileName);
		    XSSFWorkbook wb = new XSSFWorkbook(fs);
		    XSSFSheet sheet = wb.getSheetAt(0);
		    XSSFRow row;
		    XSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < rows; i++) {
		    	if(i>0)
		    	{
			        row = sheet.getRow(i);
			        if(row != null) {
			            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
			            if(tmp > cols) cols = tmp;
			        }
		    	}
		    }

		    for(int r = 0; r < rows; r++) {
		    	if(r>0)
		    	{
			        row = sheet.getRow(r);
			        if(row != null) {
			            for(int c = 0; c < cols; c++) {
			                cell = row.getCell((short)c);
			                if(cell != null) {
			                    // Your code here
			                	//System.out.println("Data: "+cell.toString());
			                	if(cell.toString().contains(".0"))
			                	{
			                		//inputArray[r-1][c]=cell.toString().replace(".0", "");
			                		input=input+cell.toString().replace(".0", "");
			                	}
			                	else
			                	{
			                		input=input+cell.toString();
			                		//inputArray[r-1][c]=cell.toString();
			                	}
			                	
			                	
			                }
			                if(c<(cols-1))
			                {
			                	input=input+";";
			                }
			                
			            }
			            
			        }
		    	}
		    	input=input+"%";
		    }
		    //System.out.println("Input Data: "+input);
		    fs.close();
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
		return input;
	}
	
}
