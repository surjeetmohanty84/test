package string;

public class CapitalizeEachWord {
	public static void capitalizeFirstLetter(String str) {
		char[] array=str.toCharArray();
		boolean test=true;
		int k=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]!=' ' && test) {
				array[k++]=Character.toUpperCase(array[i]);
				test=false;
			}else if(array[i]==' ') {
				array[k++]=array[i];
				test=true;
			}
			else {
				array[k++]=array[i];
			}
		}
		System.out.println(new String(array));
	}
	
	public static void main(String[] args) {
		capitalizeFirstLetter("this is javapoint");
		//String str="this is javapoint";
//		str.chars().mapToObj(x->(char)x ).
		String str1="hello welcome to the world";
		StringBuilder sb=new StringBuilder();
		String[] array=str1.split(" ");
		for(String s: array) {
			sb.append(Character.toUpperCase(s.charAt(0)));
			sb.append(s.substring(1));
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
