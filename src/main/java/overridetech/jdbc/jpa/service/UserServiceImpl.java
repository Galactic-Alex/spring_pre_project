package overridetech.jdbc.jpa.service;

import overridetech.jdbc.jpa.dao.UserDaoHibernateImpl;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoHibernateImpl userDao;

    public UserServiceImpl() {
        Util util = new Util();
        userDao = new UserDaoHibernateImpl(util.getSessionFactory());
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
