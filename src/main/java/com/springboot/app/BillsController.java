package com.springboot.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exception.NoRecordException;
import com.springboot.model.Coins;

@RestController
public class BillsController {
	
	
	
	
	@Autowired
	BillCoinCalculation billCoinCalculation;
	
	
	@GetMapping("/getCoins")
	public List<Coins> getListOfCoins(){
		
		return billCoinCalculation.getCoinList();		
		
	}
	@GetMapping(path="/getCoins/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Coins>> getChangeOfBills(@PathVariable("id") Float billValue) {
						
			List<Coins> list = billCoinCalculation.getBillCoinList(billValue);
			if (list.isEmpty()) {
				throw new NoRecordException("No Content");
	        }else {
	         return new ResponseEntity<>(list, HttpStatus.OK);
	        }
			
	
		
	}

}
