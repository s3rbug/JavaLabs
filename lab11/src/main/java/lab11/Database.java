package lab11;

import java.sql.*;
import java.util.ResourceBundle;

public class Database implements AutoCloseable {
    public final Connection connection;
    public final Statement statement;

    Database() throws SQLException {
        ResourceBundle databaseConfig = ResourceBundle.getBundle("database");
        String url = databaseConfig.getString("url");
        String user = databaseConfig.getString("user");
        String password = databaseConfig.getString("password");
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    void printWorkers(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println("Worker id: " + rs.getString("id") +
                    "\nFull name: " + rs.getString("surname") + " " + rs.getString("name") +
                    "\nPosition: " + rs.getString("position") +
                    "\nDepartment id: " + rs.getString("departmentId") + "\n"
            );
        }
    }

    void printTasks(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println("Task id: " + rs.getString("id") +
                    "\nDescription: " + rs.getString("description") +
                    "\nWorker id: " + rs.getString("workerId") + "\n"
            );
        }
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
