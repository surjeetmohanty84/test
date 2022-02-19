package linkedlist;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Node {

	protected int data;
	protected Node nxt;
	public Node(int data) {
		this.data=data;
		this.nxt=null;
	}
}
