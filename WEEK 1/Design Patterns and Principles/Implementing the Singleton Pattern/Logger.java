public class Logger {
    // Private static instance of the Logger class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize resources or configurations if needed
    }

    // Public static method to get the single instance of Logger
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
