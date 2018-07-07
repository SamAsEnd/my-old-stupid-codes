/**
 *
 * @author SamAsEnd
 */
public class SamAsEndTerminal {

    private static String VERSION = "Sam As End Terminal Verion 1.0\n";
        
    /**
     * main
     * @param args 
     */
    public static void main(String[] args) {
        if(args.length >= 1) {
            for (String arg : args) {
                String command = arg.trim();
                if(command.startsWith("-v") || command.startsWith("--version")) {
                    System.out.println(VERSION);
                    System.exit(0);
                }
            }
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Terminal();
            }
        }).start();
    }

    /**
     * @return the VERSION
     */
    public static String getVERSION() {
        return VERSION;
    }
}
