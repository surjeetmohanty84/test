package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopOnWriteList {

	public static void main(String[] args) {
		List<Integer> list=new CopyOnWriteArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);
		Iterator<Integer> iter=list.iterator();
		list.add(100);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		Map<Integer,String> map=new ConcurrentHashMap<Integer, String>();
		map.putIfAbsent(1, "a");
		map.putIfAbsent(1, "b");
		map.compute(1, (key,value)->value==null?"default": value+"Mohanty");
		System.out.println(map);
	}

}
