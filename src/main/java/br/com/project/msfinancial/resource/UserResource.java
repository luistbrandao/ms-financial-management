package br.com.project.msfinancial.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.project.msfinancial.model.Response;
import br.com.project.msfinancial.model.UserInfo;
import br.com.project.msfinancial.repository.UserRepository;
import br.com.project.msfinancial.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import kong.unirest.HttpResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@RestController
@Slf4j
@Tag(name = "User")
public class UserResource {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

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

	@PutMapping("/updateUser/{cpf}")
	public ResponseEntity<String> userUpdate(@PathVariable String cpf, @RequestBody UserInfo userInfo) {

		Optional<UserInfo> findById = userRepository.findById(cpf);
		if (!findById.isEmpty()) {
			userInfo.setName(userInfo.getName());
			userInfo.setEmail(userInfo.getEmail());
			userInfo.setStocks(userInfo.getStocks());
			UserInfo update = userRepository.save(userInfo);
			if (update != null) {
				log.info("Updated user: {}", update.toString());
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
	
	
	
	
//	BITCOINTRADE API TEST
	
	
	
	@GetMapping("/readBitcoinTrade")
	public ResponseEntity<Response<String>> read() throws JsonMappingException, JsonProcessingException{
		
		Response<String> response = new Response<>();
		Map<String, String> erros = new HashMap<>();
				
		HttpResponse<String> readInfo;
//		ObjectMapper objectMapper = new ObjectMapper();
		try {
			readInfo = userService.readInfo();
			response.setData(readInfo.getBody());
		} catch (Exception e) {
			erros.put(e.getMessage(), e.getLocalizedMessage());
		} finally {
			if (!erros.isEmpty()) {
				response.getErros().add(erros);
				return ResponseEntity.badRequest().body(response);
			}

		}
//		DataInfo dataInfo = objectMapper.readValue(response.getData(), DataInfo.class);
		log.info("response: {}", response.getData());
//		log.info("Data info: {}", dataInfo.toString());
		
		return ResponseEntity.ok(response);
	}
}