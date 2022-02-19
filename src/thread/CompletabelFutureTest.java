package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletabelFutureTest {
	private static Order order;
	static {
		order=new Order("10565111", 5, "LAPTOP", 1235.00);
	}
	public static Order getOrders() {
		return order;
	}
	public static Order fetchOrder() {
		System.out.println("Fetching Order");
		return order;
	}
	public static Order enrichOrder(Order order) {
		System.out.println("Enriching Order");
		order.setQuantity(7);
		order.setCost(5555.65);
		return order;
	}
	public static Order getPayment(Order order) {
		try {
			System.out.println(Thread.currentThread().getName());
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println("Compl");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Payment done!");
		return order;
	}
	public static Order dispatchOrder(Order order) {
		System.out.println("Order dispatched for this order Id"+ order.getOrderId());
		return order;
	}
	public  static void sendEmailNotification(Order order) {
		System.out.println("Haaaaaaaaaaaaaaaaaaaaa");
		System.out.println("Email send Notification for this order id"+ order.getOrderId());
	}
	public static int throwException() {
		int a=20/0;
		return a;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(Thread.currentThread().getName());
		/*
		 * Order order=getOrders(); ExecutorService
		 * exec=Executors.newFixedThreadPool(10); Future<Order>
		 * fut1=exec.submit(()->fetchOrder()); Order fetchOrder=fut1.get();
		 * Future<Order> fut2=exec.submit(()->enrichOrder(fetchOrder)); Order
		 * enrichOrder=fut2.get(); Future<Order>
		 * fut3=exec.submit(()->getPayment(enrichOrder)); Order
		 * payymentOrder=fut3.get(); Future<Order>
		 * fut4=exec.submit(()->dispatchOrder(payymentOrder)); Order
		 * dispatchOrder=fut4.get();
		 * exec.submit(()->sendEmailNotification(dispatchOrder));
		 * System.out.println("Completed");
		 */
		CompletabelFutureTest o=new CompletabelFutureTest();
		ExecutorService exec=Executors.newFixedThreadPool(10);
		CompletableFuture.supplyAsync(()->fetchOrder(),exec)
						  .thenApplyAsync((o1)->enrichOrder(o1),exec)
						  .thenApplyAsync((o2)->getPayment(o2),exec)
						  .thenApplyAsync((o3)->dispatchOrder(o3),exec)
						  .thenAccept((o4)->sendEmailNotification(o4));
		//Exceptional Handling Test
		int age=-1;
		CompletableFuture<String> comp=CompletableFuture.supplyAsync(()->{
			if(age<0)
				throw new IllegalArgumentException("Illegal Argument");
			if(age>18)
				return "Adult";
			else
				return "Child";
		}).exceptionally(exec1->{
			System.out.println("Error:"+ exec1.getMessage());
			return exec1.getMessage();
		});
		//Combining two CompletableFutures together
		//use thenCompose and thenCombine 
		
		CompletableFuture<Integer> height=CompletableFuture.supplyAsync(()->{
			return 101;
		});
		CompletableFuture<Integer> width=CompletableFuture.supplyAsync(()->{
			return 201;
		});
	CompletableFuture<Integer>	comp2=height.thenCombine(width, (x,y)->{
			return x+y;
		});
	System.out.println("Combine:"+ comp2.get());
	
		
		try {
			System.out.println(Thread.currentThread().getName());
			//TimeUnit.MILLISECONDS.sleep(50);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Completed!");
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+ ": "+i);
		}
	}

}
