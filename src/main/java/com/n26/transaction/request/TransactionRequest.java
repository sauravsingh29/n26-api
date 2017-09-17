/**
 * 
 */
package com.n26.transaction.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.n26.transaction.validator.ValidTransactionTime;

/**
 * @author Saurav
 * 
 *         Transaction request will be mapped to this domain class
 *
 */
public class TransactionRequest implements Serializable {

	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = -3016629803006320917L;

	@NotNull
	private double amount;

	@ValidTransactionTime
	private long timestamp;

	public TransactionRequest() {
	}

	public TransactionRequest(double amount, long timestamp) {
		super();
		this.amount = amount;
		this.timestamp = timestamp;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
