package cn.zxc.demo19ConcurrentJava;

public class doubleCheckLock {
    private volatile doubleCheckLock instance = null;

    public doubleCheckLock getInstance() {
        if (instance == null) { //第一次检查如果instance不为null 则不用再加锁和初始化
            synchronized (doubleCheckLock.class) {
                if(instance == null) { // 第二次检查则是检查在第一次初始化的时候，被阻塞的线程获取到锁，这是已经单例对象已经初始化成功，就会被第二次检查挡住
                    instance = new doubleCheckLock();//如果没有volatile关键字，引用对象还没完成初始化 先初始化 再设置instance指向初始化后的内存空间
                }
            }
        }

        return instance;
    }
}
