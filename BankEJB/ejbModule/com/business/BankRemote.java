package com.business;

import java.util.List;

import javax.ejb.Remote;

import com.business.entities.Account;

@Remote
public interface BankRemote {

	public Account addAccount(Account a);
	public Account getAccount(Long code);
	public List<Account> listAccounts();
	
	public void deposit(Long code, double amount);
	public void withdraw(Long code, double amount);
	public void transfer(Long from, Long to, double amount);
}
