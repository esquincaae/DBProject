package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE user.email = :email && user.password = :password ;", nativeQuery = true)
    User validate(String email, String password);
}
