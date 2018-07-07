
public class TestCustomer {

    public static void main(String[] args) {

        CustomerInformation ci = new CustomerInformation();
        System.out.println(ci.login());
        
        Employee e = new Employee();
        Student s = new Student();

        System.out.println(ci.request());
        System.out.println(e.request());
        System.out.println(s.request());

        System.out.println();

        // array

        int numbers[] = new int[3];

        // declar & array create
        CustomerInformation informations[] = new CustomerInformation[3];

        // init
        /*
         for (int i = 0; i < informations.length; i++) {
         informations[i] = new CustomerInformation();
         }
         */


        informations[0] = new CustomerInformation("Hana", 'F', "1970-4-28");
        informations[1] = new CustomerInformation("Samson", 'M', "2014-4-28");
        informations[2] = new CustomerInformation("Kidus", 'M', "2012-4-28");

        for (int i = 0; i < informations.length; i++) {
            System.out.println( informations[i].getName()  + "\t" + informations[i].getSex() + "\t" + informations[i].getBirthDate());
        }
    }
}
