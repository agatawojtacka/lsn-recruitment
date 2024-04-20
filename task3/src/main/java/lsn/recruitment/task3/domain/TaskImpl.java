package lsn.recruitment.task3.domain;

import lombok.Data;

import java.util.*;

public class TaskImpl implements Task {

    public int execute(List<Pair> pairs) {
        if (Objects.isNull(pairs)) {
            throw new IllegalArgumentException("Invalid input data: null");
        }
        Graphs graphs = new Graphs();
        pairs.forEach(pair -> {
            Optional<Graph> graphOptional = graphs.findGraphByNode(pair.getX())
                    .or(() -> graphs.findGraphByNode(pair.getY()));
            graphOptional.ifPresentOrElse(
                    graph -> graph.addNodes(pair),
                    () -> graphs.addNewGraph(pair)
            );
        });
        return graphs.size();
    }

    @Data
    private static class Graphs {
        private final List<Graph> graphs = new ArrayList<>();

        private Optional<Graph> findGraphByNode(int node) {
            return graphs.stream()
                    .filter(graph -> graph.containsNode(node))
                    .findFirst();
        }

        private void addNewGraph(Pair pair) {
            Graph graph = new Graph();
            graph.addNodes(pair);
            graphs.add(graph);
        }

        private int size() {
            return graphs.size();
        }
    }

    @Data
    private static class Graph {
        private final Set<Integer> nodes = new HashSet<>();

        private synchronized boolean containsNode(int node) {
            return nodes.contains(node);
        }

        private synchronized void addNodes(Pair pair) {
            nodes.add(pair.getX());
            nodes.add(pair.getY());
        }
    }
}
