package br.com.project.msfinancial.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.msfinancial.model.Usuario;
import br.com.project.msfinancial.repository.UserRepository;

@Service
@RestController
public class UserResource {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/createuser")
	public ResponseEntity<String> collectionsRequest(@RequestBody Usuario user, BindingResult result){
		
		
		Usuario save = userRepository.save(user);
		if(save != null) {
			System.out.println("Elemento salvo: " +save.toString());
		}
		else {
			System.out.println("não funcionou");
		}

		return ResponseEntity.ok(user.toString());
	}
}