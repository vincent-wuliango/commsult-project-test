package com.commsult.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "stock")
@SQLDelete(sql = "UPDATE stock SET deleted = true WHERE stock_id=?")
@Where(clause = "deleted=false")
public class Stock extends BaseEntity<String> implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;
    
    @Column(name = "stock_name", length = 100, nullable = false)
    private String name;

    @Column(name = "stock_quantity", nullable = false)
    private Long quantity;

    @Column(name = "stock_price", nullable = false)
    private Double price;

    @Column(name = "stock_description", length = 500)
    private String description;

    private boolean deleted = Boolean.FALSE;
    
    public Stock() {
    }

    

    public Stock(Long id, String name, Long quantity, Double price, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    
}
