package Dijkstra;

import java.security.InvalidParameterException;

public class Dijkstra {

    private Graph graph;

    public Dijkstra(Data data) {
        this.graph = new Graph(data.names, data.cities);
    }

    public double[] findShortestDistances(int ID) {
        int amountOfNodes = graph.graphNodes.size();
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
            City notVisitedNode = getNotVisitedNode(graph, distances);

            if (notVisitedNode == null) {
                continue;
            }
            notVisitedNode.isVisited = true;

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

    private City getNotVisitedNode(Graph graph, double[] distances) {
        int n = graph.graphNodes.size();
        City notVisitedNode = null;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            City currentlyHeldCity = graph.graphNodes.get(i);
            if (distances[i] < minDistance && !currentlyHeldCity.isVisited) {
                minDistance = distances[i];
                notVisitedNode = currentlyHeldCity;
            }
        }
        return notVisitedNode;
    }

    public Graph getGraph() {
        return graph;
    }

}
