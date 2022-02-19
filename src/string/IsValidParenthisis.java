package string;

import java.util.Stack;

public class IsValidParenthisis {

	public static boolean isValidParenthisis(String str) {
		char[] array=str.toCharArray();
		Stack<Character> stack=new Stack<Character>();
		for(char c: array) {
			if(c=='{' || c=='(' || c=='[')
				stack.add(c);
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		String str="{[()]}";
		System.out.println(isValidParenthisis(str));
	}

}
