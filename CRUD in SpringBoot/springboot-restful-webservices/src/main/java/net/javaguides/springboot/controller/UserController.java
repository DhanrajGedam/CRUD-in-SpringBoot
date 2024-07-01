package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService ;

    //Build Create User REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser =  userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Build getUserById REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Build getAll Users REST APi
    // http://localhost:8080/api/users
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
       List<User> users = userService.getAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Build UpdateUser REST API
        // http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<User> upDatedUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.upDatedUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    //Build DeleteUser REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.DeleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

    //http://localhost:8080/delete
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllUsers(){
        userService.deleteAllUsers();
        return new ResponseEntity<>("All Users has been Deleted Successfully", HttpStatus.OK);
    }
}
