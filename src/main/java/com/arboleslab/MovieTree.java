package com.arboleslab;

/**
 *
 * @author marro
 */
public class MovieTree {
    private MovieNode root;

    public MovieTree() {
        this.root = null;
    }

    public void insert(MovieNode movieNode) {
        if (root == null) {
            root = movieNode;
        } else {
            root = insert(root, movieNode);
        }
    }

    private MovieNode insert(MovieNode current, MovieNode movieNode) {
        if (current == null) {
            return movieNode;
        }

        if (movieNode.getTitle().compareTo(current.getTitle()) < 0) {
            current.setLeft(insert(current.getLeft(), movieNode));
        } else if (movieNode.getTitle().compareTo(current.getTitle()) > 0) {
            current.setRight(insert(current.getRight(), movieNode));
        }

        return balanceTree(current);
    }

    private int height(MovieNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private int getBalance(MovieNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private MovieNode balanceTree(MovieNode node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }

        if (balance < -1) {
            if (getBalance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }

        return node;
    }

    private MovieNode rotateLeft(MovieNode z) {
        MovieNode y = z.getRight();
        MovieNode t2 = y.getLeft();

        y.setLeft(z);
        z.setRight(t2);

        return y;
    }

    private MovieNode rotateRight(MovieNode y) {
        MovieNode z = y.getLeft();
        MovieNode t3 = z.getRight();

        z.setRight(y);
        y.setLeft(t3);

        return z;
    }

    public MovieNode search(String title) {
        return search(root, title);
    }

    private MovieNode search(MovieNode node, String title) {
        if (node == null || node.getTitle().equals(title)) {
            return node;
        }

        if (title.compareTo(node.getTitle()) < 0) {
            return search(node.getLeft(), title);
        }

        return search(node.getRight(), title);
    }

    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        levelOrderTraversal(root, 0);
    }

    private void levelOrderTraversal(MovieNode node, int level) {
        if (node == null) {
            return;
        }

        System.out.println("Nivel " + level + ": " + node.getTitle());
        levelOrderTraversal(node.getLeft(), level + 1);
        levelOrderTraversal(node.getRight(), level + 1);
    }

    public int getNodeLevel(String title) {
        return getNodeLevel(root, title, 0);
    }

    private int getNodeLevel(MovieNode node, String title, int level) {
        if (node == null) {
            return -1;
        }

        if (node.getTitle().equals(title)) {
            return level;
        }

        int downlevel = getNodeLevel(node.getLeft(), title, level + 1);
        if (downlevel != -1) {
            return downlevel;
        }

        return getNodeLevel(node.getRight(), title, level + 1);
    }

    public MovieNode getParent(String title) {
        return getParent(root, title, null);
    }

    private MovieNode getParent(MovieNode node, String title, MovieNode parent) {
        if (node == null) {
            return null;
        }

        if (node.getTitle().equals(title)) {
            return parent;
        }

        if (title.compareTo(node.getTitle()) < 0) {
            return getParent(node.getLeft(), title, node);
        } else {
            return getParent(node.getRight(), title, node);
        }
    }

    public MovieNode getGrandparent(String title) {
        MovieNode parent = getParent(title);
        return (parent != null) ? getParent(parent.getTitle()) : null;
    }

    public MovieNode getUncle(String title) {
        MovieNode parent = getParent(title);
        MovieNode grandparent = getGrandparent(title);

        if (grandparent == null) {
            return null;
        }

        if (grandparent.getLeft() == parent) {
            return grandparent.getRight();
        } else {
            return grandparent.getLeft();
        }
    }

}
