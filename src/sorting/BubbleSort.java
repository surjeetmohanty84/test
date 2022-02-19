package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			boolean flag=false;
			for(int j=0;j<array.length-1-i;j++) {
				System.out.println("Check");
				if(array[j]>array[j+1]) {
					int tmp=array[j];
					array[j]=array[j+1];
					array[j+1]=tmp;
					flag=true;
				}
			}
			if(flag==false)
				break;
		}
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {
		int[] array= {2,2,1,1,5,7,5,9,8};
		int[] sort= {1,2,3,3,5,6};
		bubbleSort(array);
	}

}
