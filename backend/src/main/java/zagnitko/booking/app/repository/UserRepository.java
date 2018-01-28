package zagnitko.booking.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import zagnitko.booking.app.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    User findByUsername(String username);
}