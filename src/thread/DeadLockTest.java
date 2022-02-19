package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockTest {

	Object o1=new Object();
	Object o2=new Object();
	
	public  void m1() {
		synchronized (o1) {
			System.out.println("Acquring Lock Object o1");
			synchronized (o2) {
				System.out.println("Acquring Object o2");
			}
			System.out.println("Finished:"+ Thread.currentThread().getName());
		}
	}
	public  void m2() {
		synchronized (o2) {
			System.out.println("Acquring Lock Object o2");
			synchronized (o1) {
				System.out.println("Acquring Object o1");
			}
			System.out.println("Finished:"+ Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		DeadLockTest o=new DeadLockTest();
		ExecutorService exec=Executors.newFixedThreadPool(2);
		exec.execute(()->o.m1());
		exec.execute(()->o.m2());

		ThreadMXBean bean= ManagementFactory.getThreadMXBean();
		long[] threadIds=bean.findDeadlockedThreads();
		boolean test=threadIds!=null && threadIds.length>0;
		System.out.println("Dead Lock Found:"+ test);
	}

}
