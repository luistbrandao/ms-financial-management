//package br.com.project.msfinancial.resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.project.msfinancial.model.Stocks;
//import br.com.project.msfinancial.model.UserInfo;
//import br.com.project.msfinancial.repository.StocksRepository;
//import br.com.project.msfinancial.repository.UserRepository;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@RestController
//@Slf4j
//@Tag(name = "Stocks")
//public class StocksResource {
//
//	@Autowired
//	StocksRepository stocksRepository;
//
//	@Autowired
//	UserRepository userRepository;
//
//	@PostMapping("/createTicker")
//	public ResponseEntity<String> stocksCreateRequest(@RequestBody Stocks stocks) {
//
//		Stocks save = stocksRepository.save(stocks);
//		if (save != null) {
//			log.info("Saved data: {}", save.toString());
//		} else {
//			log.info("Error saving entity: {}", stocks.toString());
//		}
//
//		return ResponseEntity.ok(stocks.toString());
//	}
//
//	@PutMapping("/updateStock/{cpf}")
//	public ResponseEntity<String> stocksUpdate(@PathVariable String cpf, @RequestBody UserInfo userInfo) {
//
//		UserInfo findByCpf = userRepository.findByCpf(cpf);
//		if (findByCpf != null) {
//			log.info("User found! {}", findByCpf.getCpf());
//			userInfo.setCpf(findByCpf.getCpf());
//			userInfo.setEmail(findByCpf.getEmail());
//			userInfo.setName(findByCpf.getName());
//			userInfo.setStocks(findByCpf.getStocks());
//			UserInfo save = userRepository.save(userInfo);
//			log.info("Stocks updated! {}", save.toString());
//			return ResponseEntity.ok(userInfo.toString());
//		}
//
//		else {
//			log.info("Error to find CPF");
//			return ResponseEntity.ok("erro");
//		}
//	}
//
////	@SuppressWarnings("unchecked")
////	@GetMapping("/listAllUsers")
////	public ResponseEntity<String> listAllUsers(){	
////		List<UserInfo> findAll = userRepository.findAll();
////		if(findAll == null) {
////			log.info("No user registered yet");
////			return (ResponseEntity<String>) ResponseEntity.notFound();
////		}
////		else {
////			log.info("Users registred: {}", findAll.toString());
////			return ResponseEntity.ok(findAll.toString());
////		}
////	}
////	
////	@GetMapping("/findUser/{cpf}")
////	public ResponseEntity<String> findUser(@RequestParam String cpf){
////		Optional<UserInfo> findById = userRepository.findById(cpf);
////		if(!findById.isEmpty()) {
////			log.info("User '"+ findById.get().getName()+"' found!");
////			log.info("User data: {}", findById.toString());
////			return ResponseEntity.ok(findById.toString());
////		}
////		else {
////			log.info("User not found with cpf = '"+cpf+"'");
////			return ResponseEntity.ok("Erro");
////		}
////	}
//
//}