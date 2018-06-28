package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import triangle.Triangle;
import triangle.TriangleResult;

public class Application {
	public static void main(String[] args) throws IOException {
		List<int[]> triangleData = retriveTriangleMatrixBasedOnFile();
		Triangle triangle = new Triangle(triangleData);
		TriangleResult result = triangle.findBestPath();
		System.out.println("Minimal path is: " + result.getPathValues().toString() + " = " + result.getSum());
	}

	private static List<int[]> retriveTriangleMatrixBasedOnFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("data.txt"));
		List<int[]> triangle = new ArrayList<>();
		while (sc.hasNextLine()) {
			String[] rowValues = sc.nextLine().split(" ");
			triangle.add(Arrays.stream(rowValues).mapToInt(Integer::parseInt).toArray());
		}
		sc.close();
		return triangle;
	}
}
