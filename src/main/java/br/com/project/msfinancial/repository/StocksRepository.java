package br.com.project.msfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.msfinancial.model.Stocks;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, String>{

//	@Query(value = "select * from msfinancial.user_info ui inner join msfinancial.stocks s on ui.? = s.user_cpf")
//	public UserInfo findByTicker(@Param("cpf") String cpf);
}
