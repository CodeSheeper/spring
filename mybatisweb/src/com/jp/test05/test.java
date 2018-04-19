package com.jp.test05;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jp.test05.pojo.Blog;

public class test {

	public static void main(String[] args) {
		SqlSession session=null;
		try {
			String resource = "com/jp/test05/mybatis-config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session=sqlSessionFactory.openSession();
			Blog blog=session.selectOne("com.jp.text05.BlogMapper.selectBlog", 1);
			System.out.println("blog="+blog);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//session.close();
		}

	}

}
