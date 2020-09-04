package com.pnwd.account;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
public class AccountNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountNotFoundException(String id) {
		super("Could not find id : "+id);
	}

}
