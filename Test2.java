package collatzDistribution;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Test2 {

	public static void main(String[] args) {
		CollatzGenerator gen = new CollatzGenerator(20);
		// inOrder(gen.getRoot());
		run(gen, 10000);
	}

	// testing
	public static void inOrder(CollatzTree node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}

	public static void run(CollatzGenerator gen, int iterations) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < iterations; i++) {
			// int val = run(gen.getRoot(), new Random().nextInt(gen.getLevel())); \\ random num of steps
			int val = run(gen.getRoot(), gen.getLevel() - 1);
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

	private static int run(CollatzTree node,  int level) {
		if (level == 0) {
			return node.data;
		}  else if (node.right == null) {
			return run(node.left, level - 1);
		}
		return new Random().nextBoolean() ? run(node.left, level - 1) : run(node.right, level - 1);
	}
	
}
