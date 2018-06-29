package triangle;

import java.util.Arrays;

public class Triangle {

	@FunctionalInterface
	public interface Matrix {
		int get(int[][] matrix, int row, int col);
	}

	public static int[] calculateBestPath(int[][] triangle) {
		Matrix getCurrentlyCell = (m, r, c) -> currentlyCell(m, r, c);
		Matrix getNextCell = (m, r, c) -> nextCell(m, r, c);

		int[][] clone = cloneTriangle(triangle);
		int[][] vectors = new int[clone.length][];
		for (int row = clone.length - 2; row >= 0; row--) {
			vectors[row] = new int[clone[row].length];
			for (int col = clone[row].length - 1; col >= 0; col--) {
				int currently = getCurrentlyCell.get(clone, row, col);
				int next = getNextCell.get(clone, row, col);
				int min = Math.min(currently, next);
				clone[row][col] += min;
				vectors[row][col] = currently == min ? col : col + 1;
			}
		}
		return buildPath(vectors);
	}

	private static int currentlyCell(int[][] matrix, int row, int col) {
		return matrix[row + 1][col];
	}

	private static int nextCell(int[][] matrix, int row, int col) {
		return matrix[row + 1][col + 1];
	}

	private static int[] buildPath(int[][] vectors) {
		int[] path = new int[vectors.length];
		for (int i = 1; i < vectors.length; i++)
			path[i] = vectors[i - 1][path[i - 1]];
		return path;
	}

	private static int[][] cloneTriangle(int[][] input) {
		int[][] result = new int[input.length][];
		for (int i = 0; i < input.length; i++)
			result[i] = Arrays.copyOf(input[i], input[i].length);
		return result;
	}

	public static int[] pathValues(int[] path, int[][] triangle) {
		int[] vals = new int[path.length];
		for (int i = 0; i < path.length; i++)
			vals[i] = triangle[i][path[i]];
		return vals;
	}

	public static int getSum(int[] path, int[][] triangle) {
		int sum = 0;
		for (int v : pathValues(path, triangle))
			sum += v;
		return sum;
	}

	public static int[] getPathValues(int[] path, int[][] triangle) {
		return pathValues(path, triangle);
	}

}
