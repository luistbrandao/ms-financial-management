package br.com.project.msfinancial.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.project.msfinancial.model.enums.Month;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class MonthSpendInfo implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3268205930413706078L;
	
	@Id
	private Long id;
	
	@ElementCollection
	private List<String> creditCards;
	private Double invoiceAmount; //valor da fatura de 1 cartão
	private Double monthlyPayment; //salário mensal
	private Double freeMoneyMonthly; //salário líquido mensal
	private Month month; //mes de referencis

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserInfo user;
	
}
