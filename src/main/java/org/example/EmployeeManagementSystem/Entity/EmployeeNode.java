package org.example.EmployeeManagementSystem.Entity;

import org.example.EmployeeManagementSystem.Enums.Designation;

import java.util.ArrayList;
import java.util.List;

public class EmployeeNode implements Employee{
    private final int id;
    private final String name;
    private Employee manager;
    private Designation designation;
    private List<Employee> subordinates;

    public EmployeeNode(int id, String name, Designation designation){
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.subordinates = new ArrayList<>();
    }

    public EmployeeNode(int id, String name, Designation designation, Employee manager){
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.manager = manager;
        this.subordinates = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Employee getManager() {
        return manager;
    }

    @Override
    public void setManager(Employee manager) {
    this.manager = manager;
    }

    @Override
    public Designation getDesignation() {
        return designation;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
        employee.setManager(this);
    }
}
