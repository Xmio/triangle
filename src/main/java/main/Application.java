package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
	public static void main(String[] args) throws IOException {
		List<List<Integer>> triangle = retriveTriangleMatrixBasedOnFile();
	}

	private static List<List<Integer>> retriveTriangleMatrixBasedOnFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("data.txt"));
		List<List<Integer>> triangle = new ArrayList<>();
		while (sc.hasNextLine()) {
			String[] rowValues = sc.nextLine().split(" ");
			triangle.add(Arrays.stream(rowValues).map(Integer::parseInt).collect(Collectors.toList()));
		}
		sc.close();
		return triangle;
	}
}
