package com.yw.test07;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean7.xml");
		BeanFactory factory=(BeanFactory)context;
		
		A a=(A)factory.getBean("a");
		System.out.println("a="+a);
		System.out.println(a.getB());
		
		a=(A)factory.getBean("a");
		System.out.println("a="+a);
		System.out.println(a.getB());
	}

}
