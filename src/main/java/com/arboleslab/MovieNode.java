package com.arboleslab;

public class MovieNode {
    private String title;
    private int year;
    private double worldwideEarnings;
    private double domesticEarnings;
    private double foreignEarnings;
    private double domesticPercent;
    private double foreignPercent;
    private MovieNode left;
    private MovieNode right;

    public MovieNode(String title, int year, double worldwideEarnings, double domesticEarnings,
                     double foreignEarnings, double domesticPercent, double foreignPercent) {
        this.title = title;
        this.year = year;
        this.worldwideEarnings = worldwideEarnings;
        this.domesticEarnings = domesticEarnings;
        this.foreignEarnings = foreignEarnings;
        this.domesticPercent = domesticPercent;
        this.foreignPercent = foreignPercent;
        this.left = null;
        this.right = null;
    }

    // Getters y Setters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getWorldwideEarnings() {
        return worldwideEarnings;
    }

    public double getDomesticEarnings() {
        return domesticEarnings;
    }

    public double getForeignEarnings() {
        return foreignEarnings;
    }

    public double getDomesticPercent() {
        return domesticPercent;
    }

    public double getForeignPercent() {
        return foreignPercent;
    }

    public MovieNode getLeft() {
        return left;
    }

    public void setLeft(MovieNode left) {
        this.left = left;
    }

    public MovieNode getRight() {
        return right;
    }

    public void setRight(MovieNode right) {
        this.right = right;
    }
}
