package org.example.kmuniz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/transactionservice")
public class WebController {
	
	private static final Logger log = LoggerFactory.getLogger(WebController.class);
	
	@Autowired
	private TransactionRepository repository;
	
	/**
	 * Only for test
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody Collection<Transaction> getTransactions(){
		log.info("list All");
		return repository.findAll();
	}
	
	/**
	 *  PUT /transactionservice/transaction/$transaction_id
	 *  Body: { "amount":double,"type":string,"parent_id":long } 
	 */
	@RequestMapping(value = "/transaction/{transaction_id}", method = RequestMethod.PUT)
	public @ResponseBody Transaction setTransaction(@PathVariable long transaction_id, 
			@PathVariable double amount,
			@PathVariable String type){
		
		Transaction transaction = new Transaction(amount, type, transaction_id);
		return repository.save(transaction);
	}
	
	/**
	 * Find transaction by Id
	 * GET /transactionservice/transaction/$transaction_id
	 * Returns: { "amount":double,"type":string,"parent_id":long } 
	 * @return
	 */
	@RequestMapping(value = "/transaction/{transaction_id}", method = RequestMethod.GET)
	public @ResponseBody Transaction getTransaction(@PathVariable long transaction_id){
		
		return repository.findTransactionById(transaction_id);
	}
	
	/**
	 * Get Transactions by type
	 * GET /transactionservice/types/$type
	 * Returns: [ long, long, .... ] 
	 * @return
	 */
	@RequestMapping(value = "/types/{type}", method = RequestMethod.GET)
	public @ResponseBody List<Long> getTransactionByType(@PathVariable String type){
		
		List<Long> typeList = new ArrayList<>();
		
		for( Transaction trans : repository.findTransactionByType(type)){
			typeList.add(trans.getId());
		}
		
		return typeList;
	}
	
	/**
	 * Sum all parent transaction
	 * GET /transactionservice/sum/$transaction_id
	 * Returns { "sum", double }
	 * @return
	 */
	@RequestMapping(value = "/sum/{transaction_id} ", method = RequestMethod.GET)
	public @ResponseBody double sum(@PathVariable long transaction_id){
		double sum = 0;
		
//		for( Transaction trans : repository.findTransactionByParent_Id(transaction_id)){
//			sum += trans.getAmount();
//		}
		return sum;
	}

	public TransactionRepository getRepository() {
		return repository;
	}

	public void setRepository(TransactionRepository repository) {
		this.repository = repository;
	}
	
	
}
