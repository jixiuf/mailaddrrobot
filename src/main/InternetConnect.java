import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/*
 * 连接网页，下载网页
 * get通信
 */
public class InternetConnect {
	static HttpClient httpClient;
	public static String getRequst(String url) throws Exception{
		httpClient = new DefaultHttpClient();
		try{
			//使用get方式连接，得到回应，如果状态码为200则...自己看代码
			HttpGet get = new HttpGet(url);

			HttpResponse httpResponse = httpClient.execute(get);

			if(httpResponse.getStatusLine().getStatusCode()==200){
				//以字符串形式获取网页源码
				String result = EntityUtils.toString(httpResponse.getEntity());
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return"worry";}finally{
	//妈妈曾经告诉我..好吧，是老师，画虚线的方法都是老的要被淘汰的，但这个是我以前做项目时辛苦收藏的，于是坚持用。
				httpClient.getConnectionManager().shutdown();
			}
		return null;
	}
}
