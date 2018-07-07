

package controller;

import java.util.Date;


public class Item {
    private int itemId;
    private String name;
    private float price;
    private Date expDate;

    public Item(int itemId, String name, float price, Date expDate) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.expDate = expDate;
    }
    public Item(){
        
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    
}
