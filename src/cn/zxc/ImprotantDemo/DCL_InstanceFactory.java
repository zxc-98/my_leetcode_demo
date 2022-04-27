package cn.zxc.ImprotantDemo;

public class DCL_InstanceFactory {

    private static class instanceHolder{
        //当多个线程进行初始化时，jvm可以同步多个线程堆类的初始化
        public static DCL_InstanceFactory instance = new DCL_InstanceFactory();
    }

    public DCL_InstanceFactory getInstance(){
        return instanceHolder.instance;//导致类的初始化instanceHolder被加载
    }
}
