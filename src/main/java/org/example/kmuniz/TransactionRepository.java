package org.example.kmuniz;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
	Transaction findTransactionById(long id);
	
	Collection<Transaction> findTransactionByType(String type);
	
	//Collection<Transaction> findTransactionByParent_Id(long parent_id);
}
