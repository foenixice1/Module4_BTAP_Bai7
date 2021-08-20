package repository;

import model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IUserRepo extends PagingAndSortingRepository<User,Integer> {
    @Query(value = "select u from User u where u.userName like concat('%', :username , '%')")
    ArrayList<User> findAllByUserName(@Param("name") String username);
}
