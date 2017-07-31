/**
 * 
 */
package com.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.business.BankLocal;
import com.business.entities.Account;

/**
 * @author Med
 * 30 juil. 2017
 */
@Stateless
@Path("/")
public class BankRestService {

	@EJB
	private BankLocal businessLayer;

	@POST
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public Account addAccount(Account a) {
		return businessLayer.addAccount(a);
	}

	@GET
	@Path("/accounts/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam("code") Long code) {
		return businessLayer.getAccount(code);
	}

	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> listAccounts() {
		return businessLayer.listAccounts();
	}

	@PUT
	@Path("/accounts/deposit")
	@Produces(MediaType.APPLICATION_JSON)
	public void deposit(@FormParam(value="code") Long code, @FormParam(value="amount") double amount) {
		businessLayer.deposit(code, amount);
	}

	@PUT
	@Path("/accounts/withdraw")
	@Produces(MediaType.APPLICATION_JSON)
	public void withdraw(@FormParam(value="code") Long code, @FormParam(value="amount") double amount) {
		businessLayer.withdraw(code, amount);
	}
	
	@PUT
	@Path("/accounts/transfert")
	@Produces(MediaType.APPLICATION_JSON)
	public void transfert(@FormParam(value="from") Long from, @FormParam(value="to") Long to, @FormParam(value="amount") double amount) {
		businessLayer.transfert(from, to, amount);
	}
}
