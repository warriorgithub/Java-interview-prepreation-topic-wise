package threads;

import java.util.concurrent.atomic.AtomicInteger;

//Volatile : if you have visibility problems. Mainly use to set a flag
// Atomic : if you have syncronization problem, like compound operations i++.
public class Atomic_Volatile {
    boolean flag=true;
    private  void _volatile(){
        Thread t1 = new Thread(() -> {
            flag=false;
            if(!flag) System.out.println(flag);
        });

        Thread t2 = new Thread(()->{
            while(flag){
                System.out.println(flag);
            }
        });
        t2.start();
        t1.start();

    }
    int j=0;
    /*private void _atomic(){
        AtomicInteger i = new AtomicInteger(0);
        Thread t1 = new Thread(()->{
          // i.addAndGet(1);
           j++;
            System.out.println(j);
        });
        Thread t2 = new Thread(()->{
           // i.addAndGet(2);
            j=j+2;
            System.out.println(j);
        });
        t1.start();
        t2.start();
    }*/

    void _atomic(){
        Runnable task1 = ()->{
            j++;
            System.out.println(j);
        };

        Runnable task2 = ()->{
            j=j+2;
            System.out.println(j);
        };
        Thread t1 = new Thread(task1);
        t1.start();
        Thread t2 = new Thread(task2);
        t2.start();
    }
    public static void  main(String args[]) {
    Atomic_Volatile a = new Atomic_Volatile();
    //a._atomic();
    a._volatile();
    }
}
