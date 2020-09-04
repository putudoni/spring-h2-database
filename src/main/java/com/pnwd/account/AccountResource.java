package com.pnwd.account;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping
	public ResponseEntity<List<Account>> list(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size){
		Pageable paging = PageRequest.of(page, size);
		Page<Account> accountList = accountRepository.findAll(paging);
		return ResponseEntity.ok(accountList.getContent());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Account account){
		Account savedAccount = accountRepository.save(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAccount.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> detail(@PathVariable("id") String id){
		return ResponseEntity.ok(accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id)));
	}
	
}
