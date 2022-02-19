package linkedlist;

import java.util.Stack;

public class SingleLinkedListTest {
	private Node head;
	private Node tail;

	public void add(int data) {
		if (head == null && tail == null) {
			head = new Node(data);
			tail = head;
		} else {
			tail.nxt = new Node(data);
			tail = tail.nxt;
		}
	}

	public void reverseNode_Recurssive(Node p) {
		if (p.nxt == null) {
			head = p;
			return;
		}
		reverseNode_Recurssive(p.nxt);

		Node q = p.nxt;
		q.nxt = p;
		p.nxt = null;
	}

	public Node reverseNode_Iterative() {
		Node current = head;
		Node pre = null;
		Node nxt = null;
		while (current != null) {
			nxt = current.nxt;
			current.nxt = pre;
			pre = current;
			current = nxt;
		}
		head = pre;
		return head;
	}
	public Node reverseNode_Iterative(Node n) {
		Node current = n;
		Node pre = null;
		Node nxt = null;
		while (current != null) {
			nxt = current.nxt;
			current.nxt = pre;
			pre = current;
			current = nxt;
		}
		head = pre;
		return head;
	}

	public Node findMiddleNode(Node n) {
		Node slow = n;
		Node fast = n.nxt;
		while (fast != null) {
			fast = fast.nxt;
			if (fast != null) {
				fast = fast.nxt;
				slow = slow.nxt;
			}
		}
		return slow;
	}

	public void deleteMiddleNode() {
		Node slow = head;
		Node fast = head;
		Node pre = null;
		while (fast != null) {
			fast = fast.nxt;
			if (fast != null) {
				pre = slow;
				slow = slow.nxt;
				fast = fast.nxt;
			}
		}
		pre.nxt = slow.nxt;
	}

	public Node mergeSortLinkedList(Node p) {
		if (p.nxt == null)
			return p;
		Node middle = findMiddleNode(p);
		Node next = middle.nxt;
		middle.nxt = null;
		Node left = mergeSortLinkedList(p);
		Node right = mergeSortLinkedList(next);

		Node tmp = merge(left, right);
		return tmp;
	}

	public Node merge(Node a, Node b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		Node tmp = null;
		if (a.data < b.data) {
			tmp = a;
			tmp.nxt = merge(a.nxt, b);
		} else {
			tmp = b;
			tmp.nxt = merge(a, b.nxt);
		}
		head = tmp;
		return tmp;
	}

	public void removeDuplicatefromSorted() {
		Node current = head;

	}

	public void findNthNodeFromEnd(int pos) {
		Node current = head;
		Node slow = head;
		while (pos-- > 0)
			current = current.nxt;
		while (current != null) {
			slow = slow.nxt;
			current = current.nxt;
		}
		System.out.println("NthNode From ENd:" + slow.data);
	}

	public boolean isPallindrome() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean test = true;
		Node current = head;
		Node tmp = head;
		while (tmp != null) {
			stack.push(tmp.data);
			tmp = tmp.nxt;
		}
		while (!stack.isEmpty()) {
			Integer val = stack.pop();
			if (current.data == val)
				test = true;
			else {
				test = false;
				break;
			}
		}
		return test;
	}

	public int getLength(Node a) {
		if (a.nxt == null)
			return 1;
		return getLength(a.nxt) + 1;
	}

	public Node findMergePointOfTwoLinkedList(Node a, Node b) {
		int len1 = getLength(a);
		int len2 = getLength(b);
		int diff;
		if (len1 > len2) {
			diff = len1 - len2;
		} else {
			diff = len2 - len1;
			Node tmp = a;
			a = b;
			b = tmp;
		}
		while (diff-- > 0) {
			a = a.nxt;
		}
		while (a != null) {
			if (a == b)
				return a;
			a = a.nxt;
			b = b.nxt;
		}
		return new Node();
	}

	public void addTwoLinkedList(Node a, Node b) {
		/*
		 * Input: First List: 5->6->3 Second List: 8->4->2 Output Resultant list:
		 * 1->4->0->5
		 */
		Stack<Integer> stk1=new Stack<Integer>();
		Stack<Integer> stk2=new Stack<Integer>();
		while(a!=null) {
			stk1.push(a.data);
			a=a.nxt;
		}
		while(b!=null) {
			stk2.push(b.data);
			b=b.nxt;
		}
		Node tmp=null;
		int carry=0;
		while(!stk1.isEmpty() && !stk2.isEmpty()) {
			int sum=stk1.pop()+stk2.pop()+carry;
			tmp=new Node(sum%10);
			
			
			
		}
	}

	public void rotateLinkedList() {
	}

	public Node addOneToNode(Node n) {//
		// For example 1999 is represented as (1-> 9-> 9 -> 9) and adding 1 to it should
		// change it to (2->0->0->0)
		
		Node reverseNode=reverseNode_Iterative(n);
		Node tmp=null;
		int carry=1;
		while(reverseNode!=null) {
			int sum=reverseNode.data+carry;
			carry=sum>=10?1:0;
			sum=sum%10;
			tmp=new Node(sum%10);
		}
		/*
		 * Stack<Integer> stack=new Stack<Integer>(); Node current=n;
		 * while(current!=null) { stack.push(current.data); current=current.nxt; } Node
		 * tmp1=null; int carry=1; while(!stack.isEmpty()) { int sum=stack.pop()+carry;
		 * //System.out.println(sum); carry=(sum>=10)?1:0;
		 * 
		 * sum=sum%10; tmp1=new Node(sum); //System.out.println(tmp1.data);
		 * tmp1=tmp1.nxt;
		 * 
		 * } if(carry>0) tmp1.nxt=new Node(carry); return tmp1;
		 */
		return null;
	}

	public void deleteNodeSumEqualEqualToZero() {
		// Delete the elements in an linked list whose sum is equal to zero
	}

	public void mergeTwoLinkedListALternatePosition(Node a, Node b) {
	}

	public void deleteTheGivenNode() {
	}

	public void print() {
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + ",");
			tmp = tmp.nxt;
		}
		System.out.println();
	}

	public void print(Node a) {
		Node tmp = a;
		if(tmp==null)
			System.out.println("NULL");
		while (tmp != null) {
			System.out.print(tmp.data + ",");
			tmp = tmp.nxt;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SingleLinkedListTest ll = new SingleLinkedListTest();
		ll.add(12);
		ll.add(6);
		ll.add(3);
		ll.add(11);
		ll.add(12);
		ll.add(19);
		ll.add(15);
		ll.add(12);
		ll.add(12);
		ll.print();
		ll.reverseNode_Recurssive(ll.head);
		System.out.println("Reverse Recursively");
		ll.print();
		System.out.println("Reverse Iterative");
		ll.reverseNode_Iterative();
		ll.print();
		System.out.println("Find Middle Node");
		System.out.println(ll.findMiddleNode(ll.head).data);
		System.out.println("Deleting Middle Node");
		ll.deleteMiddleNode();
		ll.print();
		System.out.println("Merge Sorting");
		Node x = ll.mergeSortLinkedList(ll.head);
		ll.print(x);

		ll.removeDuplicatefromSorted();

		ll.print();
		ll.findNthNodeFromEnd(7);
		System.out.println("ISPallindrome():" + ll.isPallindrome());
		System.out.println("Length: " + ll.getLength(ll.head));
		Node pool = new Node(60);
		Node a = new Node(10);
		a.nxt = new Node(20);
		a.nxt.nxt = new Node(30);
		a.nxt.nxt.nxt = pool;
		a.nxt.nxt.nxt.nxt = new Node(40);
		a.nxt.nxt.nxt.nxt.nxt = new Node(50);

		Node b = new Node(70);
		b.nxt = new Node(80);
		b.nxt.nxt = new Node(90);
		b.nxt.nxt.nxt = pool;
		b.nxt.nxt.nxt.nxt = new Node(100);
		Node z = ll.findMergePointOfTwoLinkedList(a, b);
		System.out.println("Finding Merge Point:" + z.data);

	}

}
