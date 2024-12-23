package org.example.EmployeeManagementSystem;

import org.example.EmployeeManagementSystem.Entity.EmployeeNode;
import org.example.EmployeeManagementSystem.Entity.EmployeeTree;
import org.example.EmployeeManagementSystem.Enums.Designation;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTreeTest {
    @Test
    public void testFindRelationship() {
        EmployeeNode ceo = new EmployeeNode(1, "Alice", Designation.CEO);
        EmployeeNode manager1 = new EmployeeNode(2, "Bob", Designation.MANAGER);
        ceo.addSubordinate(manager1);

        EmployeeTree tree = new EmployeeTree(ceo);
        assertEquals("Alice is a CEO of Bob", tree.findRelationship(1, 2));
        assertEquals("No direct relationship.", tree.findRelationship(2, 1));
    }
}
