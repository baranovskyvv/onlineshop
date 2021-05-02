package com.example.fishingstore.repos.product;

import com.example.fishingstore.domain.LittleCart;
import com.example.fishingstore.domain.products.Hook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface HookRepo extends JpaRepository<Hook, Long> {
    List<Hook> findByName(String name);

    Long deleteById(long id);

    @Query("From Hook WHERE currentlyamount>0")
    List<Hook>  findAllProductforUser();



}


