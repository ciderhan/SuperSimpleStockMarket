package com.jpmorgan.cihan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jpmorgan.cihan.data.Stock;
import com.jpmorgan.cihan.data.Trade;
import com.jpmorgan.cihan.data.enm.StockType;
import com.jpmorgan.cihan.data.enm.TradeType;

/**
 * The Class StockManager.
 *
 * @author Cihan
 */
public class StockManager {

	/** The stock map. */
	private Map<String, Stock> stockMap = new HashMap<String, Stock>();

	/** The trade map. */
	private Map<Stock, List<Trade>> tradeMap = new HashMap<Stock, List<Trade>>();

	/**
	 * Instantiates a new stock manager.
	 */
	public StockManager() {
	}

	/**
	 * For a given stock, Given any price as input, calculates the dividend
	 * yield.
	 *
	 * @param stock
	 *            the stock
	 * @param price
	 *            the price
	 * @return the float
	 */
	public float calculateDividendYield(Stock stock, float price) {
		if (stock.getType() == StockType.COMMON) {
			return stock.getLastDividend() / price;
		} else {
			return ((stock.getFixedDividend() / 100) * stock.getParValue()) / price;
		}
	}

	/**
	 * For a given stock, Given any price as input, calculates the P/E Ratio.
	 *
	 * @param stock
	 *            the stock
	 * @param price
	 *            the price
	 * @return the float
	 */
	public float calculatePERatio(Stock stock, float price) {
		float divider = calculateDividendYield(stock, price);
		if (divider == 0) {
			return 0;
		}
		return price / divider;
	}

	/**
	 * For a given stock, Record a trade, with timestamp, quantity of shares,
	 * buy or sell indicator and traded price.
	 *
	 * @param stock
	 *            the stock
	 * @param price
	 *            the price
	 * @param type
	 *            the type
	 * @param quantity
	 *            the quantity
	 * @return 
	 */
	public Trade recordTrade(Stock stock, float price, TradeType type, int quantity) {
		Trade trade = new Trade();
		trade.setStock(stock);
		trade.setQuantity(quantity);
		trade.setTimestamp(new Date());
		trade.setType(type);
		trade.setTradedPrice(price);

		List<Trade> list = tradeMap.get(stock);
		if (list == null) {
			list = new ArrayList<>();
		}

		list.add(trade);
		tradeMap.put(stock, list);
		
		return trade;
	}

	/**
	 * For a given stock, Calculate Volume Weighted Stock Price based on trades
	 * in past 15 minutes.
	 *
	 * @param stock
	 *            the stock
	 * @param durationMinute
	 *            the duration minute
	 * @return the double
	 */
	public double calculateVolumeWeightedStockPrice(Stock stock, int durationMinute) {
		List<Trade> list = tradeMap.get(stock);

		if (list == null)
			return 0;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MINUTE, (-1) * durationMinute);

		Date fromTime = calendar.getTime();

		double totalPriceQuantity = 0;
		double totalQuantity = 0;
		for (Trade trade : list) {
			if (trade.getTimestamp().after(fromTime)) {
				totalPriceQuantity += trade.getTradedPrice() * trade.getQuantity();
				totalQuantity += trade.getQuantity();
			}
		}

		return totalPriceQuantity / totalQuantity;
	}

	/**
	 * Calculate the GBCE All Share Index using the geometric mean of prices for
	 * all stocks.
	 *
	 * @return the double
	 */
	public double calculateGBCEAllShareIndex() {

		double multiplied = 1;
		int stockCounter = 0;
		for (Stock stock : stockMap.values()) {
			double stockPrice = calculateVolumeWeightedStockPrice(stock, 15);
			if (stockPrice > 0) {
				multiplied *= stockPrice;
				stockCounter++;
			}
		}

		return Math.pow(multiplied, ((double) 1 / stockCounter));
	}

	/**
	 * Adds the stock.
	 *
	 * @param stock
	 *            the stock
	 */
	public void addStock(Stock stock) {
		stockMap.put(stock.getSymbol(), stock);
	}

	/**
	 * Gets the stock.
	 *
	 * @param symbol
	 *            the symbol
	 * @return the stock
	 */
	public Stock getStock(String symbol) {
		return stockMap.get(symbol);
	}
}