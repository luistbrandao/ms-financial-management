package br.com.project.msfinancial.service;

import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;

@Service
public interface UserService {

	public HttpResponse<String> readInfo();
}
