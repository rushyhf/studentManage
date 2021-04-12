package bean;

import java.util.ArrayList;

public class AllResultBean extends ResultBean{
    ArrayList<StudentBean> studentBeans;

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status);
    }

    public ArrayList<StudentBean> getStudentBeans() {
        return studentBeans;
    }

    public void setStudentBeans(ArrayList<StudentBean> studentBeans) {
        this.studentBeans = studentBeans;
    }
}
