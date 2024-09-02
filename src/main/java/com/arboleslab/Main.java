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
                        // Opción para insertar un nuevo nodo
                        System.out.print("Ingrese el título de la película: ");
                        String title = scanner.nextLine();
                        System.out.print("Ingrese el año de la película: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingrese los ingresos mundiales: ");
                        double worldwideEarnings = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese los ingresos domésticos: ");
                        double domesticEarnings = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese los ingresos extranjeros: ");
                        double foreignEarnings = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese el porcentaje doméstico: ");
                        double domesticPercent = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese el porcentaje extranjero: ");
                        double foreignPercent = Double.parseDouble(scanner.nextLine());

                        MovieNode newNode = new MovieNode(title, year, worldwideEarnings, domesticEarnings,
                                foreignEarnings, domesticPercent, foreignPercent);
                        tree.insert(newNode);
                        System.out.println("Nodo insertado correctamente.");
                        break;

                    case "2":
                        // Opción para eliminar un nodo (funcionalidad no implementada en la clase MovieTree)
                        System.out.println("La eliminación de nodos no está implementada.");
                        break;

                    case "3":
                        // Opción para buscar un nodo
                        System.out.print("Ingrese el título de la película a buscar: ");
                        String searchTitle = scanner.nextLine();
                        MovieNode foundNode = tree.search(searchTitle);
                        if (foundNode != null) {
                            System.out.println("Película encontrada: " + foundNode.getTitle() + " (" + foundNode.getYear() + ")");
                        } else {
                            System.out.println("Película no encontrada.");
                        }
                        break;

                    case "4":
                        // Opción para buscar nodos que cumplan ciertos criterios (puedes expandir esta lógica)
                        System.out.println("Esta opción no está implementada aún.");
                        break;

                    case "5":
                        // Mostrar el recorrido por niveles del árbol
                        tree.levelOrderTraversal();
                        break;

                    case "6":
                        // Mostrar detalles del árbol
                        System.out.println("Funcionalidad para mostrar árbol no implementada.");
                        break;

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
                        // Obtener el nivel del nodo
                        int level = tree.getNodeLevel(node);
                        if (level != -1) {
                            System.out.println("El nivel del nodo " + node + " es: " + level);
                        } else {
                            System.out.println("Nodo no encontrado.");
                        }
                        break;

                    case "2":
                        // Obtener el factor de balanceo del nodo (funcionalidad no implementada en la clase MovieTree)
                        System.out.println("Funcionalidad para obtener el factor de balanceo no implementada.");
                        break;

                    case "3":
                        // Encontrar el padre del nodo
                        MovieNode parent = tree.getParent(node);
                        if (parent != null) {
                            System.out.println("El padre del nodo " + node + " es: " + parent.getTitle());
                        } else {
                            System.out.println("El nodo no tiene padre o no se encontró.");
                        }
                        break;

                    case "4":
                        // Encontrar el abuelo del nodo
                        MovieNode grandparent = tree.getGrandparent(node);
                        if (grandparent != null) {
                            System.out.println("El abuelo del nodo " + node + " es: " + grandparent.getTitle());
                        } else {
                            System.out.println("El nodo no tiene abuelo o no se encontró.");
                        }
                        break;

                    case "5":
                        // Encontrar el tío del nodo
                        MovieNode uncle = tree.getUncle(node);
                        if (uncle != null) {
                            System.out.println("El tío del nodo " + node + " es: " + uncle.getTitle());
                        } else {
                            System.out.println("El nodo no tiene tío o no se encontró.");
                        }
                        break;

                    case "6":
                        // Salir del submenú
                        return;

                    default:
                        System.out.println("El valor ingresado no se encuentra dentro de las opciones, por favor intente nuevamente.");
                }
            }
        }
    }
}