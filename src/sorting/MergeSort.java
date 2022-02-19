package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			int[] left = new int[array.length / 2];
			int[] right = new int[array.length - array.length / 2];
			System.arraycopy(array, 0, left, 0, array.length / 2);
			System.arraycopy(array, array.length / 2, right, 0, array.length - array.length / 2);
			mergeSort(left, 0, mid);
			mergeSort(right, mid + 1, end);

			int[] tmp = merge(left, right);
		}
	}

	public static int[] merge(int[] array1, int[] array2) {
		int current1 = 0;
		int current2 = 0;
		int current = 0;
		int[] tmp = new int[array1.length + array2.length];
		while (current1 < array1.length && current2 < array2.length) {
			if (array1[current1] < array2[current2]) {
				tmp[current++] = array1[current1++];
			} else {
				tmp[current++] = array2[current2++];
			}
		}
		while (current1 < array1.length) {
			tmp[current++] = array1[current1++];
		}
		while (current2 < array2.length) {
			tmp[current++] = array2[current2++];
		}
		return tmp;
	}

	public static void main(String[] args) {
		int[] array = { 2, 1, 3, 6, 5, 4, 4, 9, 8 };
		mergeSort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}

}
