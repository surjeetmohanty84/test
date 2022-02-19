package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

class CustomThreadPool{
	private BlockingQueue<Runnable> queue;
	private Thread[] workerThreads;
	public CustomThreadPool(int numThreads) {
		workerThreads=new Thread[numThreads];
		queue=new LinkedBlockingQueue<Runnable>();
		int i=0;
		for(Thread t : workerThreads) {
			t=new WorkerThread("ThreadName:"+ ++i);
			t.start();
		}
	}
	public void addTask(Runnable task) {
		queue.add(task);
	}
	class WorkerThread extends Thread{
		public WorkerThread(String name) {
			super(name);
		}
		@Override
		public void run() {
			while(true) {
				try {
					queue.take().run();
				}catch(Exception e) {
					System.out.println("Error");
					e.printStackTrace();
				}
			}
		}
	}
}

public class CustomThreadPoolTest {

	public static void main(String[] args) {
		CustomThreadPool pool=new CustomThreadPool(10);
		pool.addTask(()->System.out.println("First Print Task:"));
		pool.addTask(()->System.out.println("Second Print Task:"));
		pool.addTask(()->System.out.println("Third Print Task:"));
		
	}

}
