package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
class TaskOne implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		throw new Exception();
	}
}
public class BlockingQueueWithWaitAndNotify {

	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder(100);
		ExecutorService exec=Executors.newFixedThreadPool(1);
		Future<String> fut=exec.submit(()->{
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
			return "Hello";
		});
		try {
			String str=fut.get(100, TimeUnit.MICROSECONDS);
			System.out.println(str);
		}catch(Exception e) {
			System.out.println("Exception");
		}finally {
			System.out.println("cancel task");
			fut.cancel(true);
			
		}
	}

}
