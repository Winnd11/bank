package org.william.bank.service;

import org.springframework.stereotype.Service;
import org.william.bank.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;
}
