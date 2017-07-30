package com.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.business.entities.Account;

/**
 * Session Bean implementation class Bank
 */
@Stateless(name="BK")
@LocalBean
public class Bank implements BankRemote, BankLocal {
	
	//we specify unitName when we have multiple unit Persistence in the file persistence.xml
	@PersistenceContext(unitName="BankEJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public Bank() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Account addAccount(Account a) {
		
		em.persist(a);
		
		return a;
	}

	@Override
	public Account getAccount(Long code) {
		Account a = em.find(Account.class, code);
		if(a == null) throw new RuntimeException("Account not found");
		return a;
	}

	@Override
	public List<Account> listAccounts() {
		Query q = em.createQuery("SELECT a FROM Account a");
		
		return q.getResultList();
	}

	@Override
	public void deposit(Long code, double amount) {
		Account a = getAccount(code);
		a.setBalance(a.getBalance() + amount);
		
	}

	@Override
	public void withdraw(Long code, double amount) {
		Account a = getAccount(code);
		double balance = a.getBalance();
		if(balance < amount) throw new RuntimeException("insufficient balance");
			a.setBalance(balance - amount);
		
	}

	@Override
	public void transfert(Long from, Long to, double amount) {
		withdraw(from, amount);
		deposit(to, amount);
	}

}
