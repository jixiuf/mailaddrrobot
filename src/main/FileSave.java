import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class FileSave {
	//保存到指定txt
	public static void fileSave(Set<String> set){
		//读取当前时间来当做文件名
		Date date =new Date();
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyyMMddHHmm");
		System.out.println("存放的txt名为"+dateFormat.format(date)+"email.txt");
		try{
		File file = new File(dateFormat.format(date)+"email.txt");
		BufferedWriter writer =new BufferedWriter(new FileWriter(file));
		for(String s:set){
			//换行得是\r\n
			writer.write(s+"\r\n");
		}
		writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}

	}
}
