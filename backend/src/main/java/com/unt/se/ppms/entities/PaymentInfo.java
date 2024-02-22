package com.unt.se.ppms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "payment_info")
public class PaymentInfo {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private long id;
    
	@Id
    @Column(name = "payment_id")
    private String paymentId;
    
    @Column(name="payer_id")
    private String payerId;
    
    @Column(name = "payment_status")
    private String status;
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "currency")
    private String currency;

	public PaymentInfo(Double amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
    
    
}
	