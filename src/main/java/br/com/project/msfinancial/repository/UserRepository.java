package br.com.project.msfinancial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.msfinancial.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, String>{

	public UserInfo findByCpf(String cpf);
}
