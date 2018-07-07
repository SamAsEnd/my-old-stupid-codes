package com.samasend_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author SamAsEnd
 */
public class CSEDGrade {

    public static void main(String[] args) {
        try {
            CSEDGrade csedGrade = new CSEDGrade();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private BufferedReader br;
    private String buff;

    public CSEDGrade() throws IOException {
        File f = new File("in.txt");
        ArrayList<Student> students = new ArrayList<>(80);
        br = new BufferedReader(new FileReader(f));

        while (read() && buff != null && !buff.isEmpty()) {
            students.add(new Student(buff));
        }

        for (Student student : students) {
            int r = student.getRowId();
            int g = (r - 1) / 6;
            student.setGroupNumber(g + 1);
            student.setRank(r - ((g) * 6));
        }
        
        int i;
        

        Collections.sort(students);

        for (int j = 0; j < students.size(); j++) {
            System.out.println((j + 1) + ": " + students.get(j));
        }

    }

    private boolean read() throws IOException {
        buff = br.readLine();
        if (buff == null) {
            return false;
        }
        return true;
    }
}