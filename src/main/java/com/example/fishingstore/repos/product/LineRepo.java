package com.example.fishingstore.repos.product;

import com.example.fishingstore.domain.products.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LineRepo extends JpaRepository<Line, Long> {
        List<Line> findByName(String name);

        Long deleteById(long id);

        @Query("From Line WHERE currentlyamount>0")
        List<Line> findAllLineforUser();


}
