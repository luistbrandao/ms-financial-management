package br.com.project.msfinancial.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response<T>{
	private T data;
	private List<Map<String, String>> erros;
	
	public List<Map<String, String>> getErros(){
		if (this.erros == null) {
			this.erros = new ArrayList<>(1);
		}
		return this.erros;
	}
}