package cn.zxc.demo19ConcurrentJava.FactoryMethod;

//定义一个Factory抽象类
public abstract class Factory {
    abstract public Product factoryMethod();

}

// 定义了一个创建对象的接口，但由子类决定要实例化哪个类。
class ConcreteFactory extends Factory {

    @Override
    public Product factoryMethod() {
        return new creatProduct1();
    }
}

class ConcreteFactory2 extends Factory {

    @Override
    public Product factoryMethod() {
        return new creatProduct2();
    }
}

