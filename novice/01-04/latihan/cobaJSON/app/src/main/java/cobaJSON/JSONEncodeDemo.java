/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cobaJSON;

import org.json.simple.JSONObject;


public class JSONEncodeDemo 
{ 
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(10000.21));
        obj.put("is vip", new Boolean(true));

        System.out.println(obj);



}
}


    
   