/**
 *
 * @author Sam As End
 */
public class HelloWorld {
    public static void main(String[] args){
        // single line comment
        /* multiple
          line comment
        */
        /**
          java doc
         */
        /*  to include amharic use unicode utf */
        /*
         * ha '\u1200'
         */
        System.out.println("Hello fucked up world!!");
        char ch = '\u1200';
        for(int i=0;i<200;i++) {
            System.out.print(ch);
            if(i%7==6) {
                System.out.print("\n");
            }
            /*
             * to bad we couldn't see the charcters
             * but there are workin
             */
            /*  bye bye bye*/
        }
        
    }
}
