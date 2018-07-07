package com.samasend_1;

import java.io.StringReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Student implements Comparable<Student>{

    private int id;
    private String name;
    private String fatherName;
    private String grandFatherName;
    
    private int rank;
    private int rowId;
    private int batch;
    private int groupNumber;

    public Student(String rowData) {
        Scanner txt = new Scanner(rowData);

        rowId = txt.nextInt();
        name = txt.next();
        fatherName = txt.next();
        if(txt.hasNext()) {
            grandFatherName = txt.next();
        }
        if(txt.hasNext()) {
            String temp = txt.next();
            id = calcBatch(temp);
        }
    }

    public Student(int id, String name, String fatherName, String grandFatherName, int rowId, int batch, int groupNumber) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.grandFatherName = grandFatherName;
        this.rowId = rowId;
        this.batch = batch;
        this.groupNumber = groupNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGrandFatherName() {
        return grandFatherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        this.grandFatherName = grandFatherName;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    private int calcBatch(String temp) {
        int i = -1;
        temp = temp.trim();
        //temp.replaceAll("", name)

        // calc soon

        return i;
    }

    @Override
    public String toString() {
        return name + " " + fatherName + " " + grandFatherName + "  Group: " + groupNumber + " Rank: " + rank;
    }

    @Override
    public int compareTo(Student o) {
        return (rank-o.getRank());
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
