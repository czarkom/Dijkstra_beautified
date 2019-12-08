package Dijkstra;

import java.util.ArrayList;

public class Graph {

    public ArrayList<City> graphNodes;
    public int amountOfNodes;

    public Graph(ArrayList<String> nodesNames, double[][] distances) {
        int amountOfNodes = distances.length;

        graphNodes = new ArrayList<City>();
        for (int i = 0; i < amountOfNodes; i++) {
            City city = new City(i, nodesNames.get(i), distances[i]);
            graphNodes.add(city);
        }

        this.amountOfNodes = amountOfNodes;
    }

    public City findCityInGraph(int ID) {
        return graphNodes.get(ID);
    }

}
