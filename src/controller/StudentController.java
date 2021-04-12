package controller;

import bean.*;
import serviceImpl.StudentServiceImpl;

import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StudentServiceImpl studentService = new StudentServiceImpl();

        while (true) {
            System.out.println("-----------菜单------------");
            System.out.println("1:添加学生");
            System.out.println("2:通过姓名获取分数");
            System.out.println("3:查看全体");
            System.out.println("4:通过排名查找姓名");
            System.out.println("5:查看男生的排名");
            System.out.println("6:查看平均分");
            System.out.println("7:更新学生信息");
            System.out.println("8:删除学生");
            System.out.println("0:退出系统");
            System.out.println("----------------------------");

            System.out.print("请选择：");

            int input;
            try {
                input = in.nextInt();
            } catch (Exception e) {
                System.out.println("请输入正确的选项！");
                continue;
            }

            switch (input) {
                //添加学生
                case 1:
                    System.out.print("请输入姓名：");
                    String name1 = in.next();
                    System.out.print("请输入学号：");
                    String schoolNum1 = in.next();
                    System.out.print("请输入年龄：");
                    String age1 = in.next();
                    System.out.print("请输入性别：");
                    String sex1 = in.next();
                    System.out.print("请输入分数：");
                    int mark1 = in.nextInt();
                    StudentBean student = new StudentBean(name1, schoolNum1, age1, sex1, mark1);
                    ResultBean result1 = studentService.addStudent(student);
                    if (result1.getStatus() == 200)
                        System.out.println("已添加：" + student);
                    else
                        System.out.println("已添加过这个学生");
                    break;


                //通过姓名获取分数
                case 2:
                    System.out.print("请输入姓名：");
                    String name2 = in.next();
                    StudentResultBean studentResultBean2 = studentService.getMarkByName(name2);
                    if(studentResultBean2.getStatus() == 200)
                        System.out.println(name2 + "的分数是：" + studentResultBean2.getStudentBean().getMark());
                    else if(studentResultBean2.getStatus() == 500)
                        System.out.println("还没有添加学生");
                    else
                        System.out.println("没有这个学生");
                    break;

                //查看全体
                case 3:
                    AllResultBean allResultBean3 = studentService.showAll();
                    if(allResultBean3.getStatus() == 200){
                        int cnt4 = 1;
                        for(StudentBean s : allResultBean3.getStudentBeans()) {
                            System.out.println(cnt4 + ". " + s);
                            cnt4++;
                        }
                    } else if(allResultBean3.getStatus() == 500)
                        System.out.println("还没有添加学生");
                    else
                        System.out.println("出现异常");
                    break;


                //通过排名查找姓名
                case 4:
                    System.out.print("请输入排名：");
                    String rank3 = in.next();
                    rank3 = String.valueOf(Integer.parseInt(rank3) - 1);

                    StudentResultBean studentResultBean4 = studentService.getNameByRank(rank3);
                    if(studentResultBean4.getStatus() == 200)
                        System.out.println("第" + (Integer.parseInt(rank3) + 1) + "名同学的姓名是：" +
                                studentResultBean4.getStudentBean().getName());
                    else if(studentResultBean4.getStatus() == 500)
                        System.out.println("还没有添加学生");
                    else
                        System.out.println("此排名没有学生");
                    break;


                //查看男生的排名
                case 5:
                    AllResultBean allResultBean5 = studentService.showRanksInBoy();
                    if(allResultBean5.getStatus() == 200){
                        int cnt4 = 1;
                        for(StudentBean s : allResultBean5.getStudentBeans()) {
                            System.out.println(cnt4 + ". " + s);
                            cnt4++;
                        }
                    } else if(allResultBean5.getStatus() == 500)
                        System.out.println("还没有添加学生");
                    else
                        System.out.println("没有男生");
                    break;


                //查看平均分
                case 6:
                    AverageMarkBean averageMarkBean6 = studentService.getAverageMark();
                    if(averageMarkBean6.getStatus() == 200)
                        System.out.println("共有" + averageMarkBean6.getCount() + "名同学，平均分为：" +
                                averageMarkBean6.getAverageMark());
                    else
                        System.out.println("还没有添加学生");
                    break;


                //更新学生信息
                case 7:
                    System.out.print("请输入姓名：");
                    String name5 = in.next();
                    System.out.print("请输入年龄：");
                    String age5 = in.next();
                    System.out.print("请输入性别：");
                    String sex5 = in.next();
                    System.out.print("请输入分数：");
                    int mark5 = in.nextInt();
                    StudentResultBean studentResultBean7 = studentService.updateStudent(name5, age5, sex5, mark5);
                    if(studentResultBean7.getStatus() == 200){
                        System.out.println(name5 + "的信息已修改为：" + studentResultBean7.getStudentBean());
                    }else if(studentResultBean7.getStatus() == 500)
                        System.out.println("还没有添加学生");
                    else
                        System.out.println("没有这个学生");
                    break;

                //删除学生
                case 8:
                    System.out.print("请输入姓名：");
                    String name6 = in.next();
                    ResultBean result8 = studentService.deleteStudent(name6);
                    if(result8.getStatus() == 200)
                        System.out.println(name6 + "已被删除");
                    else if(result8.getStatus() == 500)
                        System.out.println("还没有添加学生");
                    else
                        System.out.println("没有这个学生");
                    break;

                //退出系统
                case 0:
                    System.out.println("谢谢使用！");
                    System.exit(0);
                    break;

                //无效输入
                default:
                    System.out.println("请输入正确的选项！");
                    break;
            }
        }
    }
}
