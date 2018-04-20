package com.yw.test06;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test01 {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
		        new String[] {"bean6.xml"});
		
		BeanFactory factory = (BeanFactory) context;
		
		ComplexObject co=(ComplexObject)factory.getBean("moreComplexObject");
		
		Properties p=co.getAdminEmails();
		
		System.out.println(p);
		
		List list=co.getSomeList();
		System.out.println(list instanceof LinkedList);
		
		Map map=co.getSomeMap();
		System.out.println(map instanceof LinkedHashMap);
		
		Set set=co.getSomeSet();
		System.out.println(set instanceof LinkedHashSet);


	}

}
