package com.samasend;

public class Tag {

    int idI = 0;
    String nameString = null;
    String discString = null;
    boolean selfCloseB = false;
    boolean newB = false;
    boolean deprecatedB = false;
    String exampleString = null;

    public Tag(String tag) throws Exception {
        String[] t = tag.split(" ");
        nameString = t[0].replace('<', ' ').replace('>', ' ').replace("New", " ").trim();
        if("".equals(nameString)) {
            throw new Exception("empty");
        }
        discString = "";
        for (int i = 1; i < t.length; i++) {
            discString += (" " + t[i]);
        }
        discString = discString.trim();
        selfCloseB = t[0].contains("/");
        newB = t[0].contains("New");
        deprecatedB = tag.contains("Not supported in HTML5.");
        exampleString = "";
    }

    public String toDataBaseInsert() {
        return String.format("INSERT INTO `tags`(`name`, `disc`,`selfClose`, `new`, `deprecated`, `example`) "
                + "VALUES ('%s','%s',%s,%s,%s,'%s')",
                nameString, discString, Boolean.toString(selfCloseB), Boolean.toString(newB), Boolean.toString(deprecatedB), exampleString);
    }

}
