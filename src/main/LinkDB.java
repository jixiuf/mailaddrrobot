import java.util.HashSet;
import java.util.Set;
//一般步骤为：定义数据结构及其操作
public class LinkDB {
	//已访问的url
	private static Set<String> visitedUrl = new HashSet<String>();
	//未访问的url
	private static Queue<String> unVisitedUrl = new Queue<String>();

	public static Queue<String> getUnVisitedUrl(){
		return unVisitedUrl;
	}

	public static void addVisitedUrl(String url){
		visitedUrl.add(url);
	}

	public static void removeVisitedUrl(String url){
		visitedUrl.remove(url);
	}

	public static String unVisitedUrlDeQueue(){
		return unVisitedUrl.deQueue();
	}
	//确定每个url只访问过一次
	public static void addUnvisitedUrl(String url){
		if(url !=null&&!url.trim().equals("")&&!visitedUrl.contains(url)&&!unVisitedUrl.contains(url))
			unVisitedUrl.enQueue(url);
	}

	public static int getVisitedUrlNum(){
		return visitedUrl.size();
	}

	public static boolean unVisitedUrlsEmpty(){
		return unVisitedUrl.isQueueEmpty();
	}


}
