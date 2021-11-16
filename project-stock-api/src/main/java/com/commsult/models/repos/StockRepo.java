package com.commsult.models.repos;

import com.commsult.models.entities.Stock;

import org.springframework.data.repository.CrudRepository;

public interface StockRepo extends CrudRepository<Stock, Long> {
    
}
