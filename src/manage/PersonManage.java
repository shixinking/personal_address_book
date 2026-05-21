package manage;

import dao.PersonDao;
import entity.Person;
import util.*;

public class PersonManage {
    public static void addPerson()
    {
        String sgroup = ScannerUtil.getString("请输入你要添加的分组:");
        String sname = ScannerUtil.getString("请输入你要添加的姓名:");
        String ssex = ScannerUtil.getString("请输入你要添加的性别:");
        String sarea = ScannerUtil.getString("请输入你要添加的地区:");
        String sphone = ScannerUtil.getString("请输入你要添加的电话号码:");
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

    }
}
