package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolSumOfAllElements extends RecursiveTask<Integer>{

	private int low;
	private int high;
	private int[] array;
	private static final int THREASHOLD=2;
	public ForkJoinPoolSumOfAllElements(int[] array,int low,int high) {
		this.low=low;
		this.high=high;
		this.array=array;
	}
	@Override
	protected Integer compute() {
		if(high-low<THREASHOLD) {
			int result=0;
			for(int i=low;i<high;i++) {
				result=result+array[i];
			}
			return result;
		}else {
			//int mid=(low+high)>>>1;
			System.out.println("Forking");
			int mid=low+(high-low)/2;
			ForkJoinPoolSumOfAllElements left=new ForkJoinPoolSumOfAllElements(array, low, mid);
			left.fork();
			ForkJoinPoolSumOfAllElements right=new ForkJoinPoolSumOfAllElements(array, mid, high);
			int result=right.compute()+left.join();
			return result;
		}
		//return null;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] array= {1,2,3,4,5,6,7,8,9};
		ForkJoinPoolSumOfAllElements obj=new ForkJoinPoolSumOfAllElements(array, 0, 9);
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(obj);
		
		System.out.println(obj.get());
	}

}
