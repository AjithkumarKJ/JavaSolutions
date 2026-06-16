package org.example.pojo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Employee class represents an employee in an organization with properties and behaviors
 */
public class Employee {
    // Properties
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String department;
    private double salary;
    private LocalDate joinDate;
    private String designation;
    private boolean isActive;

    // Constructor
    public Employee(int employeeId, String firstName, String lastName, String email,
                    String phoneNumber, String department, double salary,
                    LocalDate joinDate, String designation, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.designation = designation;
        this.isActive = isActive;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Behaviors/Methods

    /**
     * Returns the full name of the employee
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Calculate bonus based on salary (10% of annual salary)
     */
    public double calculateBonus() {
        return salary * 0.10;
    }

    /**
     * Give a raise to the employee
     */
    public void giveRaise(double percentage) {
        if (percentage > 0) {
            salary += salary * (percentage / 100);
        }
    }

    /**
     * Update employee's contact information
     */
    public void updateContactInfo(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Promote the employee to a new designation
     */
    public void promote(String newDesignation, double newSalary) {
        this.designation = newDesignation;
        this.salary = newSalary;
    }

    /**
     * Terminate the employee (set isActive to false)
     */
    public void terminateEmployee() {
        this.isActive = false;
    }

    /**
     * Check if employee is eligible for bonus (must be active and have been with company for at least 1 year)
     */
    public boolean isEligibleForBonus() {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        return isActive && joinDate.isBefore(oneYearAgo);
    }

    /**
     * Get years of service
     */
    public long getYearsOfService() {
        return java.time.temporal.ChronoUnit.YEARS.between(joinDate, LocalDate.now());
    }

    /**
     * Return employee details as string
     */
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                ", designation='" + designation + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    /**
     * Check equality based on employeeId
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId;
    }

    /**
     * Hash code based on employeeId
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}

