import java.sql.*;


public class SelectRecord {
    static final String JDBC_DRIVER= "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/students";
    //db credential

    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {
        Connection c= null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            //open connection
            System.out.println("Connecting to selected database");
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database succefully");

            //excecute query
            System.out.println("Creating statement");
            stmt = c.createStatement();

            String sql = "SELECT id, first, last, age FROM REGISTRATION";
            ResultSet rs= stmt.executeQuery(sql);
            //extract data from result set
            while (rs.next()){
                    int id = rs.getInt("id");
                    int age = rs.getInt("age");
                    String first = rs.getString("first");
                    String last = rs.getString("last");

                    System.out.print("ID :" +id);
                    System.out.print(", Age: " + age);
                    System.out.print(",First:" +first);
                    System.out.println(",Last:" +last);
            }
            rs.close();
        } catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        } try{
            if(stmt!= null)
                c.close();
        }catch (SQLException se){
            // do nothing
        } try {
            if(c!=null)
                c.close();
        }catch (SQLException se){
            se.printStackTrace();
        }

    }
}
