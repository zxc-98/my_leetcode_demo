package cn.zxc.demoTest.doubleCheckLock;

public class UnsafeLazyInitialization {

    private UnsafeLazyInitialization instance;

    public UnsafeLazyInitialization getInstance() {
        if(instance == null) {
            instance = new UnsafeLazyInitialization();//出现先赋值 还没进行初始化
        }
        return instance;
    }
}
