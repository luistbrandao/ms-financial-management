package br.com.project.msfinancial.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataInfo {

	public Double buy;
	public String date;
	public Double high;
	public Integer last;
	public Integer low;
	public Double sell;
	public Integer tradesQuantity;
	public Double volume;

}