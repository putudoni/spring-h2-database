package com.pnwd.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
}
