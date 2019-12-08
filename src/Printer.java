import Dijkstra.City;
import Dijkstra.Graph;

public class Printer {
    public static void showDistances(double[] foundDistances, Graph graph, int ID) {
        City startCity = graph.graphNodes.get(ID);

        int longestName = 0;

        for (int i = 0; i < foundDistances.length; i++) {
            if (i == ID) continue;

            City currentlyHeldCity = graph.graphNodes.get(i);

            if (currentlyHeldCity.name.length() > longestName) longestName = currentlyHeldCity.name.length();
        }

        String distancePrompt = String.format("%%s -> %%%ds = %%.0f%n", longestName);
        System.out.println("Czasy podróży z " + startCity.name + " do poszczególnych miast:");

        for (int i = 0; i < foundDistances.length; i++) {
            if (i == ID) continue;

            City currentlyHeldCity = graph.graphNodes.get(i);

            System.out.printf(distancePrompt, startCity.name, currentlyHeldCity.name, foundDistances[i]);
        }
    }
}
