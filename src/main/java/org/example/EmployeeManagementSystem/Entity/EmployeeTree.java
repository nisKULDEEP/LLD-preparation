package org.example.EmployeeManagementSystem.Entity;

public class EmployeeTree {
    private final EmployeeNode head;
    public EmployeeTree(EmployeeNode node){
        this.head = node;
    }

    public Employee findEmployeeById(int id) {
        return findEmployeeByIdHelper(head, id);
    }

    public void printHierarchy() {
        printHierarchyHelper(head, 0);
    }

    private boolean isManager(Employee manager, Employee employee) {
        while (employee != null) {
            employee = employee.getManager();
            if (employee == manager) return true;
        }
        return false;
    }

    public String findRelationship(int id1, int id2) {
        Employee employee1 = findEmployeeById(id1);
        Employee employee2 = findEmployeeById(id2);

        if (employee1 == null || employee2 == null) return "One or both employees not found.";

        if (isManager(employee1, employee2)) return employee1.getName() + " is a " + employee1.getDesignation() + " of " + employee2.getName();

        return "No direct relationship.";
    }

    private void printHierarchyHelper(Employee current, int level) {
        if (current == null) return;

        System.out.println("  ".repeat(level) + current.getName() + " (ID: " + current.getId() + ")");
        for (Employee subordinate : ((EmployeeNode) current).getSubordinates()) {
            printHierarchyHelper(subordinate, level + 1);
        }
    }

    private Employee findEmployeeByIdHelper(Employee current, int id) {
        if (current == null) return null;
        if (current.getId() == id) return current;

        for (Employee subordinate : ((EmployeeNode) current).getSubordinates()) {
            Employee found = findEmployeeByIdHelper(subordinate, id);
            if (found != null) return found;
        }

        return null;
    }

//    public EmployeeNode getEmployee();
//    public Boolean isExist(EmployeeNode employeeNode);
//    public void delete(EmployeeNode employeeNode);
//    public void insertEmployee(EmployeeNode employeeNode);

}
