package org.example.functions;

import org.example.data.EmployeeData;
import org.example.pojo.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * EmployeeJava8Features class demonstrates Java 8 features using Employee objects
 * Features covered: Lambda expressions, Stream API, Functional Interfaces, Optional, Method References, etc.
 */
public class EmployeeJava8Features {

    /**
     * 1. Lambda Expression - Filter employees by salary
     * Demonstrates: Basic lambda expression with filtered stream
     */
    public static void demonstrateFilterWithLambda() {
        System.out.println("\n========== 1. LAMBDA - Filter Employees by Salary ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        // Using lambda expression to filter employees earning more than 75000
        employees.stream()
                .filter(emp -> emp.getSalary() > 75000)
                .forEach(emp -> System.out.println(emp.getFullName() + " - $" + emp.getSalary()));
    }

    /**
     * 2. Stream API - Map and Collect
     * Demonstrates: Transforming employee objects to a list of names
     */
    public static void demonstrateMapAndCollect() {
        System.out.println("\n========== 2. STREAM API - Map and Collect ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        // Map each employee to their full name and collect to list
        List<String> employeeNames = employees.stream()
                .map(Employee::getFullName)
                .collect(Collectors.toList());

        employeeNames.forEach(System.out::println);
    }

    /**
     * 3. Method References - Print employees
     * Demonstrates: Using method references instead of lambda expressions
     */
    public static void demonstrateMethodReferences() {
        System.out.println("\n========== 3. METHOD REFERENCES - Print Employees ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        // Using method reference :: instead of lambda
        employees.forEach(System.out::println);
    }

    /**
     * 4. Optional - Get employee by ID safely
     * Demonstrates: Using Optional to handle null values
     */
    public static void demonstrateOptional() {
        System.out.println("\n========== 4. OPTIONAL - Get Employee by ID Safely ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        int searchId = 1005;
        Optional<Employee> employee = employees.stream()
                .filter(emp -> emp.getEmployeeId() == searchId)
                .findFirst();

        employee.ifPresent(emp -> System.out.println("Found: " + emp.getFullName()));
        employee.ifPresentOrElse(
                emp -> System.out.println("Employee ID " + searchId + " exists"),
                () -> System.out.println("Employee not found")
        );
    }

    /**
     * 5. Reduce - Calculate total salary
     * Demonstrates: Using reduce to aggregate values
     */
    public static void demonstrateReduce() {
        System.out.println("\n========== 5. REDUCE - Calculate Total Payroll ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println("Total Payroll: $" + totalSalary);
    }

    /**
     * 6. Collectors.groupingBy - Group employees by department
     * Demonstrates: Using collectors to group stream elements
     */
    public static void demonstrateGroupingBy() {
        System.out.println("\n========== 6. COLLECTORS.GROUPINGBY - Group by Department ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList.size() + " employees");
            empList.forEach(emp -> System.out.println("  - " + emp.getFullName()));
        });
    }

    /**
     * 7. Collectors.toMap - Create employee map by ID
     * Demonstrates: Collecting stream to a Map
     */
    public static void demonstrateToMap() {
        System.out.println("\n========== 7. COLLECTORS.TOMAP - Create Employee Map ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        Map<Integer, String> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getEmployeeId, Employee::getFullName));

        employeeMap.forEach((id, name) -> System.out.println("ID: " + id + " - " + name));
    }

    /**
     * 8. Distinct and Sorted - Get unique departments sorted
     * Demonstrates: Using distinct and sorted methods
     */
    public static void demonstrateDistinctAndSorted() {
        System.out.println("\n========== 8. DISTINCT & SORTED - Departments ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * 9. Limit and Skip - Pagination example
     * Demonstrates: Using limit and skip for pagination
     */
    public static void demonstrateLimitAndSkip() {
        System.out.println("\n========== 9. LIMIT & SKIP - Pagination (Skip 2, Limit 5) ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        employees.stream()
                .skip(2)
                .limit(5)
                .forEach(emp -> System.out.println(emp.getFullName() + " - " + emp.getDepartment()));
    }

    /**
     * 10. FlatMap - Flatten department list into single stream
     * Demonstrates: Using flatMap for flattening
     */
    public static void demonstrateFlatMap() {
        System.out.println("\n========== 10. FLATMAP - All Designations ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        employees.stream()
                .map(emp -> Arrays.asList(emp.getDesignation(), emp.getDepartment()))
                .flatMap(List::stream)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 11. Custom Collector - Count employees in each department
     * Demonstrates: Using custom mapping with collectors
     */
    public static void demonstrateCustomCollector() {
        System.out.println("\n========== 11. CUSTOM COLLECTOR - Employee Count by Department ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        deptCount.forEach((dept, count) -> System.out.println(dept + ": " + count + " employees"));
    }

    /**
     * 12. Stream Statistics - Get salary statistics
     * Demonstrates: Using DoubleSummaryStatistics
     */
    public static void demonstrateStreamStatistics() {
        System.out.println("\n========== 12. STREAM STATISTICS - Salary Analysis ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();

        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: $" + String.format("%.2f", stats.getAverage()));
        System.out.println("Min: $" + stats.getMin());
        System.out.println("Max: $" + stats.getMax());
        System.out.println("Sum: $" + stats.getSum());
    }

    /**
     * 13. anyMatch, allMatch, noneMatch - Matching predicates
     * Demonstrates: Boolean matching operations on streams
     */
    public static void demonstrateMatching() {
        System.out.println("\n========== 13. MATCHING - Predicate Operations ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        boolean anyAbove80k = employees.stream()
                .anyMatch(emp -> emp.getSalary() > 80000);
        System.out.println("Any employee earning above $80,000? " + anyAbove80k);

        boolean allActive = employees.stream()
                .allMatch(Employee::isActive);
        System.out.println("All employees are active? " + allActive);

        boolean noneInactive = employees.stream()
                .noneMatch(emp -> !emp.isActive());
        System.out.println("No inactive employees? " + noneInactive);
    }

    /**
     * 14. forEach with index using IntStream
     * Demonstrates: Iterating with index using IntStream
     */
    public static void demonstrateForEachWithIndex() {
        System.out.println("\n========== 14. FOREACH WITH INDEX - List Employees ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        System.out.println("First 5 employees:");
        employees.stream()
                .limit(5)
                .forEach(emp -> System.out.println((employees.indexOf(emp) + 1) + ". " + emp.getFullName()));
    }

    /**
     * 15. Sorting by multiple attributes
     * Demonstrates: Complex sorting using comparators
     */
    public static void demonstrateComplexSorting() {
        System.out.println("\n========== 15. COMPLEX SORTING - By Department then Salary ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparingDouble(Employee::getSalary).reversed())
                .limit(10)
                .forEach(emp -> System.out.println(emp.getDepartment() + " - " + emp.getFullName() + " - $" + emp.getSalary()));
    }

    /**
     * 16. Partition employees - Active vs Inactive
     * Demonstrates: Using partitioningBy collector
     */
    public static void demonstratePartitioning() {
        System.out.println("\n========== 16. PARTITIONING - Active vs Inactive Employees ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isActive));

        System.out.println("Active Employees: " + partitioned.get(true).size());
        System.out.println("Inactive Employees: " + partitioned.get(false).size());
    }

    /**
     * 17. Find operations - findFirst and findAny
     * Demonstrates: Finding specific elements in stream
     */
    public static void demonstrativeFindOperations() {
        System.out.println("\n========== 17. FIND OPERATIONS - First and Any ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        Optional<Employee> firstITEmployee = employees.stream()
                .filter(emp -> "IT".equals(emp.getDepartment()))
                .findFirst();

        firstITEmployee.ifPresent(emp -> System.out.println("First IT Employee: " + emp.getFullName()));

        Optional<Employee> anyHighEarner = employees.stream()
                .filter(emp -> emp.getSalary() > 80000)
                .findAny();

        anyHighEarner.ifPresent(emp -> System.out.println("Any high earner: " + emp.getFullName()));
    }

    /**
     * 18. Stream of employees with bonus calculation
     * Demonstrates: Mapping with custom calculations
     */
    public static void demonstrateMapWithCalculation() {
        System.out.println("\n========== 18. MAP WITH CALCULATION - Bonus Calculation ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        employees.stream()
                .filter(emp -> emp.isEligibleForBonus())
                .limit(5)
                .forEach(emp -> System.out.println(emp.getFullName() + " - Bonus: $" +
                        String.format("%.2f", emp.calculateBonus())));
    }

    /**
     * 19. Chaining operations - Complex multi-step operation
     * Demonstrates: Multiple stream operations chained together
     */
    public static void demonstrateChainingOperations() {
        System.out.println("\n========== 19. CHAINING OPERATIONS - Complex Stream ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        List<String> result = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .filter(emp -> emp.getSalary() > 70000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(emp -> emp.getFullName() + " ($" + emp.getSalary() + ")")
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    /**
     * 20. Using peek for debugging stream operations
     * Demonstrates: Using peek to inspect intermediate values
     */
    public static void demonstratePeek() {
        System.out.println("\n========== 20. PEEK - Debugging Stream Operations ==========");
        List<Employee> employees = EmployeeData.getAllEmployees();

        List<String> names = employees.stream()
                .filter(emp -> emp.getSalary() > 75000)
                .peek(emp -> System.out.println("Processing: " + emp.getFullName()))
                .map(Employee::getFullName)
                .collect(Collectors.toList());

        System.out.println("\nTotal filtered: " + names.size());
    }

    /**
     * Main method to run all demonstrations
     */
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   JAVA 8 FEATURES DEMONSTRATION");
        System.out.println("============================================");

        demonstrateFilterWithLambda();
        demonstrateMapAndCollect();
        demonstrateMethodReferences();
        demonstrateOptional();
        demonstrateReduce();
        demonstrateGroupingBy();
        demonstrateToMap();
        demonstrateDistinctAndSorted();
        demonstrateLimitAndSkip();
        demonstrateFlatMap();
        demonstrateCustomCollector();
        demonstrateStreamStatistics();
        demonstrateMatching();
        demonstrateForEachWithIndex();
        demonstrateComplexSorting();
        demonstratePartitioning();
        demonstrativeFindOperations();
        demonstrateMapWithCalculation();
        demonstrateChainingOperations();
        demonstratePeek();

        System.out.println("\n============================================");
        System.out.println("   DEMONSTRATION COMPLETE");
        System.out.println("============================================\n");
    }
}

