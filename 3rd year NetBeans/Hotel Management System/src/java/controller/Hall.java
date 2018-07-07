

package controller;


public class Hall {
    private int hallNum;
    private String floorNum;
    private float price;
    private String size;

    public Hall(int hallNum, String floorNum, float price, String size) {
        this.hallNum = hallNum;
        this.floorNum = floorNum;
        this.price = price;
        this.size = size;
    }
    
    public Hall(){   
    }

    public int getHallNum() {
        return hallNum;
    }

    public void setHallNum(int hallNum) {
        this.hallNum = hallNum;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    
}
