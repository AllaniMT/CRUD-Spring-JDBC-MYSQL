package com.allanimit.mainPackage;

import org.springframework.jdbc.core.JdbcTemplate;

import com.allanimit.mainPackage.Developer;


public class DataBaseTemplate {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Add new developer to the db
    public int insertDeveloper(Developer developer) {
        String insertSqlQuery = "insert into developer (`age`, `phone`, `adress`, `fname`, `lname`, `skill`) values('"
                + developer.getAge() + "','" + developer.getPhone() + "','" + developer.getAdress() + "','" + developer.getFname() + "','" + developer.getLname() + "','" + developer.getSkill() + "')";
        return jdbcTemplate.update(insertSqlQuery);
    }

    //Update employee
    public int updateDevloper(Developer developer) {
        String updateSqlQuery = "UPDATE `developer` SET (`age`, `phone`, `adress`, `fname`, `lname`, `skill`) VALUES ( "
                + developer.getAge() + "','" + developer.getPhone() + "','" + developer.getAdress() + "','" + developer.getFname() + "','" + developer.getLname() + "','" + developer.getSkill() + " WHERE id=" + developer.getId() + ")";
        return jdbcTemplate.update(updateSqlQuery);
    }

    public int deleteEmployee(Developer developer) {
        String deleteSqlQuery = "DELETE FROM `devloper` WHERE id=" + developer.getId() + ")";
        return jdbcTemplate.update(deleteSqlQuery);
    }


}
