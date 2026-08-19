package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Poritolio")
public class Poritolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long poritolioId;

    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private double totalValue;




    public Poritolio(Date createdDate, double totalValue, Client client){
        this.client = client;
        this.createdDate = createdDate;
        this.totalValue = totalValue;
    }

    public Date getCreatedDate() {return createdDate;}
    public double getTotalValue(){return totalValue;}
    public long getPoritolioId(){ return poritolioId;}
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

    @OneToMany(mappedBy = "poritolio")
    private List<Security>securities;

    public List<Security> getSecurities(){return securities;}
    protected Poritolio(){

    }

}
