package project1.ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

class TestFile
{
	
	private static String SOURCE = "src/project1/ver08/TestFile.txt";
	
	public static void out_info()
	{
		FileOutputStream f_stream = null;
		try
		{
			f_stream = new FileOutputStream(SOURCE);
			ObjectOutputStream d_stream = new ObjectOutputStream(f_stream);

			Date info = new Date();
				d_stream.writeObject(info);
			
			f_stream.close();
			d_stream.close();
			System.out.println("obj파일로 저장됐습니다.");
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void in_info()
	{
		FileInputStream f_stream = null;
		Date info = null;
		try
		{
			f_stream = new FileInputStream(SOURCE);
			ObjectInputStream d_stream = new ObjectInputStream(f_stream);

			info = (Date)d_stream.readObject();
			System.out.println(info.toString());
			
			f_stream.close();
			d_stream.close();
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
	
		out_info();
		System.out.println("=====================");
		in_info();
	}
}
