import java.sql.*;
import java.util.Enumeration;

public class Employee_Payroll {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
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
            ResultSet resultSet = statement.executeQuery("select * from employee_payroll");

            System.out.println();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.print(resultSet.getString("name"));
                System.out.print(resultSet.getString("phone_number"));
                System.out.print(resultSet.getString("address"));
                System.out.print(resultSet.getString("department"));
                System.out.print(resultSet.getString("gender"));
                System.out.print(resultSet.getDouble("basic_pay"));
                System.out.print(resultSet.getDouble("deduction"));
                System.out.print(resultSet.getDouble("taxable_pay"));
                System.out.print(resultSet.getDouble("tax"));
                System.out.print(resultSet.getDouble("net_pay"));
                System.out.print(resultSet.getDate("start"));

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