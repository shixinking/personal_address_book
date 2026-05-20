package entity;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String location;
    private int phone;
    private String gender;
    private String group;

    public Person() {
        name = "";
        location = "";
        phone = 0;
        gender = "";
        group = "";
    }

    public Person(String mname, String mloc, int mphone, String mgender, String mgroup) {
        name = mname;
        location = mloc;
        phone = mphone;
        gender = mgender;
        group = mgroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getGender() {
        return gender;
    }

    public int getPhone() {
        return phone;
    }

    public String getGroup() {
        return group;
    }

    public void get_info() {
        System.out.println("姓名:" + name);
        System.out.println("地区:" + location);
        System.out.println("性别:" + gender);
        System.out.println("电话:" + phone);
        System.out.println("分组:" + group);
    }

}
