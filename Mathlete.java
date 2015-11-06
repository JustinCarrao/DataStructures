package algorithms;

import java.util.ArrayList;

public class Mathlete {
	
	public Mathlete() {
		
	}
	
	public int min(int a,int b,int c){
	    return(Math.min(Math.min(a,b),c));
	  }
	
	public ArrayList<Integer> nPrimes(int n) {  //for primes less than some given number n
		ArrayList<Integer> marked = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int flag = 2;
		int z = flag;
		while (z < n) {
			if (!marked.contains(z)) {
				flag = z;
			}
			for (int i = 2; i < n; i++) {
				marked.add(flag*i);
			}
			z++;
		}
		for (int k = 2; k < n; k++) {
			if (!marked.contains(k)) {
				primes.add(k);
			}
		}
		return primes;
	}
	
	public double squareRoot(double n) {
		double current = n * 0.5;
		double high = n;
		double low = 0;
		double flag = current * current;
		while (Math.abs(flag - n) > 0.00000001) {
			if (flag > n) {
				high = current;
				current = (current+low)/2;
			}
			if (flag < n) {
				low = current;
				current = (current + high)/2;
			}
			flag = current*current;
		}
		if (Math.round(current)*Math.round(current) == n) return Math.round(current);
		return current;
	}
	
	public double uniformDistRand(int min, int max) {
		return min + Math.random()*(max - min);
	}
	
	/*public ArrayList<Integer> longIncSub(ArrayList<Integer> list) {
		
		
		
	}*/
	
	public ArrayList<Integer> emptyRegions(ArrayList<Integer> list) { //not particularly efficient  O(x) where x is the value of the highest element in the array.
		ArrayList<Integer> empties = new ArrayList<Integer>();
		int index = 0;
		int prev = 0;
		while (index < list.size()) {
			int upTo = list.get(index);
			for (int i = prev; i < upTo; i++) {
				empties.add(i);
			}
			prev = upTo + 1;
			index++;
		}
		return empties;
		
	}
	
	public long sumFirstN(long n) {
		long[] sums = new long[(int) n];
		sums[0] = 0;
		for (int i = 1; i < n; i++) {
			sums[i] = i + sums[i-1];
		}
		int prev = (int) n;
		prev--;
		return n + sums[prev];
	}
	
	public int fact(int n) {
		if (n <= 1) return 1;
		return n*fact(n-1);
	}
	
	public int fibRecursive(int n) {
		if (n==0) return n;
		if (n==1 || n==2) {
			return 1;
		}
		return fibRecursive(n-1) + fibRecursive(n-2);
	}

	public int fibMemo(int n) {
		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;
		for (int i = 3; i < n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[memo.length - 1];
	}
	


}
