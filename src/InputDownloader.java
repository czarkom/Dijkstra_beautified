import Dijkstra.Data;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class InputDownloader {

    private Data data;

    public InputDownloader() {
        double[][] distances = getDistancesForCitiesFromInput();
        ArrayList<String> names = getNamesForCitiesFromInput();

        if (distances.length != names.size()) {
            throw new InvalidParameterException(
                    String.format("Podano złą liczbę miast w stosunku do matrycy sąsiedztwa. Podana ilość: %d, wymagana ilość: %d",
                            names.size(),
                            distances.length));
        }

        for (int i = 0; i < distances.length; i++) {
            if (distances[i].length != names.size()) {
                throw new InvalidParameterException(
                        String.format("W wierszu %d podano za małą liczbę połączeń miast w stosunku do ich liczebności. Podana ilość: %d, wymagana ilość: %d",
                                i + 1,
                                distances[i].length,
                                names.size()));
            }
            for (int j = 0; j < distances[i].length; j++) {
                if (distances[i][j] < 0) {
                    throw new InvalidParameterException(
                            String.format("Podano ujemną wagę połączenia miast w wierszu: %d, kolumnie: %d",
                                    i + 1,
                                    j + 1));
                }
            }
        }

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
