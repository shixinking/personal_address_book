package manage;

import dao.PersonDao;
import entity.Person;
import util.*;

public class PersonManage {
    public static void addPerson()
    {
        String sgroup = ScannerUtil.getString("请输入你要添加的人的分组:");
        String sname = ScannerUtil.getString("请输入你要添加的人的姓名:");
        String ssex = ScannerUtil.getString("请输入你要添加的人的性别:");
        String sarea = ScannerUtil.getString("请输入你要添加的人的地区:");
        String sphone = ScannerUtil.getString("请输入你要添加的人的电话号码:");
        Person person = new Person();
        person.setGroup(sgroup);
        person.setPhone(sphone);
        person.setLocation(sarea);
        person.setGender(ssex);
        person.setName(sname);

        if (PersonDao.addPerson(person))
        {
            System.out.println("添加成功");
        }
        else
        {
            System.out.println("添加失败");
        }
    }

    public static void deletePerson()
    {
        String sgroup = ScannerUtil.getString("请输入你要删除的人的分组:");
        String sname = ScannerUtil.getString("请输入你要删除的人的姓名:");
        String ssex = ScannerUtil.getString("请输入你要删除的人的性别:");
        String sarea = ScannerUtil.getString("请输入你要删除的人的地区:");
        String sphone = ScannerUtil.getString("请输入你要删除的人的电话号码:");
        Person person = new Person();
        person.setGroup(sgroup);
        person.setPhone(sphone);
        person.setLocation(sarea);
        person.setGender(ssex);
        person.setName(sname);
        if (PersonDao.deletePerson(person))
        {
            System.out.println("删除成功");
        }
        else
        {
            System.out.println("删除失败");
        }
    }

    public static void selectPerson()
    {
        System.out.println("请选择查询内容");
        int input = ScannerUtil.getMenuChoice("0.分组\n1.姓名\n2.性别\n3.地址\n4.电话号码\n",0,4);
        String string = ScannerUtil.getString("请输入:");
        if (!PersonDao.selectphone(string,input))
        {
            System.out.println("查找失败");
        }
    }

    public static void updatePerson()
    {
        String sgroup = ScannerUtil.getString("请输入你要更新的人的分组:");
        String sname = ScannerUtil.getString("请输入你要更新的人的姓名:");
        String ssex = ScannerUtil.getString("请输入你要更新的人的性别:");
        String sarea = ScannerUtil.getString("请输入你要更新的人的地区:");
        String sphone = ScannerUtil.getString("请输入你要更新的人的电话号码:");
        Person person = new Person();
        person.setGroup(sgroup);
        person.setPhone(sphone);
        person.setLocation(sarea);
        person.setGender(ssex);
        person.setName(sname);

        System.out.println("请选择你要更改的属性");
        int input = ScannerUtil.getMenuChoice("0.分组\n1.姓名\n2.性别\n3.地址\n4.电话号码",0,4);
        String string = ScannerUtil.getString("你要将其替换为：");
        if (PersonDao.updatePerson(person,input,string))
        {
            System.out.println("更改成功");
        }
        else
        {
            System.out.println("更改失败");
        }
    }

    public static void showPersonAddress()
    {
        if (!PersonDao.showAddress())
        {
            System.out.println("查询失败,通讯录可能为空");
        }
    }

    public static void recreateAddress()
    {
        if (!PersonDao.recreate())
        {
            System.out.println("重置失败");
        }
    }
}
