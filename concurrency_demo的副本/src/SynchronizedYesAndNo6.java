import javax.swing.plaf.basic.BasicPopupMenuSeparatorUI;

/*
描述：同时访问同步方法和非同步方法
注：同步方法即为被synchronize所修饰的方法
 */
public class SynchronizedYesAndNo6 implements Runnable{
    static  SynchronizedYesAndNo6 instance= new SynchronizedYesAndNo6();

    @Override
    public void run() {
        //利用此种方法让不同的线程访问不同的方法
            if (Thread.currentThread().getName().equals("Thread-0")){
                method1();
            }else{
                method2();
            }
    }

    public  synchronized void method1(){
        System.out.println("我是加锁的方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束。");
    }
    public  void method2(){
        System.out.println("我是没加锁的方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束。");
    }

    public static void main(String[] args) {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }

}

