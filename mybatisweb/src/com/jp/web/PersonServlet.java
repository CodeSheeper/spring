package com.jp.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jp.pojo.Person;

public class PersonServlet extends HttpServlet {

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
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html,charset=utf-8");
		 PrintWriter out = response.getWriter();
			
			String sPage=request.getParameter("page");
			String sCount=request.getParameter("count");
			
			SqlSession session=null;
			try {
				String resource = "mybatis-config.xml";
				InputStream inputStream;
				inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(inputStream);

				System.out.println("ok====");

				session = sqlSessionFactory.openSession();
				
				Person p=new Person();
				int page=1;
				int count=3;
				int curPage=2;
//				if(sPage!=null&&sPage.trim().length()>0&&MyUtil.isNumber(sPage))
//				{
//					page=Integer.parseInt(sPage)>0?Integer.parseInt(sPage):1;
//					curPage=page;
//				}
//				if(sCount!=null&&sCount.trim().length()>0&&MyUtil.isNumber(sPage))
//				{
//					count=Integer.parseInt(sCount)>0?Integer.parseInt(sPage):1;
//				}
				
				p.setStart((page-1)*count);
				p.setCount(count);

				List list=session.selectList("com.jp.mapper.PersonMapper.selectPerson",p);
				List list2=new ArrayList();
				list2.add(list);
				list2.add(curPage);
				
				System.out.println("list="+list);
				
//				request.setAttribute("list", list);
				
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("list", list);
//				httpSession.setAttribute("list2", list2);
				httpSession.setAttribute("curPage", curPage);
				response.sendRedirect("jsp/person.jsp");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				//session.close();
			}
			
		
		}
		
		
	}


