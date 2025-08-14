package Design_Patterns_and_Principles.Exercise1;

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log.");
        logger2.log("This is the second log.");

        if (logger1 == logger2) {
            System.out.println("Only one instance exists. Singleton verified.");
        } else {
            System.out.println("Different instances exist. Singleton failed.");
        }
    }
}
