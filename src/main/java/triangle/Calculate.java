package triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Calculate {

	public static void main(String[] args) throws IOException {
		int[][] matrix = retriveTriangleMatrixBasedOnFile();
		int[] path = Triangle.calculateBestPath(matrix);
		int sum = Triangle.getSum(path, matrix);
		int[] simplePath = Triangle.getPathValues(path, matrix);

		List<String> pathValues = Arrays.stream(simplePath).boxed().collect(Collectors.toList()).stream()
				.map(Object::toString).collect(Collectors.toList());

		System.out.println("Minimal path is: " + String.join(" + ", pathValues) + " = " + sum);
	}

	private static int[][] retriveTriangleMatrixBasedOnFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("data.txt"));
		List<int[]> triangle = new ArrayList<>();
		while (sc.hasNextLine()) {
			String[] rowValues = sc.nextLine().split(" ");
			triangle.add(Arrays.stream(rowValues).mapToInt(Integer::parseInt).toArray());
		}
		sc.close();
		return triangle.toArray(new int[triangle.size()][]);
	}
}
