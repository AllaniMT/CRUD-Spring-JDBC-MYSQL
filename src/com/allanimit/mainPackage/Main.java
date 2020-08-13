package com.allanimit.mainPackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataBaseTemplate dao = (DataBaseTemplate) ctx.getBean("edao");
        
        //***Insert**
        //int status = dao.insertDeveloper(new Developer(26, 0177, "Frankfurt", "Mohamed Tayeb", "Allani", "Java"));
        
        //***Delete***
        //Developer developer = new Developer();
        //developer.setId(1);
        //int status=dao.deleteDeveloper(developer);
       
        //***Updatte
        
		Developer developer = new Developer();
		//developer.setId(2);
		int status =  dao.updateDevloper(new Developer(2, 26, 0177, "Frankfurt am Main", "Mohamed Tayeb", "Allani", "Python"));
		System.out.println(status);
		

        //int status=dao.deleteDeveloper(developer);
        //System.out.println(status);*/

    }

}
