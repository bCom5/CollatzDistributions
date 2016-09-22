package collatzDistribution;

public class CollatzGenerator {
	private int level;
	private CollatzTree root;
	public static final int ROOT_DATA = 1;

	public CollatzGenerator(int level) {
		this.level = level;
		root = level <= 0 ? null
				: new CollatzTree(ROOT_DATA, genLeft(ROOT_DATA, level - 1), genRight(ROOT_DATA, level - 1));
	}

	private CollatzTree genLeft(int data, int level) {
		if (level == 0) {
			return null;
		}
		int n = 2 * data;
		return new CollatzTree(n, genLeft(n, level - 1), genRight(n, level - 1));
	}

	private CollatzTree genRight(int data, int level) {
		if (level == 0 || (data - 1) % 3 != 0 || data == 1) {
			return null;
		}
		int n = (data - 1) / 3;
		return new CollatzTree(n, genLeft(n, level - 1), genRight(n, level - 1));
	}

	public int getLevel() {
		return level;
	}

	public CollatzTree getRoot() {
		return root;
	}
}
