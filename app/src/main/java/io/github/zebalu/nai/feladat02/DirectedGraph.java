package io.github.zebalu.nai.feladat02;

import static java.util.function.Predicate.not;

import java.util.*;

class DirectedGraph {
    private final Set<Integer> vertices = new HashSet<>();
    private final Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

    public void addVertex(int v) {
        vertices.add(v);
    }

    public Set<Integer> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public void addEdge(int v, int w) {
        addVertex(v);
        addVertex(w);
        adjacencyList.computeIfAbsent(v, _ -> new HashSet<>()).add(w);
    }

    public Set<Integer> getSources() {
        Set<Integer> sources = new HashSet<>(vertices);
        adjacencyList.values().forEach(sinks -> sources.removeAll(sinks));
        return sources;
    }

    public Set<Integer> getAvailableVertices(int from) {
        Set<Integer> availableVertices = new HashSet<>();
        availableVertices.add(from);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (adjacencyList.containsKey(v)) {
                adjacencyList.get(v).stream().filter(not(availableVertices::contains)).forEach(w -> {
                    availableVertices.add(w);
                    queue.add(w);
                });
            }
        }
        return availableVertices;
    }

    public boolean hasNonDirectedCycle(int from) {
        Set<Integer> reachedVertices = new HashSet<>();
        reachedVertices.add(from);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (adjacencyList.containsKey(v)) {
                for (Integer w : adjacencyList.get(v)) {
                    if (reachedVertices.contains(w)) {
                        return true;
                    } else {
                        reachedVertices.add(w);
                        queue.add(w);
                    }
                }
            }
        }
        return false;
    }

    public boolean hasDirectedCycle(int from) {
        Set<Integer> reachedVertices = new HashSet<>();
        Deque<SequencedCollection<Integer>> stack = new ArrayDeque<>();
        stack.addLast(new LinkedHashSet<>(Set.of(from)));
        while (!stack.isEmpty()) {
            SequencedCollection<Integer> path = stack.pollLast();
            int v = path.getLast();
            if (!reachedVertices.contains(v) && adjacencyList.containsKey(v)) {
                for (Integer w : adjacencyList.get(v)) {
                    if(path.contains(w)) {
                        return true;
                    } else if(!reachedVertices.contains(w)) {
                        SequencedCollection<Integer> next = new LinkedHashSet<>(path);
                        next.addLast(w);
                        stack.addLast(next);
                    }
                }
            }
            reachedVertices.add(v);
        }
        return false;
    }

}
