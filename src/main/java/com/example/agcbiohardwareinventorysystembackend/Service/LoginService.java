package com.example.agcbiohardwareinventorysystembackend.Service;

import com.example.agcbiohardwareinventorysystembackend.Entity.Login;
import com.example.agcbiohardwareinventorysystembackend.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This service class handles login-related operations in the application layer
@Service
public class LoginService {

    // This is repository instance for database interactions
    private final LoginRepository repository;

    // This annotation is for constructor injection to initialize the service with a LoginRepository
    @Autowired
    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    //This method is to validate user credentials against the database
    public Login validateUser(String username, String password) {
        // This uses the repository instance to call findByUsername to return the user with the given username
        return repository.findByUsername(username)
                // This filters the result, checking if the password matches
                .filter(user -> user.getPassword().equals(password))
                // This returns the validated user or null if not found
                .orElse(null);
    }
}