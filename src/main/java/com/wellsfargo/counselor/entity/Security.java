package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Security")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long securityId;


    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String category;
    @Column(nullable = true)
    private Date purchaseDate ;
    @Column(nullable = true)
    private double purchasePrice;
    @Column(nullable = true)
    private double quantity;

    public Security(String name, String category, Date purchaseDate,double purchasePrice, double quantity, Poritolio poritolio){
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.poritolio = poritolio;
    }

    public long getSecurityId(){return securityId;}
    public String getName(){return name;}
    public String getCategory(){return category;}
    public Date getPurchaseDate(){return purchaseDate;}
    public double getQuantity(){return quantity;}
    public Poritolio getPoritolio(){return poritolio;}
    public double getPurchasePrice(){return purchasePrice;}

    public void setPurchasePrice(double price) {
        this.purchasePrice = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setPurchaseDate(Date purchase){
        this.purchaseDate = purchase;
    }
    public void setQuantity(double newQuantity){
        this.quantity = newQuantity;
    }
    public void setPoritolio(Poritolio poritolio){
        this.poritolio = poritolio;
    }
    protected Security(){}

    @ManyToOne()
    @JoinColumn(name="portfolio")
    private Poritolio poritolio;
}
