package com.example.fishingstore.repos.order;

import com.example.fishingstore.domain.AddressOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepo extends JpaRepository<AddressOrder,Long> {
}
