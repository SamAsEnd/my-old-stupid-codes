
package controller;


public class Branch {
     private int bNo;
    private String bName;
    private String status;

    public Branch(int bNo, String bName, String status) {
        this.bNo = bNo;
        this.bName = bName;
        this.status = status;
    }
   public Branch(){
       
   }

    public int getbNo() {
        return bNo;
    }

    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
