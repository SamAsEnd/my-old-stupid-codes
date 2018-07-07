
class TestMyException extends Exception {

    public TestMyException(String msg) {
        super(msg);
    }

    public static void main(String args[]) {
        TestMyException tt = new TestMyException("invalid");
        float x = 1, y = 5;
        try {

            float z = x - y;
            float r = 10 / z;
            if (z == 0) {
                throw new TestMyException("too small number");
            }
        } catch (TestMyException me) {
            System.out.println("caught my exception");
            System.out.println(me.getMessage());
        } finally {
            System.out.println("from finally");
        }
    }
}