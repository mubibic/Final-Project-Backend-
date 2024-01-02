package com.example.agcbiohardwareinventorysystembackend.Service;


import com.example.agcbiohardwareinventorysystembackend.Entity.Login;
import com.example.agcbiohardwareinventorysystembackend.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private final LoginRepository repository;

    @Autowired
    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    public Login validateUser(String username, String password) {
        // Use the repository instance to call findByUsername
        return repository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
}
