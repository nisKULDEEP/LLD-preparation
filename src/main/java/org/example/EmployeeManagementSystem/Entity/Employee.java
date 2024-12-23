package org.example.EmployeeManagementSystem.Entity;

import org.example.EmployeeManagementSystem.Enums.Designation;

public interface Employee {

    int getId();
    String getName();
    Employee getManager();
    void setManager(Employee manager);
    Designation getDesignation();
}
