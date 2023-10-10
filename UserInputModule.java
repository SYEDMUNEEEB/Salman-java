import java.util.Scanner;

public class UserInputModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gather user input for the number of employees
        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        // Initialize an array to store employee data
        Employee[] employees = new Employee[numEmployees];

        // Gather employee details
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();  // Consume newline character

            // Create an Employee object and store it in the array
            employees[i] = new Employee(name, salary);
        }

        // Close the scanner
        scanner.close();

        // Pass the employee data to the Data Validation Module
        DataValidationModule.validateData(employees);
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class DataValidationModule {
    public static void validateData(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.getSalary() < 0) {
                System.out.println("Error: Salary cannot be negative for employee " + employee.getName());
            }
            // Add more validation checks as needed
        }
    }
}
