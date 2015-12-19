package org.example.kmuniz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id; //is a long specifying a new transaction
	
	private double amount; //is a double specifying the amount
	
	private String type; //is a string specifying a type of the transaction.
	
	private long parent ; // is an optional long that may specify the parent transaction of this transaction. 
	/* I had renamed an entity property. Spring automatically creates a query for each attribute. First it create
	 * a query for Id and then with parent_Id its not recognize the second query.
	 * */
	
	public Transaction(){}
	
	public Transaction (double amount, String type, long parent_id){
		this.amount = amount;
		this.type = type;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public long getParent() {
		return parent;
	}

	public void setParent(long parent) {
		this.parent = parent;
	}


}
