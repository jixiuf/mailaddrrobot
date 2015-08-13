import java.util.HashSet;
import java.util.Set;

//爬虫的主操作
public class Crawler {
	private Set<String> emails = new HashSet<String>();
	int num =0;
	//爬取网页中的url
	private void initCrawler(String url){
		Set<String> set = HtmlParse.getUrl(url);
		for(String s:set){
			LinkDB.addUnvisitedUrl(s);
		}
	}
	public void crawling(String url){
		initCrawler(url);
		//判定条件
		while(!LinkDB.unVisitedUrlsEmpty()&&LinkDB.getVisitedUrlNum()<=100){
			//队头出Url
			String visitUrl = LinkDB.unVisitedUrlDeQueue();
			//在控制台显示所爬url
			System.out.println(visitUrl);
			num++;
			if(visitUrl==null)
				continue;
			LinkDB.addVisitedUrl(visitUrl);
			Set<String> email = HtmlParse.getEmail(visitUrl);
			emails.addAll(email);
			initCrawler(visitUrl);
		}
		for(String s:emails){
			System.out.println(s);
		}
		FileSave.fileSave(emails);
		System.out.println("网页个数"+num);
		System.out.println("邮箱个数"+emails.size());

	}
	public static void main(String[] args) {
		//输入想要爬取的url，记住一定得是所选贴吧的首页（这个是邮箱吧）
		new Crawler().crawling("http://tieba.baidu.com/f?kw=%D3%CA%CF%E4&fr=ala0");

	}

}
