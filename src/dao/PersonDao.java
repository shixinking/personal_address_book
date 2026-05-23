package dao;

import entity.Person;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    private static File file = new File("address.txt");

    static {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 打印信息
    public static void print(String[] person) {
        System.out.println("分组:" + person[0]);
        System.out.println("姓名:" + person[1]);
        System.out.println("性别:" + person[2]);
        System.out.println("地区:" + person[3]);
        System.out.println("电话号码:" + person[4]);
        System.out.println('\n');
    }

    // 展示通讯录
    public static boolean showAddress()
    {
        boolean res = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                res = true;
                String[] lineperson = line.split("\\|");
                print(lineperson);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return res;
    }

    // 获取绝对路径
    public static String getAbsolutePath() {
        return file.getAbsolutePath();
    }

    //重置通讯录
    public static boolean recreate() {
        file.delete();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 通讯录中加一个人
    public static boolean addPerson(Person person) {
        String write = person.getGroup() + "|" + person.getName() + "|" + person.getGender() + "|" + person.getLocation() + "|" + person.getPhone();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(write);
            bufferedWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // 根据信息查询
    public static boolean selectphone(String string,int i) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean res = false;
            while ((line = br.readLine()) != null) {
                String[] person = line.split("\\|");
                if (person[i].equals(string)) {
                    print(person);
                    res = true;
                }
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    // 删除用户
    public static boolean deletePerson(Person person) {
        List<Person> list = new ArrayList<>();
        boolean res = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("\\|");
                Person p1 = new Person();
                p1.setGroup(p[0]);
                p1.setName(p[1]);
                p1.setGender(p[2]);
                p1.setLocation(p[3]);
                p1.setPhone(p[4]);

                if (!p1.getPhone().equals(person.getPhone())
                        || !p1.getName().equals(person.getName())
                        || !p1.getGender().equals(person.getGender())
                        || !p1.getLocation().equals(person.getLocation())
                        || !p1.getGroup().equals(person.getGroup())) {

                    list.add(p1);
                }
                else
                {
                    res = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < list.size(); i++) {
                Person p = list.get(i);
                String s = p.getGroup() + "|" + p.getName() + "|" + p.getGender() + "|" + p.getLocation() + "|" + p.getPhone();
                bw.write(s);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return res;
    }

    //改通讯录信息
    public static boolean updatePerson(Person person, int i, String s) {
        List<Person> list = new ArrayList<>();
        boolean res = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("\\|");
                Person p1 = new Person();
                p1.setGroup(p[0]);
                p1.setName(p[1]);
                p1.setGender(p[2]);
                p1.setLocation(p[3]);
                p1.setPhone(p[4]);

                if (p1.getPhone().equals(person.getPhone())) {
                    if (i == 0) {
                        p1.setGroup(s);
                    } else if (i == 1) {
                        p1.setName(s);
                    } else if (i == 2) {
                        p1.setGender(s);
                    } else if (i == 3) {
                        p1.setLocation(s);
                    } else if (i == 4) {
                        p1.setPhone(s);
                    }
                    res = true;
                }

                list.add(p1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int j = 0; j < list.size(); j++) {
                Person p = list.get(j);
                String q = p.getGroup() + "|" + p.getName() + "|" + p.getGender() + "|" + p.getLocation() + "|" + p.getPhone();
                bw.write(q);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return res;
    }

}