package cn.zxc.demoTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {

    public static void main(String[] args) {
        Printer p = new Printer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.A();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static class Printer {
        private int flag = 1;
        ReentrantLock lock = new ReentrantLock();

        public void A() throws InterruptedException {
            lock.lock();
            if (flag != 1) {
                wait();
            }
            System.out.println("A");
            flag = 2;
            lock.unlock();
        }

        public void B() throws InterruptedException {
            lock.lock();
            if (flag != 2) {
                wait();
            }
            System.out.println("A");
            flag = 3;
            lock.unlock();
        }

        public void C() throws InterruptedException {
            lock.lock();
            if (flag != 3) {
                wait();
            }
            System.out.println("A");
            flag = 1;
            lock.unlock();
        }
    }
}
