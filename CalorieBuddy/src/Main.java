
public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD

        System.out.println("test123");

        //testing database  connection
        String databaseURL = "jdbc:mysql://db1.cojsra38kk1x.us-west-2.rds.amazonaws.com";
        String user = "root";
        String password = "csusmpassword";
        Connection conn = null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("CHANGE MADE");
>>>>>>> parent of 12ea9b4 (test db connection)
=======
        System.out.println("CHANGE MADE");
>>>>>>> parent of 12ea9b4 (test db connection)
    }
}