package cn.zxc.demoTest.doubleCheckLock;

public class InstanceFactory {

    private static class InstanceHolder { //私有的静态内部类
        public static InstanceFactory instance = new InstanceFactory();
    }

    //调用静态方法 可以初始化这个类 类加载阶段的初始化阶段 执行类构造器clinic 多线程同时初始化一个类时 只有一个线程会执行clinic方法 其他线程会阻塞
    public InstanceFactory getInstance() {
        return InstanceHolder.instance;//执行类的初始化的时候 会去获取class对象的初始化锁
    }
}
