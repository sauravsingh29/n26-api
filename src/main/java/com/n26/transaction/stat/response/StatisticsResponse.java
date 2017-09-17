/**
 * 
 */
package com.n26.transaction.stat.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Saurav
 *
 */
@JsonPropertyOrder(value = { "sum", "average", "max", "mix", "count" })
public class StatisticsResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4058175433854330095L;
	private long count;
	private double sum;
	@JsonProperty("avg")
	private double average = Double.NaN;
	private double max = Double.NaN;
	private double min = Double.NaN;
	

	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(long count) {
		this.count = count;
	}

	/**
	 * @return the sum
	 */
	public double getSum() {
		return sum;
	}

	/**
	 * @param sum
	 *            the sum to set
	 */
	public void setSum(double sum) {
		this.sum = sum;
	}

	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * @param average
	 *            the average to set
	 */
	public void setAverage(double average) {
		this.average = average;
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @param min
	 *            the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

	/**
	 * @param max
	 *            the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", sum=");
		builder.append(sum);
		builder.append(", average=");
		builder.append(average);
		builder.append(", min=");
		builder.append(min);
		builder.append(", max=");
		builder.append(max);
		builder.append("count=");
		builder.append(count);
		return builder.toString();
	}

	// /**
	// * {@inheritDoc}
	// *
	// * Returns a non-empty string representation of this object suitable for
	// * debugging. The exact presentation format is unspecified and may vary
	// * between implementations and versions.
	// */
	// @Override
	// public String toString() {
	// return String.format("sum=%f, average=%f, max=%f, min=%f, count=%d ",
	// getSum(), getAverage(), getMax(),
	// getMin(), getCount());
	// }

}
