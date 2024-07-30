import java.util.ArrayList;
import java.util.List;

// Step 2: Define the Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Step 4: Define the Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Step 3: Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

// Step 5: Implement Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp: Stock " + stockName + " is now $" + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp: Stock " + stockName + " is now $" + price);
    }
}

// Step 6: Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create a stock market and observers
        StockMarket stockMarket = new StockMarket("ABC", 100.00);
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price and notify observers
        System.out.println("Changing stock price...");
        stockMarket.setPrice(105.00);

        // Deregister an observer
        stockMarket.deregisterObserver(mobileApp);

        // Change stock price and notify remaining observers
        System.out.println("Changing stock price...");
        stockMarket.setPrice(110.00);
    }
}
