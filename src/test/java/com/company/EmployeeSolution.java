package com.company;

import java.util.Scanner;

/**
 *
 */
public class EmployeeSolution {
    static void OutputCommonManager(int count, Scanner in) {
        String firstSelected = in.nextLine();
        String secondSelected = in.nextLine();
        String topManager = in.nextLine();

        Company company = new Company(new Employee(topManager));

        for(int i=0; i < count - 2; i++) {
            String[] employees = in.nextLine().split(" ");
            company.addEmployee(employees[0], employees[1]);
        }

        System.out.println(company);
        // use the selected for search
    }


    static class Company {
        private Employee root;

        public Company(Employee root) {
            this.root = root;
        }

        public void addEmployee(String manager, String employee) {
            addToEmployee(root, manager, employee);
        }

        public boolean addToEmployee(Employee current, String manager, String employee) {
            if( current.getName().equals(manager)) {
                current.addEmployee(employee);
                return true;
            } else {
                boolean added = addToEmployee(current.getManagesEmployeeLeft(), manager, employee);
                if( added)
                    return true;
                else
                    return addToEmployee(current.getManagesEmployeeRight(), manager, employee);
            }
        }

        @Override
        public String toString() {
            return "Company{" +
                    "root=" + root +
                    '}';
        }
    }

    static class Employee {
        private String name;
        private Employee managesEmployeeLeft;
        private Employee managesEmployeeRight;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Employee getManagesEmployeeLeft() {
            return managesEmployeeLeft;
        }

        public Employee getManagesEmployeeRight() {
            return managesEmployeeRight;
        }

        public void addEmployee(String employee) {
            if( managesEmployeeLeft == null) {
                managesEmployeeLeft = new Employee(employee);
            } else {
                managesEmployeeRight = new Employee(employee);
            }
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", managesEmployeeLeft=" + managesEmployeeLeft +
                    ", managesEmployeeRight=" + managesEmployeeRight +
                    '}';
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int _count;
        _count = Integer.parseInt(in.nextLine());

        OutputCommonManager(_count, in);
    }



}
