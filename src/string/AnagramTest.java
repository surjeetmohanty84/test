package string;

import java.util.Arrays;

public class AnagramTest {

	public static boolean isAnagram(String str1, String str2) {
		char[] array1=str1.replaceAll("\\s", "").toCharArray();
		char[] array2=str2.replaceAll("\\s", "") .toCharArray();
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		
		if(array1.length!=array2.length)
			return false;
		int[] freq1=new int[256];
		int[] freq2=new int[256];
		for(int i=0;i<array1.length;i++) {
			freq1[Character.toLowerCase(array1[i])]++;
			freq2[Character.toLowerCase(array2[i])]++;
		}
		for(int i=0;i<freq1.length;i++) {
			if(freq1[i]!=freq2[i])
				return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isAnagram("Mother In Law", "Hitler Woman"));
	}

}
