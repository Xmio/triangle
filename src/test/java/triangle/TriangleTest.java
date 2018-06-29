package triangle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

	private List<int[]> data = new ArrayList<>();

	@Before
	public void startup() {
		data.add(new int[] { 9 });
		data.add(new int[] { 6, 2 });
		data.add(new int[] { 1, 2, 7 });
		data.add(new int[] { 2, 4, 5, 1 });
		data.add(new int[] { 4, 1, 6, 8, 7 });
	}

	@Test
	public void tryTofindTheBestPath() {
		int[][] matrix = data.toArray(new int[data.size()][]);
		int[] path = Triangle.calculateBestPath(matrix);
		int sum = Triangle.getSum(path, matrix);
		int[] simplePath = Triangle.getPathValues(path, matrix);

		assertEquals(18, sum);
		assertArrayEquals(new int[] { 9, 2, 2, 4, 1 }, simplePath);
	}

}
