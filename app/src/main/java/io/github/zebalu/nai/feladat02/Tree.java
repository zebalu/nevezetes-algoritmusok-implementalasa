package io.github.zebalu.nai.feladat02;

import java.util.Scanner;
import java.util.Set;

public class Tree {
    private static final String[] TEST_FILE_NAMES = {"input1.txt", "input2.txt", "input3.txt"};

    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("Fa (Tree)");
        for (String resourceName : TEST_FILE_NAMES) {
            System.out.println(resourceName);
            try (Scanner scanner = new Scanner(Tree.class.getResourceAsStream(resourceName))) {
                int testCount = scanner.nextInt();
                for (int t = 0; t < testCount; ++t) {
                    System.out.print((t + 1) + "\t/\t" + testCount + ":\t");
                    int edgeCount = scanner.nextInt();
                    DirectedGraph graph = new DirectedGraph();
                    for (int n = 0; n < edgeCount; ++n) {
                        int v = scanner.nextInt();
                        int w = scanner.nextInt();
                        graph.addEdge(v, w);
                    }
                    boolean isTree = isTree(graph);
                    System.out.println(t + 1 + " " + (isTree ? "fa" : "nem fa"));
                }
            }
            System.out.println("-".repeat(80));
        }
    }

    private static boolean isTree(DirectedGraph graph) {
        if (graph.getVertices().isEmpty()) {
            return true;
        }
        Set<Integer> roots = graph.getSources();
        if (roots.size() != 1) {
            return false;
        }
        int root = roots.iterator().next();
        Set<Integer> available = graph.getAvailableVertices(root);
        if (available.size() != graph.getVertices().size()) {
            return false;
        }
        return !graph.hasNonDirectedCycle(root);
    }
}
