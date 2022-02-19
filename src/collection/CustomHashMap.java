package collection;

import java.util.HashMap;

public class CustomHashMap {

	public int hashCode(Object key) {
		int h;
		return key==null?0:(h=key.hashCode())^ (h>>>16);//use XOR bit wise instead of modulous
	}
	public void method1() {}
	
	public static void main(String[] args) {
	}
}