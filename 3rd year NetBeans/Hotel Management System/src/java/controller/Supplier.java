
package controller;


public class Supplier {
     private int orgId;
    private String orgName;
    private int itemId;
    private int quantity;
    private float price;

    public Supplier(int orgId, String orgName, int itemId, int quantity, float price) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
   public Supplier(){
       
   }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
   
}
