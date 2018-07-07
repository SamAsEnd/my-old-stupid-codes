package com.samasend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
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
            student.setGroupRank(r - ((g) * 6));
        }

        int i = 0, gr = 1, r = 1;
        boolean up = false;

        while (true) {
            Student student = null;
            try {
                student = students.get(i);
                if (student.getGroupRank() == gr) {
                    student.setRank(r);//System.out.println("                     "+r);
                    r++;
                }
            } catch (Exception e) {
            }
            if (up) {
                i--;
            } else {
                i++;
            }
            if (i >= students.size() || i < 0) {
                gr++;
                up = !up;
            }
            if (gr > 6) {
                break;
            }
            //System.out.println("gr = " + gr + "   i = " + i);
        }

        Collections.sort(students);

        File out = new File("out.txt");
        PrintStream ps = new PrintStream(out);

        PrintStream p = System.out;
        p = ps;
        for (int j = 0; j < students.size(); j++) {
            p.print(students.get(j).toString().toUpperCase());
            p.println();
        }
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+out.getAbsolutePath());
    }

    private boolean read() throws IOException {
        buff = br.readLine();
        if (buff == null) {
            return false;
        }
        return true;
    }
}