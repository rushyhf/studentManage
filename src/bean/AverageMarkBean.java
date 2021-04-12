package bean;

public class AverageMarkBean extends ResultBean{
    double averageMark;
    int count;

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status);
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
