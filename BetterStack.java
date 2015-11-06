package algorithms;

public class BetterStack <T> {
	
	private LinkedList<T> LL;
	
	public BetterStack() {
		LL = new LinkedList<T>();
	}
	
	public BetterStack(T t) {
		LL = new LinkedList<T>(t);
	}
	
	public T peek() {
		return LL.head;
	}
	
	public T pop() {
		return LL.removeHead();
	}
	
	public void push(T t) {
		LL.insertBefore(LL.head, t);
	}
	
	public int size() {
		return LL.size();
	}

}
