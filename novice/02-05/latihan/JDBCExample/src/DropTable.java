import java.sql.*;
public class DropTable {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/students";

    //Database credentials
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            //open connection
            System.out.println("Connecting to a selected database...");
            c = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connection database succesfully");
            //execute query
            System.out.println("Deleting table in given database..");
            stmt = c.createStatement();

            String sql = "DROP TABLE REGISTRATION";

            stmt.executeUpdate(sql);
            System.out.println("table deleted in given database");


        } catch (SQLException se) {
            //handle erro jdbc
            se.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
            }finally {
            //finally block used to close resources
            try
            {
                if (stmt!=null)
                    c.close();
            }catch (SQLException se){
                // do nothing
            }try {
               if (c!=null)
                   c.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
}
