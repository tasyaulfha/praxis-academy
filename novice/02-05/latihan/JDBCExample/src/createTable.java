
import java.sql.*;
public class createTable {
    static final String JDBC_DRIVER ="org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/students";

    //Database credentials
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {
        Connection c= null;
        Statement stmt = null;
        try {
            //register jdbc driver
            Class.forName("org.postgresql.Driver");

            //open a connection
            System.out.println("Connecting to selected database");
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connected to database successfully");

            //execute a query
            System.out.println("creating table in given database ");
            stmt = c.createStatement();

            String sql = "CREATE TABLE REGISTRATION" +
                    "(id INTEGER NOT NULL," +
                    "first VARCHAR(255)," +
                    "last VARCHAR (255), " +
                    "age INTEGER ," +
                    "PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
            System.out.println("CREATED table in given database");
        }catch (SQLException se){
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null)
                    c.close();
            } catch (SQLException se){
                // do nothing
            }try
            {
                if(c!=null){
                    c.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
