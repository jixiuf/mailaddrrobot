import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParse {
	//抓取网页中的url
	public static Set<String> getUrl(String url){
		Set<String> set = new HashSet<String>();
		//抓取url的正则表达式，小黄学艺不精，各位看官将就看吧
		Pattern pattern = Pattern.compile("<\\s*a\\s*href\\s*=\\s*\"/p/([^\"]+)");
		try{

			Matcher matcher = pattern.matcher(InternetConnect.getRequst(url));
			while(matcher.find()){
				//帖子的url太简略了，还得我来加.....
				set.add(matcher.group().replaceAll("<a href=\"", "http://tieba.baidu.com"));
				}

			}catch(Exception e){
				e.printStackTrace();
			}
		return set;
	}
	//抓取网页中的邮箱
	public static Set<String> getEmail(String url){
		//用Set集合，去掉重复邮箱
		Set<String> set = new HashSet<String>();
		Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+");
		try{

			Matcher matcher = pattern.matcher(InternetConnect.getRequst(url));
			while(matcher.find()){
				set.add(matcher.group());
				}

			}catch(Exception e){
				e.printStackTrace();
			}
		return set;
	}

}
