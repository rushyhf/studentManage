package serviceImpl;

import bean.*;
import service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentServiceImpl implements StudentService {


    HashMap<String, StudentBean> studentMap;
    ResultBean result = new ResultBean();
    StudentResultBean studentResultBean = new StudentResultBean();
    AllResultBean allResultBean = new AllResultBean();
    AverageMarkBean averageMarkBean = new AverageMarkBean();

    public StudentServiceImpl(){
         studentMap = new HashMap<>();
    }

    /**
     * 添加学生
     * @param student
     * @return bean.ResultBean
     */
    @Override
    public ResultBean addStudent(StudentBean student) {
        if(studentMap.containsKey(student.getName())){
            result.setStatus(502);
            return result;//已添加过这个学生
        }

        studentMap.put(student.getName(), student);

        result.setStatus(200);
        return result;
    }

    /**
     * 通过姓名获取分数
     * @param name
     * @return bean.StudentResultBean
     */
    @Override
    public StudentResultBean getMarkByName(String name) {
        if(studentMap.size() == 0) {
            studentResultBean.setStatus(500);//还没有添加学生
            return studentResultBean;
        }

        if(studentMap.containsKey(name)){
            studentResultBean.setStatus(200);
            studentResultBean.setStudentBean(studentMap.get(name));
        } else
            studentResultBean.setStatus(501);//没有这个学生
        return studentResultBean;

    }

    /**
     * 查看全体
     * @return bean.AllResultBean
     */
    @Override
    public AllResultBean showAll() {
        if(studentMap.size() == 0){
            allResultBean.setStatus(500);//还没有添加学生
            return allResultBean;
        }

        ArrayList<StudentBean> allStu = new ArrayList<>(studentMap.values());

        allResultBean.setStatus(200);
        allResultBean.setStudentBeans(allStu);

        return allResultBean;
    }

    /**
     * 通过排名查找姓名
     * @param rank
     * @return bean.StudentResultBean
     */
    @Override
    public StudentResultBean getNameByRank(String rank) {
        if(studentMap.size() == 0){
            studentResultBean.setStatus(500);//还没有添加学生
            return studentResultBean;
        }
        ArrayList<StudentBean> stu = new ArrayList<>(studentMap.values());

        if(stu.size() >= 2 ) {
            for (int i = 0; i < stu.size() - 1; i++) {
                for (int j = 0; j < stu.size() - i - 1; j++) {
                    if (stu.get(j).getMark() < stu.get(j + 1).getMark()) {
                        StudentBean temp = stu.get(j);
                        stu.set(j, stu.get(j + 1));
                        stu.set(j + 1, temp);
                    }
                }
            }
        }

        HashMap<Integer, StudentBean> temp = new HashMap<>();
        for(int i = 0; i < stu.size(); i++){
            temp.put(i, stu.get(i));
        }

        int rank2 = Integer.parseInt(rank);
        if(temp.containsKey(rank2)){
            studentResultBean.setStatus(200);
            studentResultBean.setStudentBean(temp.get(rank2));
        } else
            studentResultBean.setStatus(501);//没有这个学生
        return studentResultBean;
    }

    /**
     * 查看男生的排名
     * @return bean.AllResultBean
     */
    @Override
    public AllResultBean showRanksInBoy() {
        if(studentMap.size() == 0){
            allResultBean.setStatus(500);//还没有添加学生
            return allResultBean;
        }
        ArrayList<StudentBean> stuBoys = new ArrayList<>();
        for (StudentBean s : studentMap.values()) {
            if (s.getSex().equals("男"))
                stuBoys.add(s);
        }

        if(stuBoys.size() >= 2 ) {
            for (int i = 0; i < stuBoys.size() - 1; i++) {
                for (int j = 0; j < stuBoys.size() - i - 1; j++) {
                    if (stuBoys.get(j).getMark() < stuBoys.get(j + 1).getMark()) {
                        StudentBean temp = stuBoys.get(j);
                        stuBoys.set(j, stuBoys.get(j + 1));
                        stuBoys.set(j + 1, temp);
                    }
                }
            }
        }

        if(stuBoys.size() != 0){
            allResultBean.setStatus(200);
            allResultBean.setStudentBeans(stuBoys);
        } else
            allResultBean.setStatus(501);//没有男生
        return allResultBean;
    }


    /**
     * 查看平均分
     * @return bean.AverageMarkBean
     */
    @Override
    public AverageMarkBean getAverageMark() {
        if(studentMap.size() == 0){
            averageMarkBean.setStatus(500);//还没有添加学生
            return averageMarkBean;
        }

        double averageMark;
        int sum = 0, cnt = 0;

        for (StudentBean s : studentMap.values()) {
            sum += s.getMark();
            cnt++;
        }

        averageMark = sum * 1.0 / studentMap.size();
        averageMarkBean.setStatus(200);
        averageMarkBean.setAverageMark(averageMark);
        averageMarkBean.setCount(cnt);

        return averageMarkBean;
    }

    /**
     * 更新学生信息
     * @param name
     * @param age
     * @param sex
     * @param mark
     * @return bean.StudentResultBean
     */
    @Override
    public StudentResultBean updateStudent(String name, String age, String sex, int mark) {
        if(studentMap.size() == 0){
            studentResultBean.setStatus(500);//还没有添加学生
            return studentResultBean;
        }
        if(studentMap.containsKey(name)){
            StudentBean s = studentMap.get(name);
            s.setAge(age);
            s.setSex(sex);
            s.setMark(mark);
            studentResultBean.setStatus(200);
            studentResultBean.setStudentBean(s);
        } else
            studentResultBean.setStatus(501);//没有这个学生
        return studentResultBean;
    }

    /**
     * 删除学生
     * @param name
     * @return bean.ResultBean
     */
    @Override
    public ResultBean deleteStudent(String name) {
        if(studentMap.size() == 0){
            result.setStatus(500);//还没有添加学生
            return result;
        }

        if(studentMap.containsKey(name)) {
            studentMap.remove(name);
            result.setStatus(200);
        } else
            result.setStatus(501);//没有这个学生
        return result;
    }

}
