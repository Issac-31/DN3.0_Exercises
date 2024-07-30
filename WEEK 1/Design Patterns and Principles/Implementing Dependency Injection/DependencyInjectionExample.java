public class DependencyInjectionExample {

    // Step 2: Define Repository Interface
    interface CustomerRepository {
        String findCustomerById(int id);
    }

    // Step 3: Implement Concrete Repository
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(int id) {
            // For demonstration purposes, return a dummy customer
            return "Customer with ID: " + id;
        }
    }

    // Step 4: Define Service Class
    static class CustomerService {
        private CustomerRepository customerRepository;

        // Step 5: Implement Dependency Injection via Constructor
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public String getCustomerDetails(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    // Step 6: Test the Dependency Injection Implementation
    public static void main(String[] args) {
        // Create an instance of the repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the repository into the service via constructor
        CustomerService service = new CustomerService(repository);

        // Use the service to find a customer
        String customerDetails = service.getCustomerDetails(1);
        System.out.println(customerDetails);
    }
}
