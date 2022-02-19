package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Test{
	
	public  static synchronized void method1() {
		for(int i=0;i<200;i++) {
			try {
				//Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+":"+ i);
			}catch(Exception e) {}
		}
	}
	public  synchronized void method2() {
		for(int i=20;i<400;i++) {
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}
}
public class MultipleThreadTest {

	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		Test o=new Test();
		Test o2=new Test();
		exec.execute(()->Test.method1());
		exec.execute(()->o.method2());
		
		
	}

}
