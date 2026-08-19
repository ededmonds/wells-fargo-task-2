package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = true)
    private String phoneNumber ;
    @Column(nullable = true)
    private String address;

    @ManyToOne()
    @JoinColumn(name="advisorId")
    private Advisor advisor;

    @OneToOne(mappedBy = "client")
    private Portfolio poritolio;

    public Client(String name, String email, String phone, String address){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phone;
    }

    protected Client() {

    }
    public Long getClientId(){return clientId;}
    public String getName(){ return name;}
    public String getEmail(){return email;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getAddress(){return address;}
    public Advisor getAdvisor(){ return advisor;}

    public void setName(String name){this.name = name;}
    public void setEmail(String email){this.email = email;}
    public void setAddress(String address){this.address = address;}
    public void setPhoneNumber(String phone){this.phoneNumber = phone;}
    public void setAdvisor(Advisor advisor){ this.advisor = advisor;}
}
