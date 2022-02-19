package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Producer{
	
	private int i=1;
	private BlockingQueue<Integer> queue;
	public Producer(BlockingQueue<Integer> queue) {
		this.queue=queue;
	}
	public void produce() {
		while(i!=20) {
			try {
				queue.put(i);
				System.out.println("Producer:"+ i);
				i++;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class Consumer{
	
	private BlockingQueue<Integer> queue;
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue=queue;
	}
	public void consumer() {
		while(true) {
			try {
				int val=queue.take();
				System.out.println("Consumer:"+ val);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
public class ProducerConsumerTest {
	public static void main(String[] args) {
	    BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(20);
		Producer p=new Producer(queue);
		Consumer c=new Consumer(queue);
		ExecutorService exec=Executors.newFixedThreadPool(4);
			exec.execute(()->p.produce());
			exec.execute(()->c.consumer());
	}
}
