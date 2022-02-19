package thread;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveTask;

class CustomerTransaction extends RecursiveTask<File> {

	private int low = 0;
	private int high;
	private static final int THREASHOLD = 3;
	private BlockingQueue<File> queue;
	private File file;

	public CustomerTransaction(BlockingQueue<File> queue, File file) {
		this.queue = queue;
		this.file = file;
	}

	public void enumerate(File file) {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory())
				enumerate(f);
			else {
				try {
					queue.put(f);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected File compute() {
		enumerate(file);
		if (!queue.isEmpty()) {
			try {
				while (true) {
					File f = queue.take();
					System.out.println(f.getAbsolutePath());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

public class ForkJoinCustomerTransaction {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		BlockingQueue<File> queue = new LinkedBlockingQueue<File>();
		File file = new File("E:\\dir");
		CustomerTransaction task = new CustomerTransaction(queue, file);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		//pool.execute(task);
	}

}
