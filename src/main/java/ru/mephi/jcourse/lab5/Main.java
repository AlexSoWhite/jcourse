package ru.mephi.jcourse.lab5;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static String menu = "1.\tВыплата премии женщинам сотрудникам\n" +
            "2.\tВыплата зарплаты сотрудникам определенного департамента\n" +
            "3.\tВыплата премии сотрудникам старше 30, работающим в определенном департаменте \n" +
            "4.\tВыплата зарплаты менеджерам\n" +
            "5.\tВыплата премии стаффу\n" +
            "6.\tВыход\n";

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        ArrayList<Employee> list = Employee.createShortList();
        while (run) {
            System.out.println(menu);
            System.out.print("> ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    list.stream()
                            .filter(employee -> employee.getGender() == Employee.Gender.FEMALE)
                            .forEach(Accountant::payPremium);
                    break;
                case 2:
                    String department = scanner.next();
                    list.stream()
                            .filter(employee -> Objects.equals(employee.getDept(), department))
                            .forEach(Accountant::paySalary);
                    break;
                case 3:
                    department = scanner.next();
                    list.stream()
                            .filter(employee -> Objects.equals(employee.getDept(), department) && employee.getAge() > 30)
                            .forEach(Accountant::payPremium);
                    break;
                case 4:
                    list.stream()
                            .filter(employee -> employee.getRole() == Employee.Role.MANAGER)
                            .forEach(Accountant::paySalary);
                    break;
                case 5:
                    list.stream()
                            .filter(employee -> employee.getRole() == Employee.Role.STAFF)
                            .forEach(Accountant::payPremium);
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("некорректный ввод!");
                    break;
            }
        }
    }
}
