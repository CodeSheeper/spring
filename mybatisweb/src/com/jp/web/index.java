package com.jp.web;




import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.jp.test02.pojo.Person;
import com.jp.utils.PrintUtil;
public class index extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SqlSession session = null;
		String opr = request.getParameter("opr");
		try {
			String resource = "com/jp/test02/mybatis-config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("ok====");
			session = sqlSessionFactory.openSession(true);
			// 基于XML
			   if (opr==null) {
				   List<Person> plist = session.selectList("com.jp.test02.PersonMapper.selectAll");
					request.setAttribute("plist", plist);
					request.getRequestDispatcher("jsp/test01.jsp").forward(request, response);
				
			}
				

			   else  if (opr != null && opr.equals("add")) {
				Person person = new Person();
				person.setAge(Integer.parseInt(request.getParameter("age")));
				person.setName(request.getParameter("name"));
				String result = Integer.valueOf(session.insert("com.jp.test02.PersonMapper.insertPerson", person))
						.toString();
				PrintUtil.write(result, response);
				System.out.println("进入add");

			} else if (opr!= null && opr.equals("del")) {
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("id------" + id);
				String result = Integer.valueOf(session.delete("com.jp.test02.PersonMapper.deletePerson", id))
						.toString();
				PrintUtil.write(result, response);
				System.out.println("进入del");
			}
			else if (opr!= null && opr.equals("update")) {
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			session.close();
		}
	

	}

}
