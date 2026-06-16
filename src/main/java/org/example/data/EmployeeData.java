package org.example.data;

import org.example.pojo.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeData class contains 20 sample employee records
 */
public class EmployeeData {
    private static List<Employee> employees;

    static {
        employees = new ArrayList<>();

        // Initialize 20 employee records
        employees.add(new Employee(1001, "John", "Anderson", "john.anderson@company.com", "555-0101", "IT", 75000, LocalDate.of(2020, 1, 15), "Senior Developer", true));
        employees.add(new Employee(1002, "Sarah", "Bennett", "sarah.bennett@company.com", "555-0102", "HR", 65000, LocalDate.of(2019, 3, 22), "HR Manager", true));
        employees.add(new Employee(1003, "Michael", "Chen", "michael.chen@company.com", "555-0103", "Finance", 80000, LocalDate.of(2018, 6, 10), "Finance Lead", true));
        employees.add(new Employee(1004, "Emily", "Davis", "emily.davis@company.com", "555-0104", "IT", 70000, LocalDate.of(2021, 2, 5), "Junior Developer", true));
        employees.add(new Employee(1005, "David", "Evans", "david.evans@company.com", "555-0105", "Sales", 72000, LocalDate.of(2020, 8, 18), "Sales Executive", true));
        employees.add(new Employee(1006, "Jessica", "Fisher", "jessica.fisher@company.com", "555-0106", "Marketing", 68000, LocalDate.of(2021, 5, 11), "Marketing Specialist", true));
        employees.add(new Employee(1007, "Robert", "Garcia", "robert.garcia@company.com", "555-0107", "IT", 85000, LocalDate.of(2017, 9, 20), "Tech Lead", true));
        employees.add(new Employee(1008, "Linda", "Harris", "linda.harris@company.com", "555-0108", "Operations", 70000, LocalDate.of(2020, 4, 7), "Operations Manager", true));
        employees.add(new Employee(1009, "James", "Johnson", "james.johnson@company.com", "555-0109", "Finance", 75000, LocalDate.of(2019, 11, 15), "Finance Analyst", true));
        employees.add(new Employee(1010, "Patricia", "Kumar", "patricia.kumar@company.com", "555-0110", "HR", 60000, LocalDate.of(2022, 1, 20), "HR Specialist", true));
        employees.add(new Employee(1011, "Christopher", "Lee", "christopher.lee@company.com", "555-0111", "Sales", 76000, LocalDate.of(2020, 6, 30), "Sales Manager", true));
        employees.add(new Employee(1012, "Nancy", "Martinez", "nancy.martinez@company.com", "555-0112", "Marketing", 65000, LocalDate.of(2021, 9, 14), "Marketing Coordinator", true));
        employees.add(new Employee(1013, "Daniel", "Nelson", "daniel.nelson@company.com", "555-0113", "IT", 72000, LocalDate.of(2021, 3, 8), "Software Developer", true));
        employees.add(new Employee(1014, "Barbara", "O'Connor", "barbara.oconnor@company.com", "555-0114", "Operations", 68000, LocalDate.of(2020, 7, 25), "Operations Specialist", true));
        employees.add(new Employee(1015, "Mark", "Patterson", "mark.patterson@company.com", "555-0115", "Finance", 82000, LocalDate.of(2019, 2, 12), "Finance Director", true));
        employees.add(new Employee(1016, "Susan", "Quinn", "susan.quinn@company.com", "555-0116", "Sales", 71000, LocalDate.of(2021, 10, 3), "Sales Representative", true));
        employees.add(new Employee(1017, "Paul", "Robinson", "paul.robinson@company.com", "555-0117", "IT", 73000, LocalDate.of(2020, 5, 19), "Full Stack Developer", true));
        employees.add(new Employee(1018, "Karen", "Smith", "karen.smith@company.com", "555-0118", "Marketing", 67000, LocalDate.of(2022, 2, 8), "Content Manager", true));
        employees.add(new Employee(1019, "Steven", "Thompson", "steven.thompson@company.com", "555-0119", "HR", 63000, LocalDate.of(2021, 12, 1), "Recruiter", true));
        employees.add(new Employee(1020, "Donna", "Wilson", "donna.wilson@company.com", "555-0120", "Operations", 72000, LocalDate.of(2020, 10, 15), "Operations Lead", true));
    }

    /**
     * Get all employees
     */
    public static List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    /**
     * Get employee by ID
     */
    public static Employee getEmployeeById(int employeeId) {
        return employees.stream()
                .filter(emp -> emp.getEmployeeId() == employeeId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Get all employees by department
     */
    public static List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getDepartment().equals(department)) {
                result.add(emp);
            }
        }
        return result;
    }

    /**
     * Get employee count
     */
    public static int getTotalEmployeeCount() {
        return employees.size();
    }

    /**
     * Get total payroll (sum of all salaries)
     */
    public static double getTotalPayroll() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    /**
     * Get average salary
     */
    public static double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    /**
     * Get highest paid employee
     */
    public static Employee getHighestPaidEmployee() {
        return employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    /**
     * Get lowest paid employee
     */
    public static Employee getLowestPaidEmployee() {
        return employees.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    /**
     * Display all employees
     */
    public static void displayAllEmployees() {
        System.out.println("\n========== ALL EMPLOYEES ==========");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("===================================\n");
    }

    /**
     * Get count of employees by department
     */
    public static int countEmployeesByDepartment(String department) {
        return (int) employees.stream()
                .filter(emp -> emp.getDepartment().equals(department))
                .count();
    }
}

