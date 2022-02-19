package string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedNonRepeatedCharacter {
	public static void findFirstRepeatedChar(String str) {
		Map<Character, Long> map=str.chars().mapToObj(x-> (char)x ).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		char c=map.entrySet().stream().filter(entry->entry.getValue()==1).map(entry->entry.getKey()).findFirst().get();
		System.out.println(c);
	}
	public static void main(String[] args) {
		findFirstRepeatedChar("heloee");
	}

}
