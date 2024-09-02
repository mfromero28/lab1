package com.arboleslab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MovieTree tree = new MovieTree();
        String line = "";
        String csvFile = "/dataset_movies.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(Main.class.getResource(csvFile).getPath()))) {
            br.readLine(); // Saltar el encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String title = data[0];
                int year = Integer.parseInt(data[6]);
                double worldwideEarnings = Double.parseDouble(data[1]);
                double domesticEarnings = Double.parseDouble(data[2]);
                double foreignEarnings = Double.parseDouble(data[4]);
                double domesticPercent = Double.parseDouble(data[3]);
                double foreignPercent = Double.parseDouble(data[5]);

                MovieNode movieNode = new MovieNode(title, year, worldwideEarnings, domesticEarnings,
                        foreignEarnings, domesticPercent, foreignPercent);

                tree.insert(movieNode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu(tree);
        menu.displayMenu();
    }

    // Clase que representa el menú
    static class Menu {

        private final MovieTree tree;

        public Menu(MovieTree tree) {
            this.tree = tree;
        }

        public void displayMenu() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Por favor, ingrese su nombre: ");
            String name = scanner.nextLine();

            System.out.println("\nBienvenido, ¡" + name + " Qué función desea ejecutar:");

            while (true) {
                System.out.println("1. Insertar un nodo.");
                System.out.println("2. Eliminar un nodo ");
                System.out.println("3. Buscar un nodo");
                System.out.println("4. Buscar todos los nodos que cumplan los siguientes criterios:");
                System.out.println("5. Mostrar el recorrido por niveles del árbol.");
                System.out.println("6. Mostrar árbol.");
                System.out.println("7. Salir.");

                System.out.print("\nIntroduce el número de la opción: ");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":

                    case "2":

                    case "3":

                    case "4":

                    case "5":

                    case "6":

                    case "7":
                        System.out.println("\n Hasta pronto \n");
                        return;
                    default:
                        System.out.println("El valor ingresado no se encuentra dentro de las opciones, por favor intente nuevamente.");
                }
            }
        }

        private void displaySubMenu(String node) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nQué función desea ejecutar:\n");
                System.out.println("1. Obtener el nivel del nodo.");
                System.out.println("2. Obtener el factor de balanceo (equilibrio) del nodo.");
                System.out.println("3. Encontrar el padre del nodo.");
                System.out.println("4. Encontrar el abuelo del nodo.");
                System.out.println("5. Encontrar el tío del nodo.");
                System.out.println("6. Salir.");

                System.out.print("\nIntroduce el número de la opción: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":

                    case "2":
//                      
                    case "3":

                    case "4":

                    case "5":

                    case "6":
                        return;
                    default:
                        System.out.println("El valor ingresado no se encuentra dentro de las opciones, por favor intente nuevamente.");
                }
            }
        }
    }
}
