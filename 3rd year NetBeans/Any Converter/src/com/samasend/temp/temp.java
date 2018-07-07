package com.samasend.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author SamAsEnd
 */
public class temp {

    static String type = "";
    static ArrayList<String> list = new ArrayList<>();
    static HashMap<String, ArrayList<String>> map = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            File file = new File("list.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String s = "", camel;
            while ((s = br.readLine()) != null) {
                camel = toCamel(s);
                if (s.charAt(0) != '\t') {
                    update();
                    type = camel;
                } else {
                    list.add(camel);
                }
            }
        } catch (IOException iOException) {
            System.out.println("IOException: " + iOException.getMessage());
            System.out.println("App location: " + new File(".").getCanonicalPath());
        }
        view();
    }

    private static String toCamel(String s) {
        String str = s;
        str = str.replace('-', ' ');
        str = str.replace('\t', ' ');
        str = str.replace('/', ' ');
        str = str = str.replaceAll(" ", "");
        return str;
    }

    private static void update() throws IOException {
        if (list.isEmpty() && type.equals("")) {
            return;
        }
        PrintStream ps;
        File samFolder = new File("sam");
        if (!samFolder.exists()) {
            samFolder.mkdir();
        }
        //

        map.put(type, (ArrayList<String>) list.clone());

        //
        File typeFolder = new File(samFolder, "" + type);
        typeFolder.mkdir();

        File typeInterface = new File(typeFolder, type + ".java");
        typeInterface.createNewFile();

        ps = new PrintStream(typeInterface);
        ps.println("package com.samasend.types." + type + ";\n"
                + "\n"
                + "/**\n"
                + " *\n"
                + " * @author SamAsEnd\n"
                + " */\n"
                + "public interface " + type + " {");
        for (String string : list) {
            ps.println("\n\tpublic double to" + string + "(); ");
        }
        ps.println("\n}");
        ps.close();

        for (String string : list) {
            File classFile = new File(typeFolder, string + ".java");
            classFile.createNewFile();

            ps = new PrintStream(classFile);

            ps.println("package com.samasend.types." + type + ";\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author SamAsEnd\n"
                    + " */\n"
                    + "public class " + string + " implements " + type + "{\n"
                    + "\n\tprivate double value;\n\n"
                    + "\tpublic " + string + "(double value) throws Exception {\n"
                    + "\t\tthis.value = value;\n"
                    + "\t}\n");
            for (String methods : list) {
                ps.println("\n\t@Override\n\tpublic double to" + methods + "() {\n"
                        + "\t\treturn value;\n"
                        + "\t}\n");
            }
            ps.println("}");
            ps.close();
        }
        list.clear();
    }

    private static void hashMapGenereter() {
        System.out.println("HashMap<String, ArrayList<String>> map = new HashMap<>();");
        System.out.println("ArrayList<String> list;");
        Set<String> keySet = map.keySet();
        for (String string : keySet) {
            System.out.println("list = new ArrayList<>();");
            ArrayList<String> list = map.get(string);
            for (String str : list) {
                System.out.println("list.add(\"" + str + "\");");
            }
            System.out.println("map.put(\"" + string + "\",list);");
        }
        /*for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
         String string = entry.getKey();
         list = entry.getValue();
         System.out.println("list = new ArrayList<>();");
         for (String str : list) {
         System.out.println("list.add(\"" + str + "\");");
         }
         System.out.println("map.put(\"" + string + "\",list);");
         System.out.println("list = "+list);
         }*/
    }

    private static void importGenereter() {
        //import
        //System.out.println("import import com.samasend.types.*;);
        Set<String> keySet = map.keySet();
        for (String string : keySet) {
            System.out.println("import com.samasend.types." + string + ";");
            ArrayList<String> list = map.get(string);
            for (String str : list) {
                System.out.println("import com.samasend.types." + string + "." + str + ";");
            }
        }

    }

    private static void caseGenerater() {
        Set<String> keySet = map.keySet();
        for (String string : keySet) {
            System.out.println("case \"" + string + "\":\n"
                    + "\tswitch (from) {");
            ArrayList<String> list = map.get(string);
            for (String str : list) {
                //
                System.out.println("\t\tcase \"" + str + "\":");

                System.out.println("\t\t\t" + str + " " + str.toLowerCase().charAt(0) + str.substring(1) + " = new " + str + "(value);");
                System.out.println("switch (to) {");
                ArrayList<String> tmp = map.get(string);
                for (String tString : tmp) {

                    System.out.println("\t\t\t\tcase \"" + tString + "\":");
                    System.out.println("\t\t\t\t\tresult = " + str.toLowerCase().charAt(0) + str.substring(1) + ".to" + tString + "();");
                    System.out.println("\t\t\t\t\tbreak;");

                }
                System.out.println("}");
                System.out.println("\t\t\tbreak;");
                //
            }
            System.out.println("\t}\n"
                    + "break;");
        }
        /*for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
         String string = entry.getKey();
         list = entry.getValue();
         System.out.println("list = new ArrayList<>();");
         for (String str : list) {
         System.out.println("list.add(\"" + str + "\");");
         }
         System.out.println("map.put(\"" + string + "\",list);");
         System.out.println("list = "+list);
         }*/
    }

    public static void view() {
        caseGenerater();
    }
}
