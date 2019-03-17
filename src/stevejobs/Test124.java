package stevejobs;
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
public class Test124 
{
	public static void main(String[] args) throws Exception
	{
		//Open Excel file for reading
		File f=new File("testdata.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0); //0 means sheet1
		int nour=rsh.getRows();
		//Open same excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0); //0 means sheet1
		//Data driven
		//0th row have names of columns
		for(int i=1;i<nour;i++)
		{
			int x=Integer.parseInt(
					rsh.getCell(0,i).getContents());
			int y=Integer.parseInt(
					rsh.getCell(1,i).getContents());
			int z=x+y;
			Number n=new Number(2,i,z);
			wsh.addCell(n);
		}
		//Save and close excel
		wwb.write(); //save
		wwb.close();
		rwb.close();
	}
}









