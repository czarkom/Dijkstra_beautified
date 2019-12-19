import Dijkstra.Dijkstra;

import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
        int starterPointID = 0;
        try {
            InputDownloader inputDownloader = new InputDownloader();
            Dijkstra dijkstra = new Dijkstra(inputDownloader.getData());

            double[] result = dijkstra.findShortestDistances(starterPointID);

            Printer.showDistances(result, dijkstra.getGraph(), starterPointID);
        } catch (InvalidParameterException e) {
            System.err.println(e.getMessage());
        }
    }

}
