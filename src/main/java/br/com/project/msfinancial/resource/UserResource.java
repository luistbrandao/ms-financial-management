package br.com.project.msfinancial.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.msfinancial.model.UserInfo;
import br.com.project.msfinancial.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Service
@RestController
@Slf4j
@Tag(name = "User")
public class UserResource {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/createUser")
	public ResponseEntity<String> userCreateRequest(@RequestBody UserInfo user) {

		UserInfo save = userRepository.save(user);
		if (save != null) {
			log.info("Saved data: {}", save.toString());
		} else {
			log.info("Error saving entity '" + user + "': {}");
		}

		return ResponseEntity.ok(user.toString());
	}

	@PutMapping("/updateUser")
	public ResponseEntity<String> userUpdate(@RequestBody UserInfo userInfo) {

		Optional<UserInfo> findById = userRepository.findById(userInfo.getCpf());
		if (!findById.isEmpty()) {
			userInfo.setName(userInfo.getName());
			userInfo.setEmail(userInfo.getEmail());
			userInfo.setStocks(userInfo.getStocks());
			UserInfo update = userRepository.save(userInfo);
			if (update != null) {
				log.info("Updated user name: {}", update.toString());
				return ResponseEntity.ok(update.toString());
			} else {
				log.info("Error at update user");
				return ResponseEntity.ok("Erro");
			}
		}
		else {
			log.info("User not found");
			return ResponseEntity.ok("Erro");
		}
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/listAllUsers")
	public ResponseEntity<String> listAllUsers(){	
		List<UserInfo> findAll = userRepository.findAll();
		if(findAll == null) {
			log.info("No user registered yet");
			return (ResponseEntity<String>) ResponseEntity.notFound();
		}
		else {
			log.info("Users registred: {}", findAll.toString());
			return ResponseEntity.ok(findAll.toString());
		}
	}
	
	@GetMapping("/findUser/{cpf}")
	public ResponseEntity<String> findUser(@RequestParam String cpf){
		Optional<UserInfo> findById = userRepository.findById(cpf);
		if(!findById.isEmpty()) {
			log.info("User '"+ findById.get().getName()+"' found!");
			log.info("User data: {}", findById.toString());
			return ResponseEntity.ok(findById.toString());
		}
		else {
			log.info("User not found with cpf = '"+cpf+"'");
			return ResponseEntity.ok("Erro");
		}
	}
}