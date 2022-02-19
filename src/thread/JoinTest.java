package thread;
class Thread1 extends Thread{
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+ ":"+ i);
		}
	}
}
class Thread2 extends Thread{
	private Thread1 thread1;
	public Thread2(Thread1 thread1) {
		this.thread1=thread1;
	}
	@Override
	public void run() {
		try {
			thread1.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+ ":"+ i);
		}
	}
}
class Thread3 extends Thread{
	private Thread2 thread2;
	public Thread3(Thread2 thread2) {
		this.thread2=thread2;
	}
	@Override
	public void run() {
		try {
			thread2.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+ ":"+ i);
		}
	}
}
public class JoinTest {

	public static void main(String[] args) {
		Thread1 thread1=new Thread1();thread1.setName("Thread-01");
		Thread2 thread2=new Thread2(thread1);thread2.setName("Thread-02");
		Thread3 thread3=new Thread3(thread2);thread3.setName("Thread-03");
		try {
			thread1.start();
			thread2.start();
			thread3.start();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
