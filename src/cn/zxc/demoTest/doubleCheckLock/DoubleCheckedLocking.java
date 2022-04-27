package cn.zxc.demoTest.doubleCheckLock;

public class DoubleCheckedLocking {
    private volatile DoubleCheckedLocking instance;//禁止指令重排

    public DoubleCheckedLocking getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if(instance == null) {
                    instance = new DoubleCheckedLocking();//指令重排序现象 出现先赋值 还没进行初始化
                }
            }
        }

        return instance;
    }
}
