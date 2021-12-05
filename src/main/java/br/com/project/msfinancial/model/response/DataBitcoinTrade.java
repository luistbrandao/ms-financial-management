package br.com.project.msfinancial.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBitcoinTrade {

	public DataInfo data;
	public String message;

}