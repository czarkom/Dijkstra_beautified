import Dijkstra.Dijkstra;

import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
        InputDownloader inputDownloader = new InputDownloader();
        Dijkstra dijkstra = new Dijkstra(inputDownloader.getData());

        int starterPointID = 0;
        try {
            dijkstra.findShortestDistances(starterPointID);
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }

}
