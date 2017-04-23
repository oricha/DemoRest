package org.example.repository;

import java.util.Collection;

import org.example.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Transaction findTransactionById(long id);
	
	Collection<Transaction> findTransactionByType(String type);
	
	Collection<Transaction> findTransactionByParent(long parent);
}
