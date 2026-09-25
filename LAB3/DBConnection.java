
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException(
                    "Chưa thêm mssql-jdbc-*.jar vào classpath.",
                    ex
            );
        }

        String dbURL =
            "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QLKhachSan;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

        String user = System.getenv("QLKHACH_SAN_DB_USER");
        String pass = System.getenv("QLKHACH_SAN_DB_PASSWORD");

        if (user == null || pass == null) {
            throw new SQLException(
                "Thiếu biến môi trường QLKHACH_SAN_DB_USER hoặc QLKHACH_SAN_DB_PASSWORD."
            );
        }

        return DriverManager.getConnection(dbURL, user, pass);
    }
}