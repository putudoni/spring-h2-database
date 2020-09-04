package com.pnwd.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void run(String... args) throws Exception {
		List<Account> listAccount = new ArrayList<>();
		Account account = new Account();
		for (int i = 1; i <= 10; i++) {
			account = new Account();
			account.setName("Account"+i);
			account.setEmail("account"+i+"@mail.com");
			listAccount.add(account);
		}
		accountRepository.saveAll(listAccount);
	}

}
