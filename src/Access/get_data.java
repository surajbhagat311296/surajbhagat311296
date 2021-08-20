package Access;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList; 

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class get_data {
	public static ArrayList<Object[]> getdatafrom_excel() throws IOException
	{
		ArrayList<Object[]>  mydata=new ArrayList<Object[]>();
	String excelpath="D:\\accenture\\data_file.xlsx";
	FileInputStream inp=new FileInputStream(excelpath);
	XSSFWorkbook  wb=new XSSFWorkbook(inp);
	XSSFSheet sheet=wb.getSheetAt(0);
	int rows=sheet.getLastRowNum();
	int cols=sheet.getRow(1).getLastCellNum();

	String[] strr= new String[cols];
	for(int r=1;r<=rows;r++)
	{
		XSSFRow row=sheet.getRow(r); 
		for(int c=0;c<cols;c++)
		{
		strr[c]=sheet.getRow(r).getCell(c).toString();
	}
	String fname=strr[0];
	System.out.println(fname);
	String lname=strr[1];
	System.out.println(lname);
	String email=strr[2];
	System.out.println(email);
	Object[] ob={fname,lname,email};
	mydata.add(ob);
	}

	wb.close();
	return mydata;
	}

}
