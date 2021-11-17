package com.commsult.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.commsult.dto.ResponseData;
import com.commsult.dto.StockRequest;
import com.commsult.dto.StockResponse;
import com.commsult.models.entities.Stock;
import com.commsult.services.StockService;
import com.commsult.utils.ErrorParsingUtils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class StockController {
    
    @Autowired
    private StockService stockService;

    @Autowired
    private ModelMapper modelMapper;

    // @GetMapping("/stocks")
    // public ResponseEntity<ResponseData<List<StockResponse>>> getAllStocks() {
    //         ResponseData<List<StockResponse>> responseData = new ResponseData<>();
    //         List<StockResponse> listStock = new ArrayList<>();
    //         stockService.findAll().forEach(stock -> {
    //             listStock.add(modelMapper.map(stock, StockResponse.class));
    //         });
    //         responseData.setStatus(true);
    //         responseData.setPayload(listStock);
    //         return ResponseEntity.ok(responseData);
    //     }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return stockService.findAll();
    }

    @GetMapping("/stocks/{id}")
    public Stock findStockById(@PathVariable("id") Long id){
        return stockService.findById(id);
    }

    @PostMapping("/stocks/add")
    public ResponseEntity<ResponseData<Stock>> add(@Valid @RequestBody StockRequest stockRequest, Errors errors) { 

        ResponseData<Stock> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            responseData.setStatus(false);
            responseData.setMessages(ErrorParsingUtils.parse(errors));
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        try {
        Stock stock = modelMapper.map(stockRequest, Stock.class);

        responseData.setStatus(true);
        responseData.setPayload(stockService.addStock(stock));
        responseData.getMessages().add(String.format("%s saved", stock.getName()));
        return ResponseEntity.ok(responseData);

        } catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    @PutMapping("/stocks/edit")
    public ResponseEntity<ResponseData<Stock>> edit(@Valid @RequestBody StockRequest stockRequest, Errors errors) { 

        ResponseData<Stock> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            responseData.setStatus(false);
            responseData.setMessages(ErrorParsingUtils.parse(errors));
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        try {
        Stock stock = modelMapper.map(stockRequest, Stock.class);

        responseData.setStatus(true);
        responseData.setPayload(stockService.addStock(stock));
        responseData.getMessages().add(String.format("%s saved", stock.getName()));
        return ResponseEntity.ok(responseData);

        } catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    @DeleteMapping("/stocks/delete/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        stockService.removeById(id);
    }

    // @PutMapping
    // public ResponseEntity<ResponseData<?>> update(@Valid @RequestBody StockRequest  stockRequest, Errors errors) {

    //     ResponseData<StockResponse> responseData = new ResponseData<>();

    //     if(errors.hasErrors()){
    //         responseData.setStatus(false);
    //         responseData.setMessages(ErrorParsingUtils.parse(errors));
    //         responseData.setPayload(null);
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    //     }
    //     try {
    //         Stock stock = modelMapper.map(stockRequest, Stock.class);

    //         responseData.setStatus(true);
    //         responseData.getMessages().add("Stock saved");
    //         responseData.setPayload(modelMapper.map(stock, StockResponse.class));
    //         return ResponseEntity.ok(responseData);
    //     } catch (Exception e) {
    //         responseData.setStatus(false);
    //         responseData.getMessages().add(e.getMessage());
    //         responseData.setPayload(null);
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
    //     }

        
    // }

}

