package triangle;

import java.util.Arrays;

public class TriangleResult {

	private final Triangle triangle;
	private final int[] path;

	public TriangleResult(Triangle triangle, int[] path) {
		this.triangle = triangle;
		this.path = Arrays.copyOf(path, path.length);
	}

	public int getSum() {
		int sum = 0;
		for (int v : triangle.pathValues(path))
			sum += v;
		return sum;
	}

	public int[] getPathValues() {
		return triangle.pathValues(path);
	}

}
