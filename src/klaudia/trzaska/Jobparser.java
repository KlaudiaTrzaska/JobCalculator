package klaudia.trzaska;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Jobparser {
    private List<Employee> employeelist;

    public Jobparser () {
        employeelist = new ArrayList<Employee>();
    }

    public void Createemployee (String id, String name, String surname, String job, String salaryString) {
        Employee newEmployee = new Employee (parseId(id), name, surname, job, parseSalary(salaryString));
        employeelist.add(newEmployee);
    }

    public float parseSalary (String salaryString) {
        return Float.parseFloat(salaryString.replaceAll(",","."));
    }

    public int parseId (String idString) {
        return Integer.parseInt(idString);
    }

    public float sumSalariesForJob(String job) {
        float salarySum = 0;
        for (Employee employee : employeelist){
            if (employee.getJob().equals(job)){
                salarySum += employee.getSalary();
            }
        }
        return salarySum;
    }

    public HashSet<String> getAllJobs() {
        HashSet<String> jobList = new HashSet<String>();
        for (Employee employee : employeelist){
            jobList.add(employee.getJob());
        }
        return jobList;
    }

    public List<Employee> getEmployeeList() {
        return this.employeelist;
    }
}
