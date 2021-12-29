package br.com.project.msfinancial.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.project.msfinancial.model.enums.ShareType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stocks implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ticker;
	private Integer quantity;
	private Double costBasis; // valor de aquisição
	private Double avaragePrice; // preço médio
	private Double profitLoss; // ganho ou perda
	private Double upgrading; // valorização
	private Double percentageSharesStocks; // porcentagem em ações
	private Double quote; // valor atual do ativo
	private Double targetPrice; // preço alvo
	private Double toTarget; // quanto falta para o preço alvo
	private Double estimateProfitGain; // estimativa de ganhos pelo preço alvo
	private ShareType shareType; // tipo de ativo
	
	
	public Stocks(String ticker, Integer quantity, Double costBasis, Double avaragePrice, Double profitLoss,
			Double upgrading, Double percentageSharesStocks, Double quote, Double targetPrice, Double toTarget,
			Double estimateProfitGain, ShareType shareType) {
		super();
		this.ticker = ticker;
		this.quantity = quantity;
		this.costBasis = costBasis;
		this.avaragePrice = avaragePrice;
		this.profitLoss = profitLoss;
		this.upgrading = upgrading;
		this.percentageSharesStocks = percentageSharesStocks;
		this.quote = quote;
		this.targetPrice = targetPrice;
		this.toTarget = toTarget;
		this.estimateProfitGain = estimateProfitGain;
		this.shareType = shareType;
	}



}