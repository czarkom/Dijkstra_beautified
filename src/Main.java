import Dijkstra.Dijkstra;

import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
        InputDownloader inputDownloader = new InputDownloader();
        Dijkstra dijkstra = new Dijkstra(inputDownloader.getData());

        int starterPointID = 3;
        try {
            double[] result = dijkstra.findShortestDistances(starterPointID);
            Printer.showDistances(result, dijkstra.getGraph(), starterPointID);
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }

}
