package br.com.project.msfinancial.model;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spending implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 6117268682653496920L;
	
	@Id
	private Long id;

}
