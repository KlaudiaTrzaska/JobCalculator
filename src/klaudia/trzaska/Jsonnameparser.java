package klaudia.trzaska;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Jsonnameparser extends Jobparser {

    public void parseJson (String filepath) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filepath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray myList = (JSONArray) jsonObject.get("employees");

            for (int i = 0; i < myList.size(); i++) {
                parseEmployee((JSONObject) myList.get(i));
            }
        }  catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void parseEmployee (JSONObject employee) {
        String id = String.valueOf(employee.get("id"));
        String name = String.valueOf(employee.get("name"));
        String surname = String.valueOf(employee.get("surname"));
        String job = String.valueOf(employee.get("job"));
        String salary = String.valueOf(employee.get("salary"));

        Createemployee(id, name, surname, job, salary);
    }

           // String myString = "{ \"employees\": [ { \"id\": 1,\"name\": \"Mark\",\"surname\": \"Green\", \"job\": \"Teacher\",\"salary\": \"3540,20\"},{\"id\": 2,\"name\": \"Oscar\",\"surname\": \"Mustache\",\"job\": \"Janitor\",\"salary\": \"13460.45\"}]}";

}
