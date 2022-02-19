package collection;
import java.util.*;
public class UnmodifiedList {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		//list.add(2);
		
		List<Integer> ll=Collections.unmodifiableList(list);
		
		for(Integer v: ll) {
			list.remove(v);
		}
		System.out.println(list);
		System.out.println(ll);
	}

}
