package thread;

import java.util.HashMap;
import java.util.Map;

class KeyLessEntry{
	static class Key{
		Integer id;
		Key(Integer id){
			this.id=id;
		}
		@Override
		public int hashCode() {
			return id.hashCode();
		}
	}
	
}
public class KeyClassEntry {

	public static void main(String[] args) {
		Map<KeyLessEntry.Key, String> map=new HashMap<KeyLessEntry.Key, String>();
		while(true) {
			for(int i=0;i<1000;i++) {
				if(map.containsKey(new KeyLessEntry.Key(i)))
					map.put(new KeyLessEntry.Key(i), "Num"+i);
			}
		}
		
	}
}
