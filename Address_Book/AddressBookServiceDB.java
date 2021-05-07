import java.sql.*;
import java.util.Enumeration;

public class AddressBookServiceDB {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/address_book_service";
        String username = "root";
        String password = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        listDriver();

        try{
            System.out.println("Connecting to database: " +url);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is successfull!!" +connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from adderss_book");

            System.out.println();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("sr_no"));
                System.out.print(resultSet.getString("adderss_book_name"));
                System.out.print(resultSet.getString("first_name"));
                System.out.print(resultSet.getString("last_name"));
                System.out.print(resultSet.getString("profession"));
                System.out.print(resultSet.getString("family"));
                System.out.print(resultSet.getString("friends"));
                System.out.print(resultSet.getString("address"));
                System.out.print(resultSet.getString("city"));
                System.out.print(resultSet.getString("state"));
                System.out.print(resultSet.getString("phone_number"));
                System.out.print(resultSet.getString("email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void listDriver() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}