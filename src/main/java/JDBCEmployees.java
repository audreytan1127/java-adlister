import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;
public class JDBCEmployees {

    public static void main(String[] args) throws SQLException{

        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true&useSSL=false",
                "root",
                "codeup"
        );
        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery("SELECT * FROM employees LIMIT 10;");
        ArrayList<String> employeeNames = new ArrayList<>();
        while(results.next()){
            employeeNames.add(results.getString("first_name"));
        }
        System.out.println(employeeNames);
    }

}
