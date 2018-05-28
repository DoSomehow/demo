package org.ms.tool.gmo;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: HttpUtil
 * @Description: 机器人请求web端
 * @author ChangYuanHao
 * @date 2017-10-11  上午09:49:43
 */
@SuppressWarnings("unchecked")
public class HttpUtil{
	private static String charset = "utf-8";
//	private Integer connectionTimeout = null;
//	private Integer socketTimeout = null;
	private static String proxyHost = null;
	private static Integer proxyPort = null;
	
	
//	public static ExecutorService threadPool = Executors.newFixedThreadPool(Integer.parseInt("300"));

    public static void main(String[] args) {
        String paramStr = "PARA_ENCRYPTION=7b4d4554484f443a27676574476d6f41707044657461696c272c4150505f4e4f533a273531474d313830353134393236303137277d";
        String reqUrl = "http://192.168.20.251:8080/eom/gmWs/wsAction.do";
        String repStr = doPost(reqUrl, paramStr);
        System.out.println(repStr);
    }
	
	/**
	 * 向指定URL发送GET方法的请求
	 * @param url 发送请求的URL
	 * @param parameterMap 请求参数，以Map<String,Object> 的形式
	 * @return 资源响应的结果
	 * @author ChangYuanHao
	 * @time 2017-10-11 上午09:33:32
	 * 
	 */
	public static String doGet(String url,Map<String,Object> parameterMap){
		String strRlt = "";
		StringBuffer parameterBuffer = new StringBuffer();
		StringBuffer rltBuffer = new StringBuffer();
		BufferedReader in = null;
		try {
			if(parameterMap != null){
				Iterator iterator = parameterMap.keySet().iterator();
				String key = null;
				String value = null;
				while(iterator.hasNext()){
					key = (String) iterator.next();
					if(parameterMap.get(key) != null){
						value = (String) parameterMap.get(key);
					}else{
						value = "";
					}
					
					parameterBuffer.append(key).append("=").append(value);
					if(iterator.hasNext()){
						parameterBuffer.append("&");
					}
				}
			}
			String urlNameStr = url + "?" + parameterBuffer.toString();
			URL realUrl = new URL(urlNameStr);
			//打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			//设置通用请求属性
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Accept-Charset", charset);
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1;SV1)");
			//建立实际的连接
			connection.connect();
			//获取所有响应头字段
			Map<String,List<String>> map = connection.getHeaderFields();
			//遍历所有的响应头字段
			for(String key : map.keySet()){
				System.out.println(key+"--->"+map.get(key));
			}
			//定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while((line = in.readLine()) != null){
				rltBuffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//使用finally快来关闭输入流
			try {
				if(in != null){
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rltBuffer.toString();
	}
	
	
	/**
	 * POST方式请求
	 */
	public static String doPost(String url,Map<String,Object> parameterMap){
		StringBuffer parameterBuffer = new StringBuffer();
		
		if(parameterMap != null){
			Iterator iterator = parameterMap.keySet().iterator();
			String key = null;
			String value = null;
			while(iterator.hasNext()){
				key = (String) iterator.next();
				if(parameterMap.get(key) != null){
					value = (String) parameterMap.get(key);
				}else{
					value = "";
				}
				
				parameterBuffer.append(key).append("=").append(value);
				if(iterator.hasNext()){
					parameterBuffer.append("&");
				}
			}
		}
		
		System.out.println("POST parameter : "+parameterBuffer.toString());
		
		
		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		
		
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		
		try {
			URL localURL = new URL(url);
			
			URLConnection connection = openConnection(localURL);
				
			HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
				
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("Accept-Charset", charset);
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterBuffer.length()));
			
			
			String tempLine = null;
			outputStream = httpURLConnection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);
			outputStreamWriter.write(parameterBuffer.toString());
			
			outputStreamWriter.flush();
			//响应失败
			
			if(httpURLConnection.getResponseCode() >= 300){
				throw new Exception("HTTPRequest is not success ,Request code is "+httpURLConnection.getResponseCode());
			}
			//接受响应流
			
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);
			
			while((tempLine = reader.readLine()) != null){
				resultBuffer.append(tempLine);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				if(outputStreamWriter != null){
					outputStreamWriter.close();
				}
				
				if(outputStream != null){
					outputStream.close();
				}
				
				if(reader != null){
					reader.close();
				}
				if(inputStreamReader != null){
					inputStreamReader.close();
				}
				
				if(inputStream != null){
					inputStream.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return resultBuffer.toString();
	}
	
	/**
	 * POST方式请求
	 * parameterStr 拼装好的参数串
	 */
	public static String doPost(String url,String parameterStr){
		System.out.println("POST parameter : "+parameterStr);
		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		try {
			URL localURL = new URL(url);
			URLConnection connection = openConnection(localURL);
			HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setReadTimeout(100*1000);
			httpURLConnection.setRequestProperty("Accept-Charset", charset);
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterStr.getBytes().length));
			httpURLConnection.setRequestProperty("Connection", "Keep-Alive");  
			String tempLine = null;
			outputStream = httpURLConnection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);
			outputStreamWriter.write(parameterStr);
			outputStreamWriter.flush();
			//响应失败
			if(httpURLConnection.getResponseCode() >= 300){
				throw new Exception("HTTPRequest is not success ,Request code is "+httpURLConnection.getResponseCode());
			}
			//接受响应流
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
			reader = new BufferedReader(inputStreamReader);
			while((tempLine = reader.readLine()) != null){
				resultBuffer.append(tempLine);
			}
		} catch (Exception e) {
			// LogHandler.error(LogHandler.SERVICE, "发送http请求出现异常：",e);
		}finally{
			try {
				if(outputStreamWriter != null){
					outputStreamWriter.close();
				}
				
				if(outputStream != null){
					outputStream.close();
				}
				
				if(reader != null){
					reader.close();
				}
				if(inputStreamReader != null){
					inputStreamReader.close();
				}
				
				if(inputStream != null){
					inputStream.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return resultBuffer.toString();
	}
	
	private static URLConnection openConnection(URL localURL){
		URLConnection connection = null;
		try {
			if(proxyHost != null && proxyPort != null){
				Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost, proxyPort));
				connection = localURL.openConnection(proxy);
//				System.out.println("####################################11111##################################");
			}else{
				connection = localURL.openConnection();
//				System.out.println("####################################22222##################################");
			}
		} catch (Exception e) {
			// LogHandler.error(LogHandler.SERVICE, "打开http连接出现异常：",e);
		}
		
		return connection;
	}
	
	
	/**
	 * JSON字符串转成MAP
	 * @param param JSON字符串
	 * @author ChangYuanHao
	 * @time 2017-10-11 上午09:54:03
	 * 
	 */
	public static Map<String,Object> jsonStrToMap(String param){
		Object obj = param;
		JSONObject jsonObject = JSONObject.fromObject(obj);
		Map<String,Object> maps = jsonObject;
		return maps;
	}
	
	public static String doGet(String url){
		StringBuffer rltBuffer = new StringBuffer();
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			//打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			//设置通用请求属性
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Accept-Charset", charset);
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1;SV1)");
			//建立实际的连接
			connection.connect();
			//获取所有响应头字段
			Map<String,List<String>> map = connection.getHeaderFields();
			//遍历所有的响应头字段
			for(String key : map.keySet()){
				System.out.println(key+"--->"+map.get(key));
			}
			//定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while((line = in.readLine()) != null){
				rltBuffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//使用finally快来关闭输入流
			try {
				if(in != null){
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rltBuffer.toString();
	}
	
}
