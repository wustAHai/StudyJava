package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenz at 14:48 on 2021/3/26
 */
public class MyThread01 {
    public static void main(String[] args) {
        Test1 test = new Test1();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <10; j++) {
                        System.out.println(Thread.currentThread().getName()+"---->"+test.getNumPP());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                        }
                    }
                }
            }).start();
        }
    }
}
class Test{
    private int num;
    public int getNumPP(){
        return num++;
    }
}

//线程安全类
class Test1{
    private AtomicInteger num = new AtomicInteger();
    public int getNumPP(){
        return num.getAndIncrement();
    }
}