package com.fenghua.auto.backend.common.utils;

import org.apache.commons.httpclient.HttpClientError;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
/**
 * http工具类，传入请求地址。已字符串形式返回内容
 * @author zhangfr
 *
 */
public class HTTPTools {

	private static String defaultUrl = "data/";

	public static String doPost(String url) {
		return doPost(url, "UTF-8", false);
	}

	/**
	 * 通过POST发送请求
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的HTML
	 */
	public static String doPost(String url, String charset, boolean setProxy) {
		try {
			HttpPost httpPost = new HttpPost(url);
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == 200 || statusCode == 201) {
				String result = EntityUtils.toString(httpResponse.getEntity(),
						charset);
				return result;
			} else {
				throw new HttpClientError("请求返回异常！代码："
						+ httpResponse.getStatusLine().getStatusCode()
						+ " url:" + url);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpClientError("发送请求出现异常" + e.getMessage() + " url:"
					+ url);
		}
	}
}
