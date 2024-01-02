package com.example.agcbiohardwareinventorysystembackend.Controller;

import com.example.agcbiohardwareinventorysystembackend.Entity.Login;
import com.example.agcbiohardwareinventorysystembackend.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // This method is for validating the user credentials passed in the request body from the frontend
    // to the backend and returns the validated user object to the frontend as a response if
    // the user credentials are valid and returns a 401 unauthorized response if the user credentials are invalid or if the user does not exist in the database
    @PostMapping("")
    public ResponseEntity<Login> login(@RequestBody Login user) {
        Login validatedUser = loginService.validateUser(user.getUsername(), user.getPassword());
        if (validatedUser != null) {
            return ResponseEntity.ok(validatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    // Other endpoints, such as registration, can be added here
}
