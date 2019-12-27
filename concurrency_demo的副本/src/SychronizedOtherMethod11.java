/*
描述：可重入粒度测试：调用类内另外的方法
 */
public class SychronizedOtherMethod11 {
    public  synchronized void method1(){
       System.out.println("我是method1");
       methed2();
    }
    public  synchronized  void  methed2(){
        System.out.println("我是method2");
    }
    public static void main(String[] args){
        SychronizedOtherMethod11 s=new SychronizedOtherMethod11();
        s.method1();

    }

}
