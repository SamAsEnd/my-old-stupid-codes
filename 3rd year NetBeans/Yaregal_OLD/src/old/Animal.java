package old;

public class Animal {
    public String name;
    public char sex;
    public byte age;
    public String type;
    public boolean hangy;
    //public 
    public void sleep() {
        System.out.println(this.name+" is sleeping");
        this.hangy = true;
    }
    public void eat() {
        System.out.println(this.name+" is eating");
        this.hangy = false;
    }
    
    
}
