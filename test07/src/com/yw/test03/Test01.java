package com.yw.test03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test01 {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
		        new String[] {"bean5.xml"});
		
		BeanFactory factory = (BeanFactory) context;
		
		Client client=(Client)factory.getBean("theClientBean");
//		System.out.println(client.getTargetName());
		String name=client.getTargetName();
		Target target=(Target)factory.getBean(name);
		System.out.println(target);
		
		


	}

}
