package Dijkstra;

public class City {

    public final int id;
    public final String name;
    public boolean isVisited;
    public double[] distances;

    public City(int id, String name, double[] distances) {
        this.id = id;
        this.name = name;
        isVisited = false;
        this.distances = distances;
    }

}
