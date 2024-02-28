package overridetech.jdbc.jpa.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import overridetech.jdbc.jpa.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class Util {
    // реализуйте настройку соеденения с БД
    private final String jdbcURL = "jdbc:postgresql://localhost:5433/firstDB";
    private final String userName = "postgres";

    private final String password = System.getenv("PGPASSWORD");

    private final Configuration configuration = getHibernateConfiguration();

    public Util() {
    }

    public Optional<Connection> getOptionalConnection() {
        Optional<Connection> optional = Optional.empty();
        try {
            optional = Optional.ofNullable(DriverManager.getConnection(jdbcURL, userName, password));
            return optional;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optional;
    }


    public SessionFactory getSessionFactory() {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private Configuration getHibernateConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", jdbcURL);
        configuration.setProperty("hibernate.connection.username", userName);
        configuration.setProperty("hibernate.connection.password", password);
        return configuration;
    }
}
