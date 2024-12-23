package org.example.EmployeeManagementSystem;

import org.example.EmployeeManagementSystem.Entity.EmployeeNode;
import org.example.EmployeeManagementSystem.Entity.EmployeeTree;
import org.example.EmployeeManagementSystem.Enums.Designation;

public class Main {
    public static void main(String[] args) {
        EmployeeNode ceo = new EmployeeNode(1, "Alice", Designation.CEO);
        EmployeeNode manager1 = new EmployeeNode(2, "Bob", Designation.MANAGER);
        EmployeeNode manager2 = new EmployeeNode(3, "Charlie", Designation.MANAGER);
        EmployeeNode emp1 = new EmployeeNode(4, "David", Designation.EMPLOYEE);
        EmployeeNode emp2 = new EmployeeNode(5, "Eve", Designation.EMPLOYEE);
        EmployeeNode emp3 = new EmployeeNode(6, "Frank", Designation.EMPLOYEE);

        ceo.addSubordinate(manager1);
        ceo.addSubordinate(manager2);

        manager1.addSubordinate(emp1);
        manager2.addSubordinate(emp2);
        manager2.addSubordinate(emp3);

        EmployeeTree employeeTree = new EmployeeTree(ceo);

//        employeeTree.printHierarchy();
        String relation = employeeTree.findRelationship(5,6);
        System.out.println(relation);
    }
}