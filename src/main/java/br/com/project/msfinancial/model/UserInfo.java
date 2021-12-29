package br.com.project.msfinancial.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7254480324756131123L;

	@Id
	@Column(unique = true)
	private String cpf;
    private String name;
    private String email;
    private String phoneNumber;
    
//    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "user_info_id", referencedColumnName = "id")
//    private MainIncome income;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id", referencedColumnName = "cpf")
    private List<Stocks> stocks;

    
}