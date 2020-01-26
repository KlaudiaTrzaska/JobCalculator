package klaudia.trzaska;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String job;
    private float salary;

    public Employee(int id, String name, String surname, String job, float salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getJob() {
        return job;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %.2f", id, name, surname, job, salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Float.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(job, employee.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, job, salary);
    }
}
