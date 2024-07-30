public class ProxyPatternExample {

    // Step 2: Define the Subject Interface
    interface Image {
        void display();
    }

    // Step 3: Implement Real Subject Class
    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading image from server: " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Step 4: Implement Proxy Class
    static class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); // Lazy initialization
            }
            realImage.display();
        }
    }

    // Step 5: Test the Proxy Implementation
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image is loaded and displayed on the first access
        image1.display();
        // Image is not loaded again, just displayed
        image1.display();

        // Image is loaded and displayed on the first access
        image2.display();
    }
}
