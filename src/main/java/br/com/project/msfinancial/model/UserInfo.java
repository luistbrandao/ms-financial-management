package br.com.project.msfinancial.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class UserInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7254480324756131123L;
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String name;
    @Id
    @Column(unique = true)
    private String cpf;
//    private String phoneNumber;
//    private String creditCard;
//    private String birthday;
    private String email;
//    private char sex;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<MonthSpendInfo> monthSpendInfos;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userinfo_id", referencedColumnName = "cpf")
    private List<Stocks> stocks;

}