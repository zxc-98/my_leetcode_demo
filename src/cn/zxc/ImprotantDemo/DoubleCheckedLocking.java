package cn.zxc.ImprotantDemo;

public class DoubleCheckedLocking {
    private volatile DoubleCheckedLocking instance;

    public DoubleCheckedLocking getInstance(){
        if(instance == null) {
            synchronized(this) {
                if(instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }

        return instance;
    }
}
