package com.arboleslab;

/**
 *
 * @author marro
 */
public class MovieTree {
    private MovieNode root;

    // Inserta un nuevo nodo en el árbol AVL
    public void insert(MovieNode newNode) {
        root = insertNode(root, newNode);
    }

    // Método recursivo para insertar un nodo en el árbol
    private MovieNode insertNode(MovieNode current, MovieNode newNode) {
        if (current == null) {
            return newNode;
        }

        // Inserta en el subárbol correspondiente
        if (newNode.title.compareTo(current.title) < 0) {
            current.left = insertNode(current.left, newNode);
        } else if (newNode.title.compareTo(current.title) > 0) {
            current.right = insertNode(current.right, newNode);
        } else {
            // Si el título ya existe, no se inserta
            return current;
        }

        // Actualiza la altura del nodo actual
        current.height = 1 + Math.max(getHeight(current.left), getHeight(current.right));

        // Balancea el árbol si es necesario
        return balanceTree(current, newNode.title);
    }

    // Elimina un nodo del árbol por su título
    public void delete(String title) {
        root = deleteNode(root, title);
    }

    // Método recursivo para eliminar un nodo
    private MovieNode deleteNode(MovieNode current, String title) {
        if (current == null) return null;

        // Navega hasta el nodo que se debe eliminar
        if (title.compareTo(current.title) < 0) {
            current.left = deleteNode(current.left, title);
        } else if (title.compareTo(current.title) > 0) {
            current.right = deleteNode(current.right, title);
        } else {
            // Caso: nodo encontrado
            if (current.left == null || current.right == null) {
                // Nodo con un solo hijo o sin hijos
                return (current.left != null) ? current.left : current.right;
            } else {
                // Nodo con dos hijos: encuentra el sucesor en el subárbol derecho
                MovieNode temp = getMinValueNode(current.right);
                current.title = temp.title;
                current.right = deleteNode(current.right, temp.title);
            }
        }

        current.height = 1 + Math.max(getHeight(current.left), getHeight(current.right));
        return balanceTree(current, title);
    }

    // Busca un nodo por título
    public MovieNode search(String title) {
        return searchNode(root, title);
    }

    // Método recursivo para buscar un nodo
    private MovieNode searchNode(MovieNode current, String title) {
        if (current == null || current.title.equals(title)) {
            return current;
        }
        if (title.compareTo(current.title) < 0) {
            return searchNode(current.left, title);
        } else {
            return searchNode(current.right, title);
        }
    }

    // Muestra el recorrido por niveles del árbol
    public void levelOrderTraversal() {
        if (root == null) return;

        // Cola para almacenar los nodos en el nivel actual
        java.util.Queue<MovieNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            MovieNode current = queue.poll();
            System.out.println(current.getTitle()); // Muestra el título del nodo

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    // Obtiene la altura de un nodo
    private int getHeight(MovieNode node) {
        return (node == null) ? 0 : node.height;
    }

    // Balancea el árbol AVL después de una inserción o eliminación
    private MovieNode balanceTree(MovieNode node, String key) {
        int balance = getBalance(node);

        // Rotación simple a la derecha
        if (balance > 1 && key.compareTo(node.left.title) < 0) {
            return rotateRight(node);
        }

        // Rotación simple a la izquierda
        if (balance < -1 && key.compareTo(node.right.title) > 0) {
            return rotateLeft(node);
        }

        // Rotación doble izquierda-derecha
        if (balance > 1 && key.compareTo(node.left.title) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Rotación doble derecha-izquierda
        if (balance < -1 && key.compareTo(node.right.title) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Rotación hacia la derecha
    private MovieNode rotateRight(MovieNode y) {
        MovieNode x = y.left;
        y.left = x.right;
        x.right = y;

        // Actualiza las alturas
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // Rotación hacia la izquierda
    private MovieNode rotateLeft(MovieNode x) {
        MovieNode y = x.right;
        x.right = y.left;
        y.left = x;

        // Actualiza las alturas
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    // Obtiene el balance de un nodo
    private int getBalance(MovieNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // Encuentra el nodo con el valor mínimo en un subárbol
    private MovieNode getMinValueNode(MovieNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}