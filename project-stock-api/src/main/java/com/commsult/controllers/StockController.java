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
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/stocks")
// @RequestMapping("")
public class StockController {
    
    @Autowired
    private StockService stockService;

    @Autowired
    private ModelMapper modelMapper;

    // @GetMapping
    // public String dashboard(Model model) {
    //     String messages = "Home";
    //     model.addAttribute("msg", messages);
    //     model.addAttribute("stocks", stockService.findAll());
    //     return "index";
    // }

    @PostMapping
    public ResponseEntity<ResponseData<?>> create(@Valid @RequestBody StockRequest stockRequest, Errors errors) {

        ResponseData<StockResponse> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            responseData.setStatus(false);
            responseData.setMessages(ErrorParsingUtils.parse(errors));
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        try {
        Stock stock = modelMapper.map(stockRequest, Stock.class);

        responseData.setStatus(true);
        responseData.getMessages().add("Stock saved");
        responseData.setPayload(modelMapper.map(stock, StockResponse.class));
        return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
        
    }

    @GetMapping
    public ResponseEntity<ResponseData<List<StockResponse>>> findAll() {
        ResponseData<List<StockResponse>> responseData = new ResponseData<>();
        List<StockResponse> listStock = new ArrayList<>();
        stockService.findAll().forEach(stock -> {
            listStock.add(modelMapper.map(stock, StockResponse.class));
        });
        responseData.setStatus(true);
        responseData.setPayload(listStock);
        return ResponseEntity.ok(responseData);
    }

    // @GetMapping
    // public Iterable<Stock> findAll() {
    //     return stockService.findAll();
    // }

    @GetMapping("/{id}")
    public Stock findOne(@PathVariable("id") Long id) {
        return stockService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<?>> update(@Valid @RequestBody StockRequest  stockRequest, Errors errors) {

        ResponseData<StockResponse> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            responseData.setStatus(false);
            responseData.setMessages(ErrorParsingUtils.parse(errors));
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        try {
            Stock stock = modelMapper.map(stockRequest, Stock.class);

            responseData.setStatus(true);
            responseData.getMessages().add("Stock saved");
            responseData.setPayload(modelMapper.map(stock, StockResponse.class));
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }

        
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        stockService.removeOne(id);
    }
}

// @RestController
// @RequestMapping("/api/stocks")
// public class StockController {
    
//     @Autowired
//     private StockService stockService;

//     @Autowired
//     private StockRepo stockRepo;

//     @Autowired
//     private ModelMapper modelMapper;

//     @PostMapping
//     public ResponseEntity<ResponseData<?>> create(@Valid @RequestBody StockRequest stockRequest, Errors errors) {

//         ResponseData<StockResponse> responseData = new ResponseData<>();

//         if(errors.hasErrors()){
//             responseData.setStatus(false);
//             responseData.setMessages(ErrorParsingUtils.parse(errors));
//             responseData.setPayload(null);
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
//         }

//         try {
//         Stock stock = modelMapper.map(stockRequest, Stock.class);

//         responseData.setStatus(true);
//         responseData.getMessages().add("Stock saved");
//         responseData.setPayload(modelMapper.map(stock, StockResponse.class));
//         return ResponseEntity.ok(responseData);
//         } catch (Exception e) {
//             responseData.setStatus(false);
//             responseData.getMessages().add(e.getMessage());
//             responseData.setPayload(null);
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
//         }
        
//     }

//     @GetMapping
//     public ResponseEntity<ResponseData<List<StockResponse>>> findAll() {
//         ResponseData<List<StockResponse>> responseData = new ResponseData<>();
//         List<StockResponse> listStock = new ArrayList<>();
//         stockService.findAll().forEach(stock -> {
//             listStock.add(modelMapper.map(stock, StockResponse.class));
//         });
//         responseData.setStatus(true);
//         responseData.setPayload(listStock);
//         return ResponseEntity.ok(responseData);
//     }

//     // @GetMapping
//     // public Iterable<Stock> findAll() {
//     //     return stockService.findAll();
//     // }

//     @GetMapping("/{id}")
//     public Stock findOne(@PathVariable("id") Long id) {
//         return stockService.findOne(id);
//     }

//     @PutMapping
//     public ResponseEntity<ResponseData<?>> update(@Valid @RequestBody StockRequest  stockRequest, Errors errors) {

//         ResponseData<StockResponse> responseData = new ResponseData<>();

//         if(errors.hasErrors()){
//             responseData.setStatus(false);
//             responseData.setMessages(ErrorParsingUtils.parse(errors));
//             responseData.setPayload(null);
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
//         }
//         try {
//             Stock stock = modelMapper.map(stockRequest, Stock.class);

//             responseData.setStatus(true);
//             responseData.getMessages().add("Stock saved");
//             responseData.setPayload(modelMapper.map(stock, StockResponse.class));
//             return ResponseEntity.ok(responseData);
//         } catch (Exception e) {
//             responseData.setStatus(false);
//             responseData.getMessages().add(e.getMessage());
//             responseData.setPayload(null);
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
//         }

        
//     }

//     @DeleteMapping("/{id}")
//     public void removeOne(@PathVariable("id") Long id) {
//         stockService.removeOne(id);
//     }
// }
