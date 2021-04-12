package bean;

public class StudentBean {
    private String name;
    private String schoolNum;
    private String age;
    private String sex;

    private int mark;

    @Override
    public String toString() {
        return "StudentBean{" +
                "name='" + name + '\'' +
                ", schoolNum='" + schoolNum + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", mark=" + mark +
                '}';
    }

    public StudentBean(String name, String schoolNum, String age, String sex, int mark){
        this.name = name;
        this.schoolNum = schoolNum;
        this.age = age;
        this.sex = sex;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolNum() {
        return schoolNum;
    }

    public void setSchoolNum(String schoolNum) {
        this.schoolNum = schoolNum;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

}
