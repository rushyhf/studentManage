package service;

import bean.*;

public interface StudentService {
    ResultBean addStudent(StudentBean student); //添加学生
    StudentResultBean getMarkByName(String name); //通过姓名获取分数
    AllResultBean showAll(); //查看全体
    StudentResultBean getNameByRank(String rank); //通过排名查找姓名
    AllResultBean showRanksInBoy(); //查看男生的排名
    AverageMarkBean getAverageMark(); //查看平均分
    StudentResultBean updateStudent(String name, String age, String sex, int mark); //更新学生信息
    ResultBean deleteStudent(String name); //删除学生
}
