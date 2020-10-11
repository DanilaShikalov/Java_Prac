package com.company.Practice9;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();
        for (int i = 0; i < 50; i++)
            company.hire(new Employee("Danila", "Shikalov", LocalDate.of(random.nextInt(15) + 1990, random.nextInt(11) + 1, random.nextInt(27) + 1), "Moscow", "8 (999) 888-88-88", random.nextInt(100000)));
        System.out.println("Топ олдов");
        //Через лямбду
        company.handleEmployees(
                (employee, i) -> System.out.println(i + " olds " + employee.toString()),
                (employee -> (employee.getDate().getYear() < 2000)));
        System.out.println("ZP < 20000");
        company.handleEmployees(
                (employee, i) -> System.out.println(i + " bomzi " + employee.toString()),
                employee -> employee.getZP() < 20000);
        //Через классы
        emploe1 emploe11 = new emploe1();
        emploe2 emploe22 = new emploe2(19);
        System.out.println("Почти мои тески");
        company.handleEmployees(emploe11, emploe22);
        System.out.println("Топ богачей");
        //Через анонимность
        company.handleEmployees(new Employee1() {
            @Override
            public void Sout(Employee employee, int i) {
                System.out.println(i + " rich " + employee.toString());
            }
        }, new Employee2() {
            @Override
            public boolean BOOLEANSout(Employee employee) {
                return employee.getZP() > 70000;
            }
        });
    }
}
