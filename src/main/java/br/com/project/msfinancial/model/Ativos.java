package br.com.project.msfinancial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ativos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private Integer quantidade;
    private Double valorAquisicao;
    private Double precoMedio;
    private Double lucroPrejuizo;
    private Double valorizacao;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

	public Ativos(Long id, String ticker, Integer quantidade, Double valorAquisicao, Double precoMedio,
			Double lucroPrejuizo, Double valorizacao) {
		super();
		this.id = id;
		this.ticker = ticker;
		this.quantidade = quantidade;
		this.valorAquisicao = valorAquisicao;
		this.precoMedio = precoMedio;
		this.lucroPrejuizo = lucroPrejuizo;
		this.valorizacao = valorizacao;
	}
    
    

}