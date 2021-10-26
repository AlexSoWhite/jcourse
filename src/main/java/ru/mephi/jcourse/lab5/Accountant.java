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
        System.out.println("salary " + salary + " paid to " + employee.getGivenName() + " " + employee.getSurName());
    }

    public static void payPremium (Employee employee) {
        int premium = getSalary(employee);
        System.out.println("premium " + premium*employee.getRole().getMult() + " paid to " + employee.getGivenName() + " " + employee.getSurName());
    }
}
