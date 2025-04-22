import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {
        String fileName = "src/main/resources/employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) !=null) {
                String[] tokens = line.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.printf("ID: %d | Name: %s | Gross Pay: $%.2f%n", employee.getEmployeeId(), employee.getEmployeeId(), employee.getGrossPay());

                }
            } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
