
package controller;


public class Service {
    private int ServiceId;
    private String type;
    private float price;          

    public Service(int ServiceId, String type, float price) {
        this.ServiceId = ServiceId;
        this.type = type;
        this.price = price;
    }
   public Service( ){
       
   }

    public int getServiceId() {
        return ServiceId;
    }

    public void setServiceId(int ServiceId) {
        this.ServiceId = ServiceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
   
}
