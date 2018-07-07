
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.util.Date;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author SamAsEnd
 */
public class Terminal {

    private File workingDirectory;
    private String userName;
    private String computerName;
    private File homeDirectory;
    private File rootDirectory;
    private BufferedReader cin;
    private boolean win = false;

    public Terminal() {
        init();
        while (true) {
            try {
                accept();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void init() {
        try {
            workingDirectory = new File(".").toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).toFile();
        } catch (IOException ex) {
            workingDirectory = new File(".").getAbsoluteFile();
        }
        userName = System.getenv("USERNAME");
        computerName = System.getenv("COMPUTERNAME");
        homeDirectory = new File(System.getenv("HOMEDRIVE") + System.getenv("HOMEPATH"));
        rootDirectory = new File(System.getenv("HOMEDRIVE") + File.separator);
        cin = new BufferedReader(new InputStreamReader(System.in));
        win = (System.getenv("OS").toLowerCase().contains("win"));
    }

    private void accept() throws IOException {
        System.out.print(userName + "@" + computerName + ": " + getPathAsString() + " $ ");
        String command = cin.readLine();
        command = command.trim();
        String[] splited;
        splited = command.split(" ");
        parser(splited);
    }

    private String getPathAsString() {
        try {
            return relativePathAsString(workingDirectory);
        } catch (Exception ex) {
            return absolutePathAsString(workingDirectory);
        }
    }

    private String absolutePathAsString(File f) {
        try {
            return f.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).toString();
        } catch (IOException ex) {
            return f.toPath().toAbsolutePath().toString();
        }
    }

    private String relativePathAsString(File f) throws Exception {
        Path p = f.toPath();
        if (!p.startsWith(homeDirectory.toPath())) {
            throw new Exception();
        }
        Path rel = homeDirectory.toPath().relativize(p);
        return "~ " + rel.toString();
    }

    private void parser(String[] cmd) throws IOException {

        //<editor-fold defaultstate="collapsed" desc="to handle the " fucked up shit"">
        Stack<String> stack = new Stack<>();
        boolean open = false;
        for (int i = 1; i < cmd.length; i++) {
            String string = cmd[i];
            if (open) {
                if (string.endsWith("\"") || string.endsWith("'")) {
                    String pop = stack.pop();
                    pop = (pop + " " + string.substring(0, string.length() - 1));
                    stack.push(pop);
                    open = false;
                } else {
                    String pop = stack.pop();
                    pop = (pop + " " + string);
                    stack.push(pop);
                }
            } else {
                if (string.startsWith("\"") || string.startsWith("'")) {
                    stack.push(string.substring(1));
                    open = true;
                } else {
                    stack.push(string);
                }
            }
        }
        //</editor-fold>

        String[] command = new String[stack.size()];
        command = stack.toArray(command);

        switch (cmd[0]) {
            case "help":
                help();
                break;
            case "exit":
                exit();
                break;
            case "clear":
                clear(command);
                break;
            case "pwd":
                pwd(command);
                break;
            case "cd":
                cd(command);
                break;
            case "ls":
                ls(command);
                break;
            case "mkdir":
                mkdir(command);
                break;
            case "touch":
                touch(command);
                break;
            case "cat":
                cat(command);
                break;
            case "":
                break;
            default:
                System.out.println("Not supported");
        }
    }

    private void exec(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }

    //<editor-fold defaultstate="collapsed" desc="Commands">
    
    private void help() {
        System.out.println(
                "help\n"+
                "exit\n"+
                "clear\n"+
                "pwd\n"+
                "cd\n"+
                "ls\n"+
                "mkdir\n"+
                "touch\n"+
                "cat\n");
    }
    
    private void pwd(String[] args) {
        if (args.length >= 1) {
            String command = args[1].trim().toLowerCase();
            if ("-v".equals(command) || "--version".equals(command)) {
                System.out.println("\n"
                        + "\t pwd\n"
                        + "\t=====\n"
                        + "\t\t-v,--version\n"
                        + "\t\t\tPrint Working Diroctory\n\n");
            }
        } else {
            System.out.println(absolutePathAsString(workingDirectory));
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void clear(String[] args) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");

        /*NOT WORKING
         * try {
         * if (win) {
         * exec("CLS");
         * } else {
         * exec("clear");
         * }
         * } catch (IOException iOException) {
         * System.err.println(iOException);
         * }*/

    }

    private void cd(String[] args) {
        if (args.length == 0 || ((args.length == 1) && ("~".equals(args[0].trim())))) {
            try {
                workingDirectory = homeDirectory.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).toFile();
            } catch (IOException ex) {
                workingDirectory = homeDirectory;
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (".".equals(args[0].trim())) {
        } else if ("/".equals(args[0].trim())) {
            try {
                workingDirectory = rootDirectory.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).toFile();
            } catch (IOException ex) {
                workingDirectory = rootDirectory;
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if ("..".equals(args[0].trim())) {
            Path parent;
            try {
                parent = workingDirectory.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).getParent();
            } catch (IOException ex) {
                parent = workingDirectory.toPath().getParent();
                JOptionPane.showMessageDialog(null, ex);
            }
            if (parent.toFile().exists()) {
                workingDirectory = parent.toFile();
            }
        } else {
            File newFile;
            String cmd = "";
            // combine if the args have a space eg.   C:\ Us er \
            for (int i = 0; i < args.length; i++) {
                //newPath += (File.separator + args[i].trim());
                cmd += args[i].trim();
            }
            // check if the args is absolute path eg.   cd C:\Users
            newFile = new File(cmd);
            if (newFile.exists()) {
                workingDirectory = newFile;
                return;
            }

            // check if the args is absolute path and replace with home pathe eg.   cd ~/Desktop
            cmd = cmd.replace("~", homeDirectory.toString());
            newFile = new File(cmd);
            if (newFile.exists()) {
                try {
                    workingDirectory = newFile.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).toFile();
                } catch (IOException ex) {
                    workingDirectory = newFile.getAbsoluteFile();
                    JOptionPane.showMessageDialog(null, ex);
                }
                return;
            }

            //  check if the user use classic cd eg cd to Sam\As\End
            String newPath = absolutePathAsString(workingDirectory);
            if (!newPath.endsWith(File.separator)) {
                newPath += File.separator;
            }
            newPath += cmd;
            newFile = new File(newPath);
            if (newFile.exists()) {
                workingDirectory = newFile;
                return;
            }
            System.out.println("path \"" + cmd + "\" doesn't exist\n");
        }
    }

    private void ls(String[] args) {
        boolean showHidden = false;
        for (int i = 0; i < args.length; i++) {
            String cmd = args[i];
            if ("-l".equals(cmd)) {
                showHidden = true;
            }
        }
        File[] files = workingDirectory.listFiles();
        for (File file : files) {
            Path path = file.toPath();
            String hiddenInfo = "";
            if (showHidden) {
                boolean winHidden = false;
                try {
                    winHidden = Files.readAttributes(path, DosFileAttributes.class).isHidden();
                } catch (Exception ignore) {
                }
                if (file.isHidden() || winHidden) {
                    hiddenInfo = String.format("%8s", "[hidden]");
                } else {
                    hiddenInfo = String.format("%8s", "");
                }
            } else {
                boolean winHidden = false;
                try {
                    winHidden = Files.readAttributes(path, DosFileAttributes.class).isHidden();
                } catch (Exception ignore) {
                }
                if (file.isHidden() || winHidden) {
                    continue;
                }
            }
            FileTime lastModifiedTime;
            try {
                lastModifiedTime = Files.getLastModifiedTime(path, LinkOption.NOFOLLOW_LINKS);
                DateFormat dateFormat = DateFormat.getInstance();
                System.out.printf("%17S  ", dateFormat.format(new Date(lastModifiedTime.toMillis())));
            } catch (IOException ignore) {
                System.out.printf("%17S  ", "");
            }
            if (file.isFile()) {
                System.out.printf("%5s %s", "", hiddenInfo);
                System.out.printf("   %10s", fileSizeFormat(file.length()));
                // throws Exception System.out.printf("   %10s", fileSizeFormat(Files.size(path)));
            } else {
                System.out.printf("%5s %s", "<dir>", hiddenInfo);
                System.out.printf("   %10s", "");
            }
            System.out.printf("\t%s\n", file.toPath().getFileName().toString());
        }
    }

    private String fileSizeFormat(long size) {
        String format = "%-4.3f %4s";
        String str;
        long Kb = 1024;
        long Mb = Kb * 1024;
        long Gb = Mb * 1024;
        long Tb = Gb * 1024;

        if (size >= Gb) {
            str = String.format(format, ((float) size / Gb), "Gb");
        } else if (size >= Mb) {
            str = String.format(format, ((float) size / Mb), "Mb");
        } else if (size >= Kb) {
            str = String.format(format, ((float) size / Kb), " Kb");
        } else {
            str = String.format(format, ((float) size / 1), "byte");
        }
        return str;
    }

    private void mkdir(String[] args) {
        boolean verbose = false;
        for (String string : args) {
            if ("--verbose".equals(string)) {
                verbose = true;
            }
        }
        File f;
        for (int i = 0; i < args.length; i++) {
            String string = args[i];
            f = new File(workingDirectory, string);
            if (f.exists()) {
                System.out.println(string + " already exist");
                continue;
            }
            if (f.mkdir()) {
                if (verbose) {
                    System.out.println(string + " created");
                }
            } else {
                if (verbose) {
                    System.out.println(string + " error");
                }
            }
        }
    }

    private void touch(String[] args) {
        boolean verbose = false;
        for (String string : args) {
            if ("--verbose".equals(string)) {
                verbose = true;
            }
        }
        File f;
        for (int i = 0; i < args.length; i++) {
            String string = args[i];
            f = new File(workingDirectory, string);
            if (f.exists()) {
                System.out.println(string + " already exist");
                continue;
            }
            boolean created;
            try {
                created = f.createNewFile();
            } catch (IOException ignore) {
                created = false;
            }

            if (created) {
                if (verbose) {
                    System.out.println(string + " created");
                }
            } else {
                if (verbose) {
                    System.out.println(string + " error");
                }
            }
        }
    }

    private void cat(String[] command) {
    }
    //</editor-fold>

    
}
