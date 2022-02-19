package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lombok.ToString;
class Address{
	private String city;
	
}
@ToString
final class Customer{
	
	private final int custId;
	private final String name;
	private final int[] array;
	private final Date date;
	private final List<Integer> list;
	public Customer(int custId,String name,int[] array,Date date,List<Integer> list) {
		this.custId=custId;
		this.name=name;
		this.array=array.clone();
		this.date=new Date(date.getTime());
		this.list=Collections.unmodifiableList(list);
	}
	public int[] getArray() {
		return (int[])array.clone();//defensive copy using clone method;
	}
	public Date getDate() {
		return new Date(this.date.getTime());
		//return date;
	}
	public void tryModification(int custId,String name,int[] array,Date date,List<Integer> list) {
		custId=100000;
		name="japo";
		array[1]=200;
		date.setDate(29);
		list.remove(0);
	}
}
public class ImmutableClass {

	public static void main(String[] args) {
		int[] array= {1,2,3,4,5}; List<Integer> list=new ArrayList();list.add(1);list.add(2);list.add(3);
		List<Integer> ll=Collections.unmodifiableList(list);
		Customer cust=new Customer(101, "surjeet", array, new Date(2011,11,22),list); 
		System.out.println(cust);
		cust.tryModification(20000, "gochu", array, new Date(2011,11,22),list);
		System.out.println("After Modification");
		System.out.println(cust);
	}

}
