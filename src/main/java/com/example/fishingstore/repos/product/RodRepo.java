package com.example.fishingstore.repos.product;

import com.example.fishingstore.domain.products.Rod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RodRepo extends JpaRepository<Rod, Long> {
    List<Rod> findByName(String name);

    Long deleteById(long id);

    @Query("From Rod WHERE currentlyamount>0")
    List<Rod>  findAllProductforUser();
}
