/*
   描述：  消失的请求数
   计算结果不符合预期
 */

public class DisappearRequest1 implements  Runnable{
    static DisappearRequest1 instance=new DisappearRequest1();
    static int i=0;

    public  static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        //利用join方法使线程进入等待状态，知道t1执行完毕，再执行打印输出的代买
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public  void run() {
        synchronized (DisappearRequest1.class) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
    }
}
