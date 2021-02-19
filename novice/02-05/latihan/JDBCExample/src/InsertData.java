import java.sql.*;

public class InsertData {
    static final String JDBC_Driver ="org.postresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/students";

    //database credentials
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            //open connection
            System.out.println(" Connecting to selecting Database");
            c= DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected Database Successfully");

            //execute query
            System.out.println("inserting into the table");
            stmt = c.createStatement();

            String sql = "INSERT INTO REGISTRATION " +
                    "VALUES (100, 'Zara', 'Ali', 18)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO REGISTRATION " +
                    "VALUES (101, 'Mahnaz', 'Fatma', 25)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration " +
                    "VALUES (102, 'Zaid', 'Khan', 30)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration " +
                    "VALUES(103, 'Sumit', 'Mittal', 28)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (stmt!=null)
                    c.close();
            }catch (SQLException se) {
                //do nothing
            }try {
                if (c!=null)
                    c.close();
            }catch (SQLException se){
                se.printStackTrace();
            }

        }
        System.out.println("Goodbye!");
    }

}
