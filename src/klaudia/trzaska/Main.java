package klaudia.trzaska;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        System.out.println("Parse json: ");
        Jsonnameparser jsonparser = new Jsonnameparser();
        jsonparser.parseJson("./res/employees.json");

        listSalariesByJob(jsonparser);

        System.out.println("Parse csv: ");
        Csvparser csvparser = new Csvparser();
        csvparser.parseCsv("./res/employees.csv");

        listSalariesByJob(csvparser);
    }

    static void listSalariesByJob(Jobparser jobparser) {
        HashSet<String> jobList = jobparser.getAllJobs();
        for (String job : jobList){
            float sumSalaries = jobparser.sumSalariesForJob(job);
            System.out.printf("Dla %s suma zarobkow wynosi: %.2f\n", job, sumSalaries);
        }
    }
}
