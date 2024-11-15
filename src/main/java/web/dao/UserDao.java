package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(int id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
