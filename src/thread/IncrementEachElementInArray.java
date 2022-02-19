package thread;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class IncrementEachElementInArray extends RecursiveAction {

	private int[] array;
	private int low;
	private int high;
	private static final int THRESHHOLD=100;
	public   IncrementEachElementInArray(int[] array,int low, int high) {
		this.array=array;
		this.low=low;
		this.high=high;
	}
	@Override
	protected void compute() {
		if(high-low<THRESHHOLD) {
			for(int i=low;i<high;i++) {
				array[i]++;
			}
		}else {
			int mid=low+(high-low)/2;
			IncrementEachElementInArray left=new IncrementEachElementInArray(array, low, mid);
			left.fork();
			IncrementEachElementInArray right=new IncrementEachElementInArray(array, mid, high);
			right.compute();
		}
	}
	public static void main(String[] args) {
		int[] array= {1,2,3,4,5,6,7,8,9};
		IncrementEachElementInArray task=new IncrementEachElementInArray(array, 0, 9);
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(task);
		System.out.println(Arrays.toString(array));
		
	}
}
