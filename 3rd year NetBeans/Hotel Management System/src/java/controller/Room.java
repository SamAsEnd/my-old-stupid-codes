

package controller;

public class Room {
    private int roomNumber;
    private float price;
    private String floorNum;
    public Room(int roomNumber,float price,String floorNum){
        this.roomNumber=roomNumber;
        this.price=price;
        this.floorNum=floorNum;
    }
    public Room(){
        
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }
    
}
