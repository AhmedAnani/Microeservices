package com.example.cards.repository;

import com.example.cards.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Integer> {
    Optional<Card> findByPhone(String phone);

    boolean existsByPhone(String phone);
}
