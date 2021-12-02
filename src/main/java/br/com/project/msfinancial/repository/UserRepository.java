package br.com.project.msfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.msfinancial.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

}
