package algorithms;

public class HashEntry {
	
	private int myKey;
	private int myValue;
	
	public HashEntry(int key, int value) {
		myKey = key;
		myValue = value;
	}
	
	
	public int getKey() {
		return myKey;
	}
	
	public int getValue() {
		return myValue;
	}
	
	public void setValue(int v) {
		myValue = v;
	}

}
