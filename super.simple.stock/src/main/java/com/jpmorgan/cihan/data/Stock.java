package com.jpmorgan.cihan.data;

import com.jpmorgan.cihan.data.enm.StockType;

/**
 * The Class Stock.
 */
public class Stock {

	/** The symbol. */
	private String symbol;

	/** The type. */
	private StockType type;

	/** The last dividend. */
	private float lastDividend;

	/** The fixed dividend. */
	private float fixedDividend;

	/** The par value. */
	private int parValue;

	/**
	 * Instantiates a new stock.
	 *
	 * @param symbol
	 *            the symbol
	 * @param type
	 *            the type
	 * @param lastDividend
	 *            the last dividend
	 * @param fixedDividend
	 *            the fixed dividend
	 * @param parValue
	 *            the par value
	 */
	public Stock(String symbol, StockType type, int lastDividend, int fixedDividend, int parValue) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	/**
	 * Gets the symbol.
	 *
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Sets the symbol.
	 *
	 * @param symbol
	 *            the new symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public StockType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(StockType type) {
		this.type = type;
	}

	/**
	 * Gets the last dividend.
	 *
	 * @return the last dividend
	 */
	public float getLastDividend() {
		return lastDividend;
	}

	/**
	 * Sets the last dividend.
	 *
	 * @param lastDividend
	 *            the new last dividend
	 */
	public void setLastDividend(float lastDividend) {
		this.lastDividend = lastDividend;
	}

	/**
	 * Gets the fixed dividend.
	 *
	 * @return the fixed dividend
	 */
	public float getFixedDividend() {
		return fixedDividend;
	}

	/**
	 * Sets the fixed dividend.
	 *
	 * @param fixedDividend
	 *            the new fixed dividend
	 */
	public void setFixedDividend(float fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	/**
	 * Gets the par value.
	 *
	 * @return the par value
	 */
	public int getParValue() {
		return parValue;
	}

	/**
	 * Sets the par value.
	 *
	 * @param parValue
	 *            the new par value
	 */
	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

}
