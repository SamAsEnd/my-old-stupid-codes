package sam;

import javax.swing.JOptionPane;

public class Book {
    
    private String writer;
    private int serialNumber;

    private static int bookCount = 0;
    
    public Book(String writer, int serialNumber) {
        this.writer = writer;
        this.serialNumber = serialNumber;
        bookCount++;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getWriter() {
        return writer;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public boolean isWriter(String writer) {
        return this.writer.contains(writer);
    }
    
    public boolean isSerialNumber(int serialNumber) {
        return serialNumber == this.serialNumber;
    }
    
    public boolean isSerialNumber(String serialNumber) {
        int num = 0;
        try {
            num = Integer.parseInt(serialNumber);
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, numberFormatException, "NumberFormatException", JOptionPane.ERROR_MESSAGE);
        }
        return num == this.serialNumber;
    }
    
    @Override
    public String toString() {
        return "Book:\n" + 
                "      By: " + getWriter() + "\n" +
                "      Serial: " + getSerialNumber() + "\n";
    }
    
    
    
}
