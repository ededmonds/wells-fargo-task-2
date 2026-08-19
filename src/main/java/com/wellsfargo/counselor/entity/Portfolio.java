package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private double totalValue;




    public Portfolio(Date createdDate, double totalValue, Client client){
        this.client = client;
        this.createdDate = createdDate;
        this.totalValue = totalValue;
    }

    public Date getCreatedDate() {return createdDate;}
    public double getTotalValue(){return totalValue;}
    public long getPortfolioId(){ return portfolioId;}
    public Client getClient(){return client;}
    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }


    public void setTotalValue(double newTotalValue){
        this.totalValue = newTotalValue;
    }
    public void setClient(Client newClient){
        this.client = newClient;
    }

    @OneToOne()
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "portfolio")
    private List<Security>securities;

    public List<Security> getSecurities(){return securities;}
    protected Portfolio(){

    }

}
