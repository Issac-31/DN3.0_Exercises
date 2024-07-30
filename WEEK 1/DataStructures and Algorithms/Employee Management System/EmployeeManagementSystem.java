import java.util.Scanner;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < capacity) {
            employees[size] = employee;
            size++;
            System.out.println("Employee added: " + employee);
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by employeeId
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by employeeId
    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;
            System.out.println("Employee deleted with ID: " + employeeId);
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: \n1. Add Employee \n2. Search Employee \n3. Traverse Employees \n4. Delete Employee \n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter employee details (ID, Name, Position, Salary): ");
                    String id = scanner.nextLine();
                    String name = scanner.nextLine();
                    String position = scanner.nextLine();
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    ems.addEmployee(new Employee(id, name, position, salary));
                    break;
                case 2:
                    System.out.println("Enter employee ID to search: ");
                    String searchId = scanner.nextLine();
                    Employee employee = ems.searchEmployee(searchId);
                    if (employee != null) {
                        System.out.println("Employee found: " + employee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    ems.traverseEmployees();
                    break;
                case 4:
                    System.out.println("Enter employee ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ems.deleteEmployee(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
