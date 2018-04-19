package com.jp.utils;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 * 这个工具类用来打印字符串或json字符串，里面用到fastjson里面的方法
 * @author Administrator
 *
 */
public class PrintUtil {

	public static void print(String msg,HttpServletResponse response){
		response.setContentType("text/html; charset=utf-8");
        PrintWriter writer=null;
		try {
            if(null != response){
                writer=response.getWriter();
                writer.print(msg);
                writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
            writer.close();
        }
    }
	public static void write(Object obj,HttpServletResponse response){
		String json = JSONObject.toJSONString(obj);
		print(json,response);
	}
}
