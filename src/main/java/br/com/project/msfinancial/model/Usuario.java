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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7254480324756131123L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
//    private String phoneNumber;
//    private String creditCard;
//    private String birthday;
//    private String email;
//    private char sex;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<MonthSpendInfo> monthSpendInfos;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Stocks> stocks;

}