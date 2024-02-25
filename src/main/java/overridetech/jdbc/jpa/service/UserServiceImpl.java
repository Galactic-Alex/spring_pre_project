package overridetech.jdbc.jpa.service;

import overridetech.jdbc.jpa.dao.UserDaoJDBCImpl;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDaoJDBCImpl userDao;

    public UserServiceImpl() {
        Util util = new Util();
        Optional<Connection> optionalConnection = util.getOptionalConnection();
        if (optionalConnection.isEmpty()) {
            throw new UserServiceException("Connection is null");
        }
        userDao = new UserDaoJDBCImpl(optionalConnection.get());
    }

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        System.out.println("User с именем - " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
