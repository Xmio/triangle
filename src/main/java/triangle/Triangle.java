package triangle;

import java.util.Arrays;

public class Triangle {

	private final int[][] triangle;

	public Triangle(int[][] triangle) {
		this.triangle = triangle;
	}

	public TriangleResult findBestPath() {
		int[][] clone = cloneTriangle(triangle);
		int[][] vectors = new int[clone.length][];
		for (int row = clone.length - 2; row >= 0; row--) {
			vectors[row] = new int[clone[row].length];
			for (int col = clone[row].length - 1; col >= 0; col--) {
				int min = Math.min(clone[row + 1][col], clone[row + 1][col + 1]);
				clone[row][col] += min;
				vectors[row][col] = clone[row + 1][col] == min ? col : col + 1;
			}
		}
		int[] path = new int[vectors.length];
		for (int i = 1; i < vectors.length; i++)
			path[i] = vectors[i - 1][path[i - 1]];
		return new TriangleResult(this, path);
	}

	private int[][] cloneTriangle(int[][] input) {
		int[][] result = new int[input.length][];
		for (int i = 0; i < input.length; i++)
			result[i] = Arrays.copyOf(input[i], input[i].length);
		return result;
	}

	public int[] pathValues(int[] path) {
		int[] vals = new int[path.length];
		for (int i = 0; i < path.length; i++)
			vals[i] = triangle[i][path[i]];
		return vals;
	}

}
