package io.github.zebalu.nai.feladat02;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    @Test
    void emptyGraphHasNoRoot() {
        DirectedGraph graph = new DirectedGraph();
        assertEquals(Set.of(), graph.getSources());
    }

    @Test
    void doubleRootsAreFound() {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex(1);
        graph.addVertex(2);
        assertEquals(Set.of(1, 2), graph.getSources());
    }

    @Test
    void simpleRootIsFound() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        assertEquals(Set.of(1), graph.getSources());
    }

    @Test
    void circleHasNoRoot() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        assertEquals(Set.of(), graph.getSources());
    }

    @Test
    void cycleIsDetected() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        assertTrue(graph.hasNonDirectedCycle(1));
    }

    @Test
    void noCycleIsCorrectlyRecognised() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        assertFalse(graph.hasNonDirectedCycle(1));
    }

    @Test
    void availabilityIsCalculatedCorrectly() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        graph.addEdge(5, 6);

        assertAll(
                () -> assertEquals(Set.of(1, 2, 3, 4), graph.getAvailableVertices(1)),
                () -> assertEquals(Set.of(5, 6), graph.getAvailableVertices(5))
        );
    }

    @Test
    void allVerticesCanBeRetrieved() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        graph.addEdge(5, 6);

        assertEquals(Set.of(1, 2, 3, 4, 5, 6), graph.getVertices());
    }

    @Test
    void directedCycleIsDetected() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        assertTrue(graph.hasDirectedCycle(1));
    }

    @Test
    void nonDirectedCycleIsCorrectlyRecognised() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        assertFalse(graph.hasDirectedCycle(1));
    }

}