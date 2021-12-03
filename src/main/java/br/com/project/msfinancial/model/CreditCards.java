package br.com.project.msfinancial.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credit_cards")
public class CreditCards implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1171916983816330944L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cardFlag; //bandeira do cartão
	private String bank; //banco emissor do cartão
	private Double invoiceAmount; //valor da fatura
	private Double dueDate; //data de vencimento da fatura do cartao

}
