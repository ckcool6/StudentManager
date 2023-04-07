import Domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> list = new ArrayList<>();

        lo:
        while (true) {
            //menu
            System.out.println("-------学生管理系统-------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择：");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    addStudent(list);
                    break;
                case "2":
                    deleteStudent(list);
                    break;
                case "3":
                    updateStudent(list);
                    break;
                case "4":
                    queryStudents(list);
                    break;
                case "5":
                    System.out.println("感谢使用");
                    break lo;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
    }

    public static void updateStudent(ArrayList<Student> list) {

        System.out.println("请输入要修改的学号");
        Scanner sc = new Scanner(System.in);
        String updateSid = sc.next();
        int index = getIndex(list, updateSid);
        if (index == -1) {
            System.out.println("查无信息，重新输入");
        } else {
            System.out.println("请输入新学生姓名：");
            String name = sc.next();
            System.out.println("请输入新学生年龄：");
            int age = sc.nextInt();
            System.out.println("请输入新学生生日：");
            String birthday = sc.next();
            Student stu = new Student(updateSid, name, age, birthday);
            list.set(index, stu);
            System.out.println("修改成功");
        }
    }

    public static void deleteStudent(ArrayList<Student> list) {

        System.out.println("请输入要删除的学号");
        Scanner sc = new Scanner(System.in);
        String deleteSid = sc.next();
        int index = getIndex(list, deleteSid);
        if (index == -1) {
            System.out.println("查无信息，重新输入");
        } else {
            list.remove(index);
            System.out.println("删除成功");
        }

    }

    public static void queryStudents(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("无信息，请添加后重新查询");
            return;
        }
        System.out.println("学号\t姓名\t年龄\t生日");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());
        }
    }

    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String sid;

        while (true) {
            System.out.println("请输入学号：");
            sid = sc.next();
            int index = getIndex(list, sid);
            if (index == -1) {
                break;
            }
        }

        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入生日");
        String birthday = sc.next();

        Student stu = new Student(sid, name, age, birthday);
        list.add(stu);

        System.out.println("添加成功！");

    }

    public static int getIndex(ArrayList<Student> list, String sid) {

        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String id = stu.getSid();
            if (id.equals(sid)) {
                index = i;
            }
        }
        return index;
    }
}

