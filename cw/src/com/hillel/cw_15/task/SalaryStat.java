package com.hillel.cw_15.task;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
## 6) Статистика зарплат
**Дано:** `List<Employee>` з `dept`, `grade`, `salary`.
**Завдання:** порахувати `DoubleSummaryStatistics` по зарплатам у кожному департаменті.
 */
public class SalaryStat {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("IT", "Senior", 5000),
            new Employee("IT", "Mid", 3500),
            new Employee("HR", "Senior", 4000),
            new Employee("HR", "Junior", 2000),
            new Employee("Sales", "Mid", 3000),
            new Employee("Sales", "Senior", 4500)
        );

        Map<String, DoubleSummaryStatistics> stat = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDept,
                Collectors.summarizingDouble(Employee::getSalary)
            ));


        stat.forEach((dept, stats) -> System.out.println(dept +" -> " + stats));

    }

}

class Employee{
    String dept;
    String grade;
    double salary;

    public Employee(String dept, String grade, double salary) {
        this.dept = dept;
        this.grade = grade;
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Empl{" +
            "dept='" + dept + '\'' +
            ", grade='" + grade + '\'' +
            ", salary=" + salary +
            '}';
    }
}
