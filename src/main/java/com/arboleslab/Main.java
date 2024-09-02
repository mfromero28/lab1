package com.arboleslab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        MovieTree tree = new MovieTree();
        String line = "";
        String csvFile = "/dataset_movies.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(.getClass().getResource(csvFile)))) {
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String title = data[0];
                int year = Integer.parseInt(data[1]);
                double worldwideEarnings = Double.parseDouble(data[2]);
                double domesticEarnings = Double.parseDouble(data[3]);
                double foreignEarnings = Double.parseDouble(data[4]);
                double domesticPercent = Double.parseDouble(data[5]);
                double foreignPercent = Double.parseDouble(data[6]);

                MovieNode movieNode = new MovieNode(title, year, worldwideEarnings, domesticEarnings,
                        foreignEarnings, domesticPercent, foreignPercent);

                tree.insert(movieNode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
