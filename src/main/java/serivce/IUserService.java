package serivce;

import model.User;

import java.util.ArrayList;

public interface IUserService {
    User save(User user);
    User findById(int id);
    ArrayList<User> findAll();
    ArrayList<User> findAllByUserName(String name);
    void delete(User user);
    void edit(User user);
}
