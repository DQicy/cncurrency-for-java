/*
描述：
 在本程序中描述两种等价的上锁方式
 （1）sychronized ---》在进入代码块时会自动上锁，执行完之后会自动释放锁
 （2）ReentrantLock即为实现lcok接口的一把锁---》 通过try   catch
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedToLock13 {
Lock lock=new ReentrantLock();

public  synchronized void method1(){
    System.out.println("我是Sychronized形式的锁");
}

public void method2(){
    lock.lock();
    try{
        System.out.println("我是lock形式的锁");
    }finally {
        lock.unlock();
    }
}

    public static void main(String[] args) {
        SynchronizedToLock13 s=new SynchronizedToLock13();
        s.method1();
        s.method2();
    }
}
