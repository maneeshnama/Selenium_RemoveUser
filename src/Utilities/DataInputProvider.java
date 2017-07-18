package Utilities;

        import java.io.FileInputStream;

		import java.io.FileNotFoundException;

		import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;

		import org.apache.poi.xssf.usermodel.XSSFRow;

		import org.apache.poi.xssf.usermodel.XSSFSheet;

		import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class DataInputProvider {

			private static XSSFSheet ExcelWSheet;

			private static XSSFWorkbook ExcelWBook;

			private static XSSFCell Cell;

			private static XSSFRow Row;

		public static Object[][] getDataArray(String FilePath, String SheetName) throws Exception {   

		   String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   ExcelWBook = new XSSFWorkbook(ExcelFile);

			   ExcelWSheet = ExcelWBook.getSheet(SheetName);

			   int startRow = 0;

			   int startCol = 1;

			   int ci,cj;

			   //Get Row count
			   int totalRows = ExcelWSheet.getLastRowNum();
			   
			   int rowIndex=0;
			   XSSFRow r = ExcelWSheet.getRow(rowIndex);
			   int maxCell = r.getLastCellNum();
			   int YesCount=0;
			   
			   for(int coloumIndex=1; coloumIndex<=maxCell; coloumIndex++){
				   XSSFRow row = (XSSFRow) CellUtil.getRow(rowIndex, ExcelWSheet);
				   org.apache.poi.ss.usermodel.Cell cell = CellUtil.getCell(row, coloumIndex);
				   
				   if(cell.getStringCellValue().equalsIgnoreCase("Y"))
				   {
					   YesCount = YesCount+1;
				   }
			   }
			   
			   XSSFRow row = ExcelWSheet.getRow(totalRows);
			   
			   //Get Column count
			   int totalCols=row.getLastCellNum();
			   int totalColcnt=row.getLastCellNum()-1;

			   tabArray=new String[YesCount][totalRows+1];

			   	
			   		cj=0;
			   		ci=0;
					   for (int j=startCol;j<totalCols;j++){
						     if(getCellData(0, j).equalsIgnoreCase("Y")){
						    	 
						    	  for (int i=startRow;i<totalRows+1;i++) {       
									   
									   tabArray[ci][cj]=getCellData(i,j);

									   //System.out.println(tabArray[ci][cj]);  
									   
									   ++cj;
									   
										}
									   
									   cj=0;
									   
									   ++ci;
						     }
						 
					   
				   		} 

				}

			catch (FileNotFoundException e){

				//System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				//System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}

		public static String getCellData(int RowNum, int ColNum) throws Exception {
			 
			try{
 
				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
				
				int dataType = Cell.getCellType();
				
				Cell.setCellType(Cell.CELL_TYPE_STRING);
										
					if(dataType == 3){
						return "";
					} else {
						
						String CellData = Cell.getStringCellValue();
						return CellData;
					}
					
				}catch (Exception e){
 
				//System.out.println(e.getMessage());
 
				throw (e);
 
				}
 
			}
 
	}