package com.jp.test05;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jp.test06.pojo.Author;



public class test2 {

	public static void main(String[] args) {
		SqlSession session=null;
		try {
			String resource = "com/jp/test05/mybatis-config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session=sqlSessionFactory.openSession();
			List<Author> author=session.selectList("com.jp.text05.AuthorMapper.selectAuthor");
			System.out.println("author="+author);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}
