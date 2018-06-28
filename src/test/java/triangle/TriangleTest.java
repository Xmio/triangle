package triangle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void tryTofindTheBestPath() {
		int[][] triangle = new int[][] { new int[] { 9 }, new int[] { 6, 2 }, new int[] { 1, 2, 7 },
				new int[] { 2, 4, 5, 1 }, new int[] { 4, 1, 6, 8, 7 } };
		Triangle tri = new Triangle(triangle);

		TriangleResult result = tri.findBestPath();
		assertEquals(18, result.getSum());
		assertArrayEquals(new int[] { 9, 2, 2, 4, 1 }, result.getPathValues());
	}

}
