package com.springboot.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.model.Bills;
import com.springboot.model.Coins;

@Component
public class BillCoinCalculation {
	
	private List<Bills> billList;
	private List<Coins> coinList;
	
	
	public void setCoinList(List<Coins> coinList) {
		this.coinList = coinList;
	}
	public List<Bills> getBillList() {
		return billList;
	}
	public void setBillList(List<Bills> billList) {
		this.billList = billList;
	}
	
	public List<Coins> getCoinList() {
		coinList =new ArrayList<Coins>();
		coinList.add(new Coins(.25,100));
		coinList.add(new Coins(.10,100));
		coinList.add(new Coins(.05,100));
		coinList.add(new Coins(.01,100));
			
		return coinList;
	}
	
	public List<Coins> getBillCoinList(Float billvalue) {
		
		List<Coins> list = new ArrayList<Coins>();
		int penny =0;
		int nickel =0;
		int dime =0;
		int quarter =0;
		
		
		for(Coins coin : coinList ) {
			
			int remainder=0;
			if(billvalue > 0) {
			
			
			if(coin.getCoinType()==.25 && coin.getNoOfCoins() >0) {
				
				quarter = (int) (billvalue/0.25);	
				
				if(quarter <= coin.getNoOfCoins()) {				
				list.add(new Coins(.25,quarter));
				remainder = (int) (billvalue % 0.25);
				billvalue = (float) ((billvalue - (quarter*0.25)) + remainder) ;
				coinList.set(0, new Coins(.25,coin.getNoOfCoins()-quarter));
				}else if(quarter<=100){
			    list.add(new Coins(.25,coin.getNoOfCoins()));	
				billvalue = (float) ((billvalue - (coin.getNoOfCoins()*0.25)) + remainder);
				coinList.set(0, new Coins(.25,0));
				}
				
			}
			else if(coin.getCoinType()==.10 && coin.getNoOfCoins()>0) {
				dime = (int) (billvalue/0.10);				
				if(dime <= coin.getNoOfCoins()) {				
					list.add(new Coins(.10,dime));	
					remainder = (int) (billvalue % 0.10);
					billvalue = (float) ((billvalue - (dime*0.10)) + remainder);
					coinList.set(1, new Coins(.10,coin.getNoOfCoins()-dime));
				}else if(dime<=100){
				    list.add(new Coins(.10,coin.getNoOfCoins()));	
					billvalue = (float) ((billvalue - (coin.getNoOfCoins()*0.10)) + remainder);
					coinList.set(1, new Coins(.10,0));
					}	
			}
			else if(coin.getCoinType()==.05 && coin.getNoOfCoins()>0) {
				
				nickel = (int) (billvalue/0.05);				
				if(nickel <= coin.getNoOfCoins()) {				
					list.add(new Coins(.05,nickel));	
					remainder = (int) (billvalue % 0.05);
					billvalue = (float) ((billvalue - (nickel*0.05)) + remainder);
					coinList.set(2, new Coins(.05,coin.getNoOfCoins()-nickel));
				}else if(nickel<=100){
				    list.add(new Coins(.05,coin.getNoOfCoins()));	
					billvalue = (float) ((billvalue - (coin.getNoOfCoins()*0.05)) + remainder);
					coinList.set(2, new Coins(.05,0));
					}
			}
			else if(coin.getCoinType()==.01 && coin.getNoOfCoins()>0) {
				penny = (int) (billvalue/0.01);	
				
				if(penny <= coin.getNoOfCoins()) {				
					list.add(new Coins(.01,penny));
					remainder = (int) (billvalue % 0.01);
					billvalue = (float) ((billvalue - (penny*0.01)) + remainder);
					coinList.set(3, new Coins(.01,coin.getNoOfCoins()-penny));
				   }else if(penny<=100){
				    list.add(new Coins(.01,coin.getNoOfCoins()));	
					billvalue = (float) ((billvalue - (coin.getNoOfCoins()*0.01)) + remainder);
					coinList.set(3, new Coins(.01,coin.getNoOfCoins()-penny));
					}
				   
				   if(penny > 100){
					list.add(new Coins(.01,100));
					coinList.set(3, new Coins(.01,0));
					System.out.println("WE DONT HAVE ENOUGH COINS ");
					}
			}
			
		}
		}	
		
		return list;
	}
	
	
	

}
