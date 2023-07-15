package com.features;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java4devs.java8features.dao.EmployeeDao;
import com.java4devs.java8features.model.Employee;

public class StreamOperationsOnEmployee {
        public static void main(String[] args) {

                List<Employee> allEmployees = EmployeeDao.getAllEmployees();
                

                // 1. sort employees by sal

                allEmployees.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
                                .forEach(System.out::println);

                // 2. find count of employees

                long count = allEmployees.stream().count();
                System.out.println(count);

                // 3. find count of male employees

                allEmployees.stream().filter(f -> f.getGender().equals("m")).forEach(System.out::println);

                Predicate<Employee> Employeepredicate = new Predicate<Employee>() {

                        @Override
                        public boolean test(Employee t) {
                                // TODO Auto-generated method stub
                                if (t.getCoutry().endsWith("india")) {
                                        return true;
                                }
                                return false;
                        }

                };

                // 4. find count of female employees

                long count2 = allEmployees.stream().filter(f -> f.getGender().equals("f")).count();
                System.out.println(count2);

                // find number of employees in each dep

                // find employees from india

                allEmployees.stream().filter(Employeepredicate).forEach(System.out::println);

                Map<String, Long> collect = allEmployees.stream()
                                .collect(Collectors.groupingBy(Employee::getRole, Collectors.counting()));
                System.out.println(collect);

                // highest sal of employee

                Employee employee = allEmployees.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
                                .findFirst()
                                .get();
                System.out.println(employee);

                // second highest sal of employee

                Employee employee2 = allEmployees.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
                                .skip(1)
                                .findFirst().get();

                System.out.println(employee2);


                // Highest sal in each dep

                allEmployees.stream().collect(Collectors.groupingBy(Employee::getRole,
                                Collectors.maxBy(Comparator.comparing(Employee::getSal))))
                                .entrySet()
                                .forEach(System.out::println);

                // lowest sal in each dep

                allEmployees.stream().collect(Collectors.groupingBy(Employee::getRole,
                                Collectors.maxBy(Comparator.comparing(Employee::getSal).reversed())))
                                .entrySet()
                                .forEach(System.out::println);

                // find number of dev employees

                long count3 = allEmployees.stream().filter(f->f.getRole().equals("dev")).count();
                System.out.println(count3);
        
        }

}
