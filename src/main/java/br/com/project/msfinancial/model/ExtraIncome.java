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
@Table(name = "extra_income")
public class ExtraIncome implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -8095803044144686023L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description; //descrição
	private Double amount; //quantia
	
	
	public ExtraIncome(String description, Double amount) {
		super();
		this.description = description;
		this.amount = amount;
	}

	
	
}
