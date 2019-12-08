import Dijkstra.Data;

import java.util.ArrayList;
import java.util.Arrays;

public class InputDownloader {

    private Data data;

    public InputDownloader() {
        double[][] distances = getDistancesForCitiesFromInput();
        ArrayList<String> names = getNamesForCitiesFromInput();
        data = new Data(names, distances);
    }

    public Data getData() {
        return data;
    }

    private double[][] getDistancesForCitiesFromInput() {
        double[][] cities = {
                {0, 2, 10, 0, 8, 0},
                {0, 0, 12, 0, 5, 0},
                {0, 0, 0, 0, 0, 4},
                {0, 100, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 3},
                {0, 0, 0, 0, 0, 0}};
        return cities;
    }

    private ArrayList<String> getNamesForCitiesFromInput() {
        ArrayList<String> namesForCities = new ArrayList<>(Arrays.asList("Nowy Jork", "Hong Kong", "Piła", "Tokio", "Warszawa", "Serock"));
        return namesForCities;
    }

}
