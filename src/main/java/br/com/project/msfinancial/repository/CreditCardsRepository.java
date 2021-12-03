package br.com.project.msfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.msfinancial.model.CreditCards;

@Repository
public interface CreditCardsRepository extends JpaRepository<CreditCards, Long>{

}
