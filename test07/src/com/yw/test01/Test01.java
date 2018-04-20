package com.yw.test01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test01 {
	public static void main(String[] args) {
//		Resource resource = new FileSystemResource("src/bean.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		
//		ClassPathResource resource = new ClassPathResource("bean.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);

		
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//		        new String[] {"bean2.xml","bean.xml"});
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
		        new String[] {"bean3.xml"});
		// of course, an ApplicationContext is just a BeanFactory
		BeanFactory factory = (BeanFactory) context;

		System.out.println("factory="+factory);
//		Object obj=factory.getBean("dog");
//		Object obj2=factory.getBean("dog2");
		Object obj3=factory.getBean("dog3");
//		System.out.println("obj="+obj);
//		System.out.println("obj2="+obj2);
		System.out.println("obj3="+obj3);
		
//		Dog dog=(Dog)obj;
//		System.out.println(dog.getA()+"==="+dog.isB());
//		
//		Dog dog2=(Dog)obj2;
//		System.out.println(dog2.getA()+"==="+dog2.isB());
		
		Dog dog3=(Dog)obj3;
		System.out.println("dog3.getC()===="+dog3.getC());

	}

}
