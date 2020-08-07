package com.allanimit.mainPackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DataBaseTemplate dao=(DataBaseTemplate)ctx.getBean("edao");
		int status=dao.insertDeveloper(new Developer( 26, 0177, "Muenchen", "Mohamed", "Allani", "Java"));
		System.out.println(status);
		
	
		/*int status=dao.updateEmployee(new Developer( 26, 0177, "Essen", "Mohamed", "Allani", "Java"));
		System.out.println(status);
		*/
		
		
		//int status=dao.deleteDeveloper(developer);
		//System.out.println(status);*/
		
	}

}
