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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MainIncome implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3164177178249614683L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double salary;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "main_income_id", referencedColumnName = "id")
	private List<ExtraIncome> extraIncomes;

}
