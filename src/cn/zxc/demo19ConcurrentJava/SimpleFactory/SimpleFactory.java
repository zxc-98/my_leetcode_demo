package cn.zxc.demo19ConcurrentJava.SimpleFactory;

//手写工厂方法
//将实例化的子类单独放在一个类中，让简单工厂方法类来决定具体哪一个子类进行实例化
public class SimpleFactory {
    public Product creatProduct(int type) {
        if (type == 1) {
            return new creatProduct1();
        }
        else if (type == 2) {
            return new creatProduct2();
        }
        else {
            return new creatProduct3();
        }
    }


    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Product product = factory.creatProduct(2);
        System.out.println(product);
    }
}
