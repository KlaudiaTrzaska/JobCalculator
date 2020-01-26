import klaudia.trzaska.Employee;
import klaudia.trzaska.Jobparser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class JobparserTest {

    @Test
    public void createemployeeParseTest() {
        Employee expectedEmployee = new Employee(1, "Jan", "Kowalski", "Janitor", 1000.00f);

        Jobparser jobparser = new Jobparser();
        jobparser.Createemployee("1", "Jan", "Kowalski", "Janitor", "1000,00");
        List<Employee> employeeList = jobparser.getEmployeeList();
        Employee createdEmployee = employeeList.get(0);

        Assert.assertEquals(expectedEmployee, createdEmployee);
    }

    @Test
    public void parseSalary() {
        Jobparser jobparser = new Jobparser();

        Assert.assertEquals(100f, jobparser.parseSalary("100,00"));
        Assert.assertEquals(100f, jobparser.parseSalary("100.00"));
        Assert.assertEquals(0.1f, jobparser.parseSalary("0.1"));
    }

    @Test
    public void parseId() {
        Jobparser jobparser = new Jobparser();

        Assert.assertEquals(1, jobparser.parseId("1"));
        Assert.assertEquals(-1, jobparser.parseId("-1"));
        try {
            jobparser.parseId(" ");
        } catch (NumberFormatException e){
            Assert.assertEquals("java.lang.NumberFormatException: For input string: \" \"", e.toString());
        }
    }

    @Test
    public void sumSalariesForJob() {
        Jobparser jobparser = new Jobparser();
        jobparser.Createemployee("1", "Jan", "Kowalski", "Janitor", "1000,00");
        jobparser.Createemployee("2", "Adam", "Nowak", "Janitor", "2000.00");
        jobparser.Createemployee("3", "Hulaj", "Noga", "Preacher", "1000,10");
        List<Employee> employeeList = jobparser.getEmployeeList();

        Assert.assertEquals(3000f, jobparser.sumSalariesForJob("Janitor"), 0f);
        Assert.assertEquals(1000.10f, jobparser.sumSalariesForJob("Preacher"), 0f);
        Assert.assertEquals(0f, jobparser.sumSalariesForJob("Pope"), 0f);
    }

    @Test
    public void getAllJobs() {
        HashSet<String> allJobs = new HashSet<String>();
        allJobs.add("Janitor");
        allJobs.add("Preacher");

        Jobparser jobparser = new Jobparser();
        jobparser.Createemployee("1", "Jan", "Kowalski", "Janitor", "1000,00");
        jobparser.Createemployee("2", "Adam", "Nowak", "Janitor", "2000.00");
        jobparser.Createemployee("3", "Hulaj", "Noga", "Preacher", "1000,10");

        Assert.assertEquals(allJobs, jobparser.getAllJobs());
    }
}
