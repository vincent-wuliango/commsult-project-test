package com.commsult.models.repos;

import com.commsult.models.entities.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Long> {
    
}
