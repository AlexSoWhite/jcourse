package ru.mephi.jcourse.lab5;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.*;
public class LambdaProg {

    final static ArrayList<Employee> list = Employee.createShortList();

    public static void main(String[] args) {

        System.out.println("\nConsumer");

        Consumer<Employee> cons = t -> System.out.println(t.getAge() + " " + t.getRole().toString());
        list.forEach(cons);

        System.out.println("\nFunction");
        Function<Employee, String> func = t -> t.getRole().toString();
        System.out.println(func.apply(list.get(3)));

        System.out.println("\nSupplier");
        Supplier<Employee> sup = () -> new Employee.Builder()
                .setGender(Gender.MALE)
                .setGivenName("BOB")
                .setSurName("Ross")
                .setRole(Role.MANAGER)
                .build();

        list.add(sup.get());
        list.forEach(Accountant::paySalary);

        System.out.println("\nBiPredicate");
        BiPredicate<Employee, String> bi = (t, u) -> Objects.equals(t.getGivenName(), u);

        System.out.println(bi.test(list.get(0), "Олег"));
    }
}
