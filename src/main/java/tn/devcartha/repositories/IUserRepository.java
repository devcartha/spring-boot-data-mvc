package tn.devcartha.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.devcartha.entities.User;

import java.util.List;

/**
 * Created by Devcartha on 11/25/2015.
 */
@Repository
@Qualifier(value = "userRepository")
public interface IUserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
    public List<User> findByUsernameOrPassword(String username, String password);
}
