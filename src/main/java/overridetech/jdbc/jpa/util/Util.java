package overridetech.jdbc.jpa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class Util {
    // реализуйте настройку соеденения с БД
    private final String jdbcURL = "jdbc:postgresql://localhost:5433/firstDB";
    private final String userName = "postgres";

    public Util() {
    }

    public Optional<Connection> getOptionalConnection() {
        Optional<Connection> optional = Optional.empty();
        try {
            String password = System.getenv("PGPASSWORD");
            optional = Optional.ofNullable(DriverManager.getConnection(jdbcURL, userName, password));
            return optional;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optional;
    }
}
