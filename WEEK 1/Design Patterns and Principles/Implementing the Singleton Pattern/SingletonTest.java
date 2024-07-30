public class SingletonTest {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Logger is singleton. Both references point to the same instance.");
        } else {
            System.out.println("Logger is not singleton. Different instances created.");
        }

        // Use the logger instance to log messages
        logger1.log("This is a test log message.");
        logger2.log("This is another test log message.");
    }
}
