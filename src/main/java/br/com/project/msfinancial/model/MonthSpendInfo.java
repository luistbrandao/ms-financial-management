package br.com.project.msfinancial.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.project.msfinancial.model.enums.Month;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "month_spend_info")
public class MonthSpendInfo implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3268205930413706078L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "month_spend_info_id", referencedColumnName = "id")
	private List<CreditCards> creditCards; //cartões
	
	private Double payCheck; //salário mensal
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "month_spend_info_id", referencedColumnName = "id")
	private List<ExtraIncome> extraIncome; //renda extra
	
	private Month month; //mes de referencia

	public MonthSpendInfo(List<CreditCards> creditCards, Double payCheck, List<ExtraIncome> extraIncome, Month month) {
		super();
		this.creditCards = creditCards;
		this.payCheck = payCheck;
		this.extraIncome = extraIncome;
		this.month = month;
	}


	
}
