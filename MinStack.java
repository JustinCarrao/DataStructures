package algorithms;

public class MinStack {
	
	private Stack normalStack; 
	private Stack minimumStack;
	
	public MinStack() {
		normalStack = new Stack();
		minimumStack = new Stack();
	}
	
	public void push(Node n) {
		normalStack.push(n);
		if (minimumStack.top == null) minimumStack.push(n);
		else if (n.data < minimumStack.top.data) {
			minimumStack.push(n);
		}
	}
	
	public Node pop() {
		Node n = normalStack.pop();
		if (n == minimumStack.top) {
			minimumStack.pop();
		}
		return n;
	}
	
	public int findMin() {
		return minimumStack.top.data;
	}
	

}
