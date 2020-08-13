package com.allanimit.mainPackage;

public class Developer {

    private int id;
    private int age;
    private int phone;
    private String adress;
    private String fname;
    private String lname;
    private String skill;

    public Developer() { }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    
    public Developer(int id, int age, int phone, String adress, String fname, String lname, String skill) {
        super();
        this.id = id;
        this.age = age;
        this.phone = phone;
        this.adress = adress;
        this.fname = fname;
        this.lname = lname;
        this.skill = skill;
    }
    
    public Developer(int age, int phone, String adress, String fname, String lname, String skill) {
        this.age = age;
        this.phone = phone;
        this.adress = adress;
        this.fname = fname;
        this.lname = lname;
        this.skill = skill;
    }


}
