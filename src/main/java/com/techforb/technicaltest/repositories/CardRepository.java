package com.techforb.technicaltest.repositories;
import com.techforb.technicaltest.models.Card;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsByCardNumber(String cardNumber);
    List<Card> findAllByUserId(Long userId);

}
