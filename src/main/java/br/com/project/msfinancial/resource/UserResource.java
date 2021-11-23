package br.com.project.msfinancial.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.msfinancial.model.User;
import br.com.project.msfinancial.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@RestController
@Slf4j
public class UserResource {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/createuser")
	public ResponseEntity<String> collectionsRequest(@RequestBody User user){
		
		
		User save = userRepository.save(user);
		if(save != null) {
			log.info("Elemento salvo: {}", save.toString());
		}
		else {
			log.info("Erro ao salvar");
		}

		return ResponseEntity.ok(user.toString());
	}
}