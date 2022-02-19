package string;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequency {
	
	public static void findFrequency(String str) {
		int[] freq=new int[256];
		char[] array=str.toCharArray();
		for(int i=0;i<array.length;i++) {
			freq[array[i]]++;
		}
		for(int i=0;i<freq.length;i++) {
			if(freq[i]!=0) {
				System.out.println((char)i + ":"+ freq[i] );
			}
		}
	}
	public static void main(String[] args) {
		findFrequency("peek");
		String str="hello";
		System.out.println("==============");
		Map<Character,Long> map=str.chars().mapToObj( x-> (char)x).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		map.forEach((key,value)->{
			System.out.println(key+ ":"+ value);
		} );
		System.out.println("Find Duplicates");
		
		map.entrySet().stream().filter(entry->entry.getValue()>1).forEach((entry)->{
			System.out.println(entry.getKey() + ":"+ entry.getValue());
		});
		map.forEach((key,value)->{System.out.println(key);});
		
		
		
	}
}