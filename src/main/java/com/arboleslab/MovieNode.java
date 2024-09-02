package com.arboleslab;

public class MovieNode {
    String title;
    int year;
    double WorldwideEarnings;
    double DomesticEarnings;
    double ForeignEarnings;
    double DomesticPercentEarning;
    double ForeignPercentEarnins;
    MovieNode left, right;
    int height;
    

    public MovieNode(String title, int year, double DomesticEarnings, double ForeignEarnings, double foreignEarnings, double domesticPercent, double foreignPercent) {
        this.title = title;
        this.year = year;
        this.DomesticEarnings = DomesticEarnings;
        this.ForeignEarnings = ForeignEarnings;
        this.left=null;
        this.right=null;
        this.height=1;
    }

    public double getWorldwideEarnings() {
        return WorldwideEarnings;
    }

    public void setWorldwideEarnings(double WorldwideEarnings) {
        this.WorldwideEarnings = WorldwideEarnings;
    }

    public double getDomesticEarnings() {
        return DomesticEarnings;
    }

    public void setDomesticEarnings(double DomesticEarnings) {
        this.DomesticEarnings = DomesticEarnings;
    }

    public double getDomesticPercentEarning() {
        return DomesticPercentEarning;
    }

    public void setDomesticPercentEarning(double DomesticPercentEarning) {
        this.DomesticPercentEarning = DomesticPercentEarning;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getForeignEarnings() {
        return ForeignEarnings;
    }

    public double getForeignPercentEarnins() {
        return ForeignPercentEarnins;
    }
    
   
    
}
