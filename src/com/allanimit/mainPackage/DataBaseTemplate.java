package com.allanimit.mainPackage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.allanimit.mainPackage.Developer;
import com.mysql.cj.xdevapi.PreparableStatement;


public class DataBaseTemplate {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Add new developer to the db
    /*
    public int insertDeveloper(Developer developer) {
        String insertSqlQuery = "insert into developer (`age`, `phone`, `adress`, `fname`, `lname`, `skill`) values('"
                + developer.getAge() + "','" + developer.getPhone() + "','" + developer.getAdress() + "','" + developer.getFname() + "','" + developer.getLname() + "','" + developer.getSkill() + "')";
        return jdbcTemplate.update(insertSqlQuery);
    }
    */
    //PreparedStatement
    public Boolean insertDeveloperWithPS(Developer developer) {
        String insertSqlQuery = "insert into developer (`age`, `phone`, `adress`, `fname`, `lname`, `skill`) values(?,?,?,?,?,?)";
        return jdbcTemplate.execute(insertSqlQuery, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1, developer.getAge());
                preparedStatement.setInt(2, developer.getPhone());
                preparedStatement.setString(3, developer.getAdress());
                preparedStatement.setString(4, developer.getFname());
                preparedStatement.setString(5, developer.getLname());
                preparedStatement.setString(6, developer.getSkill());
                System.out.println(insertSqlQuery);
                System.out.println(preparedStatement);
                return preparedStatement.execute();
            }
        });
    }

    //Update employee
    /*
    public int updateDevloper(Developer developer) {
        String updateSqlQuery = "UPDATE `developer` SET `age`=" + developer.getAge() +  ", `phone`="+ developer.getPhone() + ", `adress`=\"" + developer.getAdress() +"\", `fname`=\"" + developer.getFname() + "\", `lname`=\"" + developer.getLname() + "\", `skill`=\"" + developer.getSkill() + "\" WHERE "  + developer.getId(); 
        System.out.println(updateSqlQuery);
        return jdbcTemplate.update(updateSqlQuery);  
    }
	*/

    public Boolean updateDeveloperWithPS(Developer developer) {
        String updateSqlQuery = "UPDATE `developer` SET `age`=?,`phone`=?,`adress`=?, `fname`=?, `lname`=?, `skill`=? WHERE id=?";
        return jdbcTemplate.execute(updateSqlQuery, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1, developer.getAge());
                preparedStatement.setInt(2, developer.getPhone());
                preparedStatement.setString(3, developer.getAdress());
                preparedStatement.setString(4, developer.getFname());
                preparedStatement.setString(5, developer.getLname());
                preparedStatement.setString(6, developer.getSkill());
                preparedStatement.setInt(7, developer.getId());

                System.out.println(updateSqlQuery);
                System.out.println(preparedStatement);
                return preparedStatement.execute();
            }
        });
    }


    /*
      public int deleteDeveloper(Developer developer) {
          String deleteSqlQuery = "DELETE FROM `developer` WHERE id=" + developer.getId() ;
          return jdbcTemplate.update(deleteSqlQuery);
      }
      */
    public Boolean deleteDeveloperWithPS(Developer developer) {
        String updateSqlQuery = "DELETE FROM `developer` WHERE id=?";
        return jdbcTemplate.execute(updateSqlQuery, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1, developer.getId());

                System.out.println(updateSqlQuery);
                System.out.println(preparedStatement);
                return preparedStatement.execute();
            }
        });
    }

    //Read from database
    public List<Developer> viewAll() {
        String readSqlQuery = "SELECT * from developer";
        return jdbcTemplate.query(readSqlQuery, new RowMapper<Developer>() {

            @Override
            public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Developer developer = new Developer();

                developer.setId(rs.getInt(1));
                developer.setAge(rs.getInt(2));
                developer.setPhone(rs.getInt(3));
                developer.setAdress(rs.getString(4));
                developer.setFname(rs.getString(5));
                developer.setLname(rs.getString(6));
                developer.setSkill(rs.getString(7));

                return developer;
            }
        });

    }
}
