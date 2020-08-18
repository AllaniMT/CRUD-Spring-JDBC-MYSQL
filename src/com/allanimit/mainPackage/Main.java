package com.allanimit.mainPackage;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataBaseTemplate dao = (DataBaseTemplate) ctx.getBean("edao");

        //***Insert***
        //int status = dao.insertDeveloper(new Developer(26, 0177, "Frankfurt", "Mohamed Tayeb", "Allani", "Java"));

        //***Delete***
        //Developer developer = new Developer();
        //developer.setId(1);
        //int status=dao.deleteDeveloper(developer);

        //***Updatte
        //Developer developer = new Developer();
        //developer.setId(2);
        //int status =  dao.updateDevloper(new Developer(2, 26, 0177, "Frankfurt am Main", "Mohamed Tayeb", "Allani", "Python"));
        //System.out.println(status);

        //*** Insert with PreparedStatement

        //Boolean status = dao.insertDeveloperWithPS(new Developer(26, 0177, "Hamburg Nord", "Mohamed Tayeb", "Allani", "C++"));
        //System.out.println(status);

        //*** Update with PreparedStatement
        //Boolean status = dao.updateDeveloperWithPS(new Developer(3,26, 0177, "Kiel", "Mohamed Tayeb", "Allani", "C++"));
        //System.out.println(status);

        //*** Delete with PreparedStatement
        //Developer developer = new Developer();
        //developer.setId(2);
        //Boolean status=dao.deleteDeveloperWithPS(developer);
        //System.out.println(status);

        //Show all Developer

        List<Developer> list = dao.viewAll();
        for (Developer developer : list) {
            System.out.println(developer.showInfo());
        }

    }

}
