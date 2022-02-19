package string;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindAndRemoveDuplicates {

	public static void findDuplicates(String str) {
		int[] freq = new int[256];
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i++) {
			freq[array[i]]++;
		}
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 1) {
				System.out.println((char) i);
			}
		}
	}

	public static void removeDuplicates(String str) {
		char[] array = str.toCharArray();
		boolean[] test = new boolean[256];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (!test[array[i]]) {
				array[k++] = array[i];
				test[array[i]] = true;
			}
		}
		System.out.println(new String(array, 0, k));
	}

	public static void main(String[] args) {
		findDuplicates("welcome");
		removeDuplicates("surjeetssss");
		String str = "surrrrrs";
		str.chars().mapToObj(ch1 -> (char) ch1).distinct().forEach((ch) -> {
			System.out.print(ch);
		});
		String str2="kapaasa";
		String ss = str2.chars().mapToObj((ch -> (char) ch)).distinct().collect(Collector.of(StringBuilder::new,
				StringBuilder::append, StringBuilder::append, StringBuilder::toString));
		System.out.println(ss);
	}

}
