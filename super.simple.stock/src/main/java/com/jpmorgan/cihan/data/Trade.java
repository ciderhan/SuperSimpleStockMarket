package com.jpmorgan.cihan.data;

import java.util.Date;

import com.jpmorgan.cihan.data.enm.TradeType;

/**
 * The Class Trade.
 *
 * @author Cihan
 */
public class Trade {

	/** The stock. */
	private Stock stock;

	/** The timestamp. */
	private Date timestamp;

	/** The quantity. */
	private int quantity;

	/** The type. */
	private TradeType type;

	/** The traded price. */
	private float tradedPrice;

	/**
	 * Gets the stock.
	 *
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * Sets the stock.
	 *
	 * @param stock
	 *            the new stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp
	 *            the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity
	 *            the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public TradeType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(TradeType type) {
		this.type = type;
	}

	/**
	 * Gets the traded price.
	 *
	 * @return the traded price
	 */
	public float getTradedPrice() {
		return tradedPrice;
	}

	/**
	 * Sets the traded price.
	 *
	 * @param tradedPrice
	 *            the new traded price
	 */
	public void setTradedPrice(float tradedPrice) {
		this.tradedPrice = tradedPrice;
	}

}
