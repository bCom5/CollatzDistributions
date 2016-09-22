package collatzDistribution;

import java.util.TreeMap;
import java.util.Map;
import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
		int n = 10000;
		int m = 10;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int bound = new Random().nextInt(m);
			int val = CollatzFunction(1, bound);
			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}
		
		for (int k : map.keySet()) {
			System.out.println(k + " " + map.get(k));
		}
	}
	
	public static int CollatzFunction(int n, int bound) {
		if (bound == 0) {
			return n;
		}
		if (n == 1 || (n - 1) % 3 != 0) {
			return CollatzFunction(n * 2, bound - 1);
		}
		return new Random().nextBoolean() ? CollatzFunction(n * 2, bound - 1) : CollatzFunction((n - 1) / 3, bound - 1);
	}
}
