package com.samasend;

public class Country {
    
    private String name;
    private double avg;
    private String status;

    public Country(String name, double avg, String status) {
        this.name = name;
        this.avg = avg;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
