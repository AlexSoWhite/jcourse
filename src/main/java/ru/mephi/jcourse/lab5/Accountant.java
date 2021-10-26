package ru.mephi.jcourse.lab5;

public class Accountant {

    private static int getSalary(Employee employee) {
        int salary = 0;
        salary += employee.getAge()*5000;
        switch (employee.getRole()) {
            case STAFF:
                salary += 50000;
                break;
            case MANAGER:
                salary += 100000;
                break;
            case EXECUTIVE:
                salary += 200000;
                break;
        }
        return salary;
    }

    public static void paySalary (Employee employee) {
        int salary = getSalary(employee);
        System.out.println("salary " + salary + " paid to " + employee);
    }

    public static void payPremium (Employee employee) {
        int premiun = getSalary(employee);
        switch (employee.getRole()) {
            case STAFF:
                premiun = premiun * 10 / 100;
                break;
            case MANAGER:
                premiun = premiun * 20 / 100;
                break;
            case EXECUTIVE:
                premiun = premiun * 30 / 100;
                break;
        }
        System.out.println("premium " + premiun + " paid to " + employee);
    }
}
