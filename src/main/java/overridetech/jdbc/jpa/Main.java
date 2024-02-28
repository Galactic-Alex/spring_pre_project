package overridetech.jdbc.jpa;

import overridetech.jdbc.jpa.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("userName", "userLastName", (byte) 25);
        userService.saveUser("otherName", "otherLastName", (byte) 52);
        userService.saveUser("anotherName", "anotherLastName", (byte) 35);
        userService.saveUser("someName", "someLastName", (byte) 39);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
