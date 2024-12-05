package mtcg.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseConnection {
    private String connectionString = "jdbc:postgresql://localhost:5432/MTCG?user=Johannes&password=admin";

    public Connection connect() throws SQLException{
        return DriverManager.getConnection(connectionString);
    }
}
