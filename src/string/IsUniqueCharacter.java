package string;

public class IsUniqueCharacter {

	public static boolean isUnique(String str) {
		boolean[] test=new boolean[256];
		char[] array=str.toCharArray();
		for(int i=0;i<array.length;i++) {
			if(!test[array[i]]) {
				test[array[i]]=true;
			}else {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isUnique("heloh"));
	}

}
