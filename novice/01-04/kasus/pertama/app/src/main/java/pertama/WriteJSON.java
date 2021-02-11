/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pertama;

import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSON {
  
    public static void main(String[] args) {
        JSONObject employeeDetails= new JSONObject();
        employeeDetails.put ("first name" , "tasya");
        employeeDetails.put ("last name" , "ulfha");
        employeeDetails.put ("age", "20");
        
        JSONObject employeeObject = new JSONObject();
        employeeDetails.put("employee", employeeDetails);

        //second employee
        JSONObject employeeDetails2= new JSONObject();
        employeeDetails2.put ("first name" , "nabila");
        employeeDetails2.put ("last name" , "ulfha");
        employeeDetails2.put ("age", "25");
        
     
        
        JSONObject employeeObject2 = new JSONObject();
        employeeDetails2.put("employee", employeeDetails);

        //add employee to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);

        //write JSON file
        try (FileWriter file = new FileWriter("employees.json")){
                file.write(employeeList.toJSONString());
                file.flush();
            }  catch (IOException ex) {
            ex.printStackTrace();
        }


       
    }
}
