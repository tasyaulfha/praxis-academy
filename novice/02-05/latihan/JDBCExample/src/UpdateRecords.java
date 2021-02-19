import java.sql.*;
public class UpdateRecords {
    static final String JBDC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/students";

    //database credential
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {
        Connection c =null;
        Statement stmt = null;

        try {
            Class.forName(JBDC_DRIVER);

            //open connectionab
            System.out.println("Connecting to selected database");
            c = DriverManager.getConnection(DB_URL, USER,PASS);
            System.out.println("Connected database successfully");

            System.out.println("Creating statement...");
            stmt = c.createStatement();
            String sql = "UPDATE Registration " +
                    "SET age = 30 WHERE id in (100, 101)";
            stmt.executeUpdate(sql);
            //extrct all records
            sql = "SELECT id , first , last ,age FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first =rs.getString("first");
                String last = rs.getString("last");

                //display values
                System.out.print("ID:" +id );
                System.out.print(",Age:" + age);
                System.out.print(",First:" +first);
                System.out.println(",Last:" + last);
            }
            rs.close();
        } catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt!=null)
                    c.close();
            }catch (SQLException se){
                // do nothing
            }try {
                if(c!=null)
                    c.close();
            } catch (SQLException se){
                se.printStackTrace();
            }
            System.out.println("Good bye");
        }
    }
}
