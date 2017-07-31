/**
 * 
 */
package com.bank.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.business.BankRemote;
import com.business.entities.Account;

/**
 * @author Med
 * 27 juil. 2017
 */
public class RemoteClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Context ctx = new InitialContext();
			
			String appName = "BankEAR";
			String moduleName = "BankEJB";
			String beanName = "BK";
			String remoteInterface = BankRemote.class.getName();
			String name = "ejb:"+appName+"/"+moduleName+"//"+beanName+"!"+remoteInterface;
			
			BankRemote proxy = (BankRemote) ctx.lookup(name);
			
			proxy.addAccount(new Account(100));
			proxy.addAccount(new Account(300));
			proxy.addAccount(new Account(700));
//			Account a1 = proxy.getAccount(1L);
//			System.out.println(a1.getBalance());
//			proxy.deposit(1L, 1500);
//			proxy.withdraw(1L, 1000);
//			proxy.transfer(1L, 2L, 1000);
			
//			Account a1 = proxy.getAccount(1L);
//			System.out.println(a1.getBalance());
//			Account a2 = proxy.getAccount(2L);
//			System.out.println(a2.getBalance());
			List<Account> accounts = proxy.listAccounts();
			accounts.forEach(account -> System.out.println(account.getCode()+" : "+ account.getBalance()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
