package string;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindHighestOccuranceCharacter {

	public static void main(String[] args) {
		String str="hellooo";
		Map<Character,Long> map=str.chars().mapToObj(x-> (char)x).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		char c=map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).get();
		System.out.println(c);
	}

}
