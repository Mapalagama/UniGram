package com.example.Unigram.Controllers;

import com.example.Unigram.DTO.UserDTO;
import com.example.Unigram.Models.User;
import com.example.Unigram.Repositories.UserRepository;
import com.example.Unigram.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        User user =User.createUser(userDTO);
        User user1 = userService.login(user);
        UserDTO userDTO1 = UserDTO.createUserDTO(user1);
        return  ResponseEntity.ok(userDTO1);
    }
}
