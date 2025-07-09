package io.github.zebalu.nai.feladat01;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Maffia {
    private static final String[] TEST_FILE_NAMES = {"input.txt", "test0.txt", "test1.txt", "test2.txt", "test10.txt", "test13.txt", "test14.txt"};

    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("A Vito maffia (Vito's family)");
        for (String resourceName : TEST_FILE_NAMES) {
            System.out.println(resourceName);
            try (Scanner scanner = new Scanner(Maffia.class.getResourceAsStream(resourceName))) {
                int testCount = scanner.nextInt();
                for (int t = 0; t < testCount; ++t) {
                    System.out.print((t + 1) + "\t/\t" + testCount + ":\t");
                    int neighbours = scanner.nextInt();
                    int[] allHouses = new int[neighbours];
                    for (int n = 0; n < neighbours; ++n) {
                        allHouses[n] = scanner.nextInt();
                    }
                    System.out.println(solve(allHouses));
                }
            }
            System.out.println("-".repeat(80));
        }
    }

    private static int solve(int[] allHouses) {
        if (allHouses.length == 0) {
            return 0;
        }
        //Arrays.sort(allHouses);
        QuickSort.quickSort(allHouses);
        System.out.println(Arrays.toString(allHouses));
        int selected = allHouses[(allHouses.length - 1)/2];
        return IntStream.of(allHouses).map(i->Math.abs(i - selected)).sum();
    }
}
