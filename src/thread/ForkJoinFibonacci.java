package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class CalculateRecursive extends RecursiveTask<Integer>{
	
	private int n;
	public CalculateRecursive(int n) {
		this.n=n;
	}
	
	@Override
	protected Integer compute() {
		if(n==0 || n==1)
			return n;
		CalculateRecursive left=new CalculateRecursive(n-1);
		left.fork();
		CalculateRecursive right=new CalculateRecursive(n-2);
		int res=right.compute()+left.join();
		return res;
	}
}
public class ForkJoinFibonacci {

	public static void main(String[] args) throws Exception{
		CalculateRecursive task=new CalculateRecursive(10);
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(task);
		System.out.println(task.get());
	}

}
