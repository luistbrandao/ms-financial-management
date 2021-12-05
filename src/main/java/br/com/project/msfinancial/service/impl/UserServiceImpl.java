package br.com.project.msfinancial.service.impl;


import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.project.msfinancial.service.UserService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	public HttpResponse<String> readInfo(){
//		String bodyJson = "";
//		
//		try {
//			bodyJson = objectToJson(bodyJson);
//			log.debug("Request body: {}", bodyJson);
//		} catch (JsonProcessingException e) {
//			log.error(e.getMessage(), e);
//		}
		
		HttpResponse<String> response = Unirest.get("https://api.bitcointrade.com.br/v3/public/BRLBTC/ticker/")
				.asString();
		
		log.info("Response JSON: {}", response.toString());
		
		
		return response;
	}
	
	
	public static String objectToJson(Object classe) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(classe);
	}
}
