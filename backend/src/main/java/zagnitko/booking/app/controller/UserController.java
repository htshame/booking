package zagnitko.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zagnitko.booking.app.entity.User;
import zagnitko.booking.app.repository.UserRepository;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/booking/api/book")
public class UserController {

    @Autowired
    UserRepository repository;

    @RequestMapping(value = "/book", method = POST, produces = {"application/json"})
    public ResponseEntity<?> findAll() {
        List<User> users = repository.findAll();
        return new ResponseEntity<Object>(users, HttpStatus.OK);
    }
}
