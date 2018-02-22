package com.permissiondenied.permission;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class AppTest {
	@Test
	public void testpermission() throws Exception {	
		String excelPath="C:/Users/Radiant/Desktop/output/";
		DateFormat dateFormat1 = new SimpleDateFormat("MMddyyyy");
		  Date CUR1 = new Date();
		  File filePath = new File(excelPath+dateFormat1.format(CUR1));
		  if(!filePath.exists()){
			  filePath.mkdir(); 
			  filePath.setWritable(true);
			  filePath.setReadable(true);
			  filePath.setExecutable(true);
		}		  
			  String filename=excelPath+dateFormat1.format(CUR1)+"/Aerorepair.xls";
			  File excel = new File(filename);
			  System.out.println("TESTEDPERMISSION");
			  excel.setExecutable(true);
			  excel.setReadable(true);
			  excel.setWritable(true);
			  if(!excel.exists()){
				  HSSFWorkbook workbook = new HSSFWorkbook();
					  HSSFSheet sheet = workbook.createSheet("FirstSheet");
					  HSSFRow rowhead = sheet.createRow((short)0);
					  rowhead.createCell(0).setCellValue("Tag Name");
				      rowhead.createCell(1).setCellValue("Script");
				      rowhead.createCell(2).setCellValue("S0 number");			     
				      rowhead.createCell(3).setCellValue("Validation");			      
				      rowhead.createCell(4).setCellValue("Result");
				      rowhead.createCell(5).setCellValue("Posted Date Time");
				      rowhead.createCell(6).setCellValue("Received Date Time");
				      FileOutputStream fileOut = new FileOutputStream(filename); 
				  workbook.write(fileOut);
				  fileOut.close();
				  System.out.println("TESTEDPERMISSION");
				  //String path="D:\\file\\read.txt";
			      //  File file=new File(path);
			        if (filePath.exists()) {
			            System.out.println("read="+filePath.canRead());
			            System.out.println("write="+filePath.canWrite());
			            System.out.println("Execute="+filePath.canExecute());
			            filePath.setWritable(true);
			            
			        }     	  
}
	}
}