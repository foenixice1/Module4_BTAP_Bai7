package serivce;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IUserRepo;

import java.util.ArrayList;

public class UserService implements IUserService {
    @Autowired
    IUserRepo iUserRepo;

    @Override
    public User save(User user) {
        return iUserRepo.save(user);
    }

    @Override
    public User findById(int id) {
        return iUserRepo.findById(id).get();
    }

    @Override
    public ArrayList<User> findAll() {
        return (ArrayList<User>) iUserRepo.findAll();
    }

    @Override
    public ArrayList<User> findAllByUserName(String name) {
        return iUserRepo.findAllByUserName(name);
    }

    @Override
    public void delete(User user) {
        iUserRepo.delete(user);
    }

    @Override
    public void edit(User user) {
        iUserRepo.save(user);
    }
}
