package com.commsult.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.commsult.models.entities.Stock;
import com.commsult.models.repos.StockRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StockService {
    
    @Autowired
    private StockRepo stockRepo;

    public Stock addStock(Stock stock) {
        return stockRepo.save(stock);
    }

    public Stock updateStock(Stock stock) {
        return stockRepo.save(stock);
    }

    public Stock findById(Long id) {
        Optional<Stock> stock = stockRepo.findById(id);
        if(!stock.isPresent()) {
            return null;
        }
        return stock.get();
    }

    public List<Stock> findAll() {
        return stockRepo.findAll();
    }

    public void removeById(Long id) {
        stockRepo.deleteById(id);
    }
}
