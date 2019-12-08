package Dijkstra;

import java.security.InvalidParameterException;

public class Dijkstra {

    private Graph graph;
    private boolean[] isVisited;

    public Dijkstra(Data data) {
        this.graph = new Graph(data.names, data.cities);
        isVisited = new boolean[graph.amountOfNodes];
    }

    public double[] findShortestDistances(int ID) {
        int amountOfNodes = graph.amountOfNodes;
        if (ID < 0 || ID > amountOfNodes - 1) {
            String message = "Invalid starter point identifier detected. Please enter an integer from range (0, " + (amountOfNodes - 1) + ").";
            throw new InvalidParameterException(message);
        }

        double[] distances = new double[amountOfNodes];

        for (int i = 0; i < amountOfNodes; i++) {
            if (ID == i) {
                continue;
            }
            distances[i] = Double.POSITIVE_INFINITY;
        }

        for (int i = 0; i < amountOfNodes; i++) {
            City notVisitedNode = getNotVisitedNode(isVisited, distances);
            isVisited[notVisitedNode.id] = true;
            for (int j = 0; j < amountOfNodes; j++) {
                if (distances[notVisitedNode.id] < Double.POSITIVE_INFINITY
                        && notVisitedNode.distances[j] > 0
                        && distances[notVisitedNode.id] + notVisitedNode.distances[j] < distances[j]) {
                    distances[j] = distances[notVisitedNode.id] + notVisitedNode.distances[j];
                }
            }
        }

        return distances;
    }

    private City getNotVisitedNode(boolean[] isVisited, double[] distances) {
        int n = isVisited.length;
        int minDistanceId = Integer.MIN_VALUE;
        double minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (distances[i] < minDistance && !isVisited[i]) {
                minDistance = distances[i];
                minDistanceId = i;
            }
        }
        return graph.graphNodes.get(minDistanceId);
    }

    public Graph getGraph() {
        return graph;
    }

}
