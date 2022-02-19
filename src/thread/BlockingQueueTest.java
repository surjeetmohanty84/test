package thread;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProducerFindAllCustomerFiles implements Runnable {
	private BlockingQueue<File> queue;
	private File file;

	public ProducerFindAllCustomerFiles(BlockingQueue<File> queue, String fileName) {
		this.queue = queue;
		this.file = new File(fileName);
	}

	@Override
	public void run() {
		try {
			enumerateFile(file);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enumerateFile(File directory) throws InterruptedException {
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				enumerateFile(file);
				queue.put(new File(""));
			} else {
				System.out.println(file);
				queue.put(file);
			}
		}
	}
}

class ConsumerSearchFile implements Runnable {
	private BlockingQueue<File> queue;

	public ConsumerSearchFile(BlockingQueue<File> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		File file;
		try {
			while (true) {
				file = queue.take();
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String line = scanner.next();
					System.out.println(line);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class BlockingQueueTest {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		BlockingQueue<File> queue = new ArrayBlockingQueue<File>(20);
		exec.execute(new ProducerFindAllCustomerFiles(queue, "E:\\dir"));
		exec.execute(new ConsumerSearchFile(queue));
	}

}
