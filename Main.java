package org.example.hw;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 2. Создать класс Employee (Сотрудник) с полями: String name, int age,
 * double salary, String department
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String,List<Employee>>
 с отделами и сотрудниками внутри отдела
 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double>
    с отделами и средней зарплатой внутри отдела
 */
public class Main {
    static List<Employee> employeeList = new ArrayList<>();
    public static void main(String[] args) {
      //  * 2.1 Создать список из 10-20 сотрудников
        createEmployees();
       //* 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        System.out.println("Список отделов:");
        employeeList.stream().map(x->x.getDepartment()).distinct().forEach(System.out::println);

        // * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
                employeeList.stream().forEach(x->x.setSalary(x.getSalary()*1.2));

        //* 2.4 * Из списка сотрудников с помощью стрима создать Map<String,List<Employee>>
        // с отделами и сотрудниками внутри отдела
        System.out.println("Список сотрудников по отделам:");
        Map<String, List<Employee>> depMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        depMap.forEach((dept,list)->System.out.println(dept + ": "+ list));

        // * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double>
        //    с отделами и средней зарплатой внутри отдела
        Map<String, Double> avgSalaryByDepartment = depMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(emp -> emp.getSalary())
                                .average().orElse(0.0)));
        System.out.println("Средняя зарплата по департаментам:");
        avgSalaryByDepartment.forEach((dept, avgSalary) -> System.out.println(dept + ": " + avgSalary));
    }
    private static void createEmployees(){
        employeeList.add(new Employee("Ivan",35,10_000.0, "Sales"));
        employeeList.add(new Employee("Dmitriy",21,7_000.0, "Sales"));
        employeeList.add(new Employee("Mikhail;",38,12_000.0, "Logistic"));
        employeeList.add(new Employee("Elena",40,8_000.0, "Logistic"));
        employeeList.add(new Employee("Roman",50,11_000.0, "Stock"));
        employeeList.add(new Employee("Andrey",35,5_000.0, "Stock"));
        employeeList.add(new Employee("Svetlana",35,9_000.0, "Accountant"));
        employeeList.add(new Employee("Marina",42,12_000.0, "Accountant"));
        employeeList.add(new Employee("Evgeniy",55,9_000.0, "Transport"));
        employeeList.add(new Employee("Alexey",40,9_000.0, "Transport"));

    }

}
