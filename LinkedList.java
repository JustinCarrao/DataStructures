package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class LinkedList <T> {
	
	private HashMap<T, T> list;
	T head; 
	T tail;
	
	
	
	public LinkedList (T t) {
		list = new HashMap<T, T>();
		list.put(t, null);
		head = t;
		tail = t;
	}
	
	public LinkedList() {
		list = new HashMap<T, T>();
		head = null;
		tail = null;
	}
	
	public boolean hasNext(T t) {
		return (list.get(t) != null);
	}
	
	public void append(T t) {
		if (list.size() == 0) {
			list.put(t, null);
			head = t;
			tail = t;
		}
		else {
			list.put(tail, t);
			tail = t;
		}
	}
	
	public int size() {
		return list.size();
	}
	
	public T removeHead() {
		T temp = head;
		head = list.get(head);
		list.remove(temp);
		return temp;
	}
	
	public void deleteElement(T t) {
		if (t == head) {
			T temp = head;
			head = list.get(head);
			list.remove(temp);
		}
		T current = head;
		while (current != null) {
			T next = list.get(current);
			if (next == t) {
				list.put(current, list.get(next));
			}
			current = list.get(current);
		}
	}
	
	public void insertAfter(T t1, T t2) {
		T current = head;
		while (current != null) {
			if (current == t1) {
				T temp = list.get(t1);
				list.put(t1, t2);
				list.put(t2, temp);
			}
			current = list.get(current);
		}
	}
	
	public void insertBefore(T t1, T t2) {
		if (head == t1) {
			head = t2;
			list.put(t2, t1);
		}
		T current = head;
		while (current != null) {
			if (list.get(current) == t1) {
				list.put(current, t2);
				list.put(t2, t1);
				break;
			}
			current = list.get(current);
		}
	}
	
	public void deleteAll() {
		list.clear();
		head = null;
		tail = null;
	}
	
	public void deleteHead() {
		if (list.size() > 0) {
			if (list.size() == 1) deleteAll();
			T temp = list.get(head);
			list.remove(head);
			head = temp;
		}
	}
	
	
	public void reverse() {
		tail = head;
		T last = null;
		T current = head;
		
		while (current != null) {
			T next = list.get(current);
			list.put(current, last);
			last = current;
			current = next;
		}
		head = last;
	}
	
	public ArrayList<T> iterate() {
		ArrayList<T> listy = new ArrayList<T>(list.size());
		T current = head;
		while (current != null) {
			listy.add(current);
			current = list.get(current);
		}
		return listy;
	}

}
