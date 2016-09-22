package collatzDistribution;

public class CollatzTree {
	public int data;
	public CollatzTree left;
	public CollatzTree right;

	public CollatzTree(int data, CollatzTree left, CollatzTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public CollatzTree(int data) {
		this(data, null, null);
	}
}
