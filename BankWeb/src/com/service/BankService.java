/**
 * 
 */
package com.service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.business.BankLocal;
import com.business.entities.Account;

/**
 * @author Med
 * 29 juil. 2017
 */
@WebService
public class BankService {

	@EJB
	private BankLocal businessLayer;
	
	@WebMethod
	public Account addAccount(@WebParam(name="account") Account a) {
		return businessLayer.addAccount(a);
	}

	@WebMethod
	public Account getAccount(@WebParam(name="code") Long code) {
		return businessLayer.getAccount(code);
	}

	@WebMethod
	public List<Account> listAccounts() {
		return businessLayer.listAccounts();
	}

	@WebMethod
	public void deposit(@WebParam(name="code") Long code, @WebParam(name="amount") double amount ){
		
		businessLayer.deposit(code, amount);
	}
	
	@WebMethod
	public void withdraw(@WebParam(name="code") Long code, @WebParam(name="amount") double amount ){
		
		businessLayer.withdraw(code, amount);
	}
	
	@WebMethod
	public void transfert(@WebParam(name="from") Long from, @WebParam(name="to") Long to, @WebParam(name="amount") double amount ){
		
		businessLayer.transfert(from, to, amount);
	}
}
