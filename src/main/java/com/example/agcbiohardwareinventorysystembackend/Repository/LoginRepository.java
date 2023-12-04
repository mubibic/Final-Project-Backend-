package com.example.agcbiohardwareinventorysystembackend.Repository;

import com.example.agcbiohardwareinventorysystembackend.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByUsername(String username);
}
