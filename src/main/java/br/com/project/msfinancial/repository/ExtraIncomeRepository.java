package br.com.project.msfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.msfinancial.model.ExtraIncome;

@Repository
public interface ExtraIncomeRepository extends JpaRepository<ExtraIncome, Long>{

}
