package others;
class A1{
	private int value=10;
	public A1() {
		methodA();
		staticMethodA();
	}
	public void methodA() {
		System.out.println("Superclass Method A");
	}
	public static void staticMethodA() {
		System.out.println("Static in Super class Method");
	}
}
class B1 extends A1{
	private int value=20;

	public B1() {
		methodA();
		staticMethodA();
	}
	@Override
	public void methodA() {
		super.methodA();
		//System.out.println(super.value);
		System.out.println("Subclass Method A");
	}
	public static void staticMethodA() {
		System.out.println("Static in Sub class Method");
	}
}
public class OverridingTest {

	public static void main(String[] args) {
	B1 obj=new B1();
	
	}

}
