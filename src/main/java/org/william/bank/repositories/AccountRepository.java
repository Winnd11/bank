package org.william.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.william.bank.entites.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
