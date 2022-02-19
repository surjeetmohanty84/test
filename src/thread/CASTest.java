package thread;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

import lombok.Data;
@Data
class Product{
	private int quantity;
	private int cost;
	public Product(int quantit,int cost) {
		this.quantity=quantity;
		this.cost=cost;
	}
}
public class CASTest {

	private AtomicReference<Product> productRef=new AtomicReference<Product>(new Product(10,2000));
	public int getQuantityy() {
		return productRef.get().getQuantity();
	}
	public int getCost() {
		return productRef.get().getCost();
	}
	public void update(int quantity,int cost) {
		//Product oldValue=productRef.get();
		//Product newValue=new Product(getQuantityy(), getCost()+cost);
		//if(productRef.compareAndSet(oldValue, newValue)) {
		//	return;
		//}
		productRef.updateAndGet(x-> new Product(quantity+productRef.get().getQuantity(),cost+productRef.get().getCost()));
	}
	public static void main(String[] args) {
		//There is a object state which is represented by two variables. How would
		//you write a high throughput non-blocking algorithm to update the state from multiple
		//threads?
	
		
	}
}
