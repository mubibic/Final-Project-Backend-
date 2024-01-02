package com.example.agcbiohardwareinventorysystembackend.Repository;

import com.example.agcbiohardwareinventorysystembackend.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// This interface is for the LoginRepository which extends the JpaRepository interface to perform
// CRUD operations on the Login entity in the database using the methods provided by the JpaRepository interface

// This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    // This method is used to find a login by its username
    // Optional is used to avoid NullPointerException, and it is used to represent a value which may or may not be available
    // <Login> is the type of the entity to be returned because the JpaRepository interface is a generic interface and it takes the type of the entity as a parameter
    Optional<Login> findByUsername(String username);
}
