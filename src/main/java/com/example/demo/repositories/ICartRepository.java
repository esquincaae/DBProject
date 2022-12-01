package com.example.demo.repositories;

import com.example.demo.entities.pivots.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserId(Long userId);
}
