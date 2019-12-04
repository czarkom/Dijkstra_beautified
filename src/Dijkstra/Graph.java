package Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    public HashMap<Integer, City> graphNodes;
    public int amountOfNodes;

    public Graph(ArrayList<String> nodesNames, double[][] distances) {
        int amountOfNodes = distances.length;

        graphNodes = new HashMap<Integer, City>();
        for (int i = 0; i < amountOfNodes; i++) {
            City city = new City(i, nodesNames.get(i), distances[i]);
            graphNodes.put(i, city);
        }

        this.amountOfNodes = amountOfNodes;
    }

    public City findCityInGraph(int ID) {
        return graphNodes.get(ID);
    }

}
