import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the employee file to process: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFileName = scanner.nextLine();

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) !=null) {
                String[] tokens = line.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                employees.add(employee);

                }
            } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        if (outputFileName.endsWith(".csv")) {
            writeCsv(employees, outputFileName);
        } else if (outputFileName.endsWith(".json")) {
            writeJson(employees, outputFileName);
        } else {
            System.out.println("Unsupported file format. Please use .csv or .json extension.");
        }
    }
    private static void writeCsv(List<Employee> employees, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write("id|name|gross pay");
            writer.newLine();
            for (Employee employee : employees) {
                writer.write(employee.getEmployeeId() + "|" + employee.getName() + "|" + String.format("%.2f", employee.getGrossPay()));
                writer.newLine();
            }
            System.out.println("Payroll CSV file created successfully: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
    private static void writeJson(List<Employee> employees, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write("[");
            writer.newLine();
            for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            writer.write("  { \"id\": " + employee.getEmployeeId() +
                    ", \"name\": \"" + employee.getName() +
                    "\", \"grossPay\": " + String.format("%.2f", employee.getGrossPay()) + " }");
            if (i < employees.size() - 1) {
                writer.write(",");
            }
            writer.newLine();
            }
            writer.write("]");

            System.out.println("Payroll JSON file created successfully: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
}
