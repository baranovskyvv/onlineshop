package com.example.fishingstore.repos.product;

import com.example.fishingstore.domain.products.Reel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReelRepo extends JpaRepository<Reel, Long> {
    List<Reel> findByName(String name);

    Long deleteById(long id);

    @Query("From Reel WHERE currentlyamount>0")
    List<Reel> findAllProductforUser();


}
