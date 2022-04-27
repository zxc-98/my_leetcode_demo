package cn.zxc.demo19ConcurrentJava;

import java.util.ArrayList;
import java.util.List;

// 按顺序执行线程
public class Foo_1 {
    public static void main(String[] args) throws InterruptedException {
        demo1 demo = new demo1();

        Runnable task1 = () -> System.out.println("first");
        Runnable task2 = () -> System.out.println("second");
        Runnable task3 = () -> System.out.println("third");

        demo.first(task1);
        demo.third(task3);
        demo.second(task2);

    }

    // 等待唤醒机制
    public static class demo1 {
        private volatile  int flag = 1;

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            flag = 2;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (flag != 2);
            printSecond.run();
            flag = 3;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (flag != 3);
            printThird.run();
            flag = 1;
        }
    }

    // 加锁
    public static class demo2 {
        private List<Integer> list;
        public demo2() {
            list = new ArrayList<>();
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized(list){

            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
