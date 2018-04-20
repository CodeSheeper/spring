package com.yw.test02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test01 {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
		        new String[] {"bean4.xml"});
		
		BeanFactory factory = (BeanFactory) context;

//		A a=(A)factory.getBean("a");
//		String name=a.getB().getName();
//		System.out.println("name="+name);
		
		C c=(C)factory.getBean("c");
		System.out.println("c="+c);
		
		c=(C)factory.getBean("c");
		System.out.println("c="+c);
		

	}

}
