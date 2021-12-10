package br.com.project.msfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.msfinancial.model.MainIncome;

@Repository
public interface MainIncomeRepository extends JpaRepository<MainIncome, Long>{

}
