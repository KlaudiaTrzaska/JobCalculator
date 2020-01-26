package klaudia.trzaska;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class Csvparser extends Jobparser {


    public void parseCsv (String filepath) {
        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(filepath);

            // create csvParser object with
            // custom seperator semi-colon
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();

            // Read all data at once
            List<String[]> allData = csvReader.readAll();

            // Print Data.
            for (String[] row : allData) {
                parseEmployee(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseEmployee (String[] employee) {
        String id = String.valueOf(employee[0]).trim();
        String name = String.valueOf(employee[1]).trim();
        String surname = String.valueOf(employee[2]).trim();
        String job = String.valueOf(employee[3]).trim();
        String salary = String.valueOf(employee[4]).trim();

        Createemployee(id, name, surname, job, salary);
    }
}
