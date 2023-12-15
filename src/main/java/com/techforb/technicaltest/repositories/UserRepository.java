package com.techforb.technicaltest.repositories;

import com.techforb.technicaltest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByNumberDocument(String numberDocument);

}
