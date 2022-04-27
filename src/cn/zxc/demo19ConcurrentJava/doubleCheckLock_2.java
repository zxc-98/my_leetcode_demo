package cn.zxc.demo19ConcurrentJava;

// 初始化类的解决方案
public class doubleCheckLock_2 {

    private static class InstanceHolder {
        public static doubleCheckLock_2 instance = new doubleCheckLock_2();
    }

    public static doubleCheckLock_2 getInstance() {
        return InstanceHolder.instance;//调用类的静态方法，会导致类进行初始化，初始化过程中，jvm会加锁，只让一个线程进行初始化操作
    }
}
