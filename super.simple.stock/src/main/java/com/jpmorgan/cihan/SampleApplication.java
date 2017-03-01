package com.jpmorgan.cihan;

import java.util.logging.Logger;

import com.jpmorgan.cihan.data.Stock;
import com.jpmorgan.cihan.data.Trade;
import com.jpmorgan.cihan.data.enm.StockType;
import com.jpmorgan.cihan.data.enm.TradeType;

/**
 * @author Cihan
 *
 */
public class SampleApplication {

	private static Logger logger = Logger.getLogger(SampleApplication.class.getSimpleName());
	public SampleApplication() {

	}

	public static void main(String[] args) {
		StockManager sm = new StockManager();

		Stock s = new Stock("TEA", StockType.COMMON, 0, 0, 100);
		sm.addStock(s);
		s = new Stock("POP", StockType.COMMON, 8, 0, 100);
		sm.addStock(s);
		s = new Stock("ALE", StockType.COMMON, 23, 0, 60);
		sm.addStock(s);
		s = new Stock("GIN", StockType.PREFERRED, 8, 2, 100);
		sm.addStock(s);
		s = new Stock("JOE", StockType.COMMON, 13, 0, 250);
		sm.addStock(s);

		Stock stock = sm.getStock("POP");

		// Req# 1./a./i.
		double value = sm.calculateDividendYield(stock, 15f);
		logger.info(String.format("Stock:%s Price:%f Dividend Yield=%f", stock.getSymbol(), 15f, value));

		// Req# 1./a./ii.
		value = sm.calculatePERatio(stock, 15f);
		logger.info(String.format("Stock:%s Price:%f P/E Ratio=%f", stock.getSymbol(), 15f, value));

		// Req# 1./a./iii.
		Trade trade = sm.recordTrade(sm.getStock("POP"), 14f, TradeType.BUY, 1000);
		logger.info(String.format("TRADE: %s - %s - Quantity:%d", trade.getStock().getSymbol(), trade.getType().name(), trade.getQuantity()));
		
		trade = sm.recordTrade(sm.getStock("POP"), 13.5f, TradeType.SELL, 200);
		logger.info(String.format("TRADE: %s - %s - Quantity:%d", trade.getStock().getSymbol(), trade.getType().name(), trade.getQuantity()));
		
		trade = sm.recordTrade(sm.getStock("POP"), 16, TradeType.BUY, 300);
		logger.info(String.format("TRADE: %s - %s - Quantity:%d", trade.getStock().getSymbol(), trade.getType().name(), trade.getQuantity()));
		
		trade = sm.recordTrade(sm.getStock("TEA"), 14, TradeType.BUY, 1000);
		logger.info(String.format("TRADE: %s - %s - Quantity:%d", trade.getStock().getSymbol(), trade.getType().name(), trade.getQuantity()));
		
		trade = sm.recordTrade(sm.getStock("ALE"), 13.5f, TradeType.BUY, 2000);
		logger.info(String.format("TRADE: %s - %s - Quantity:%d", trade.getStock().getSymbol(), trade.getType().name(), trade.getQuantity()));
		
		trade = sm.recordTrade(sm.getStock("ALE"), 13.5f, TradeType.SELL, 200);
		logger.info(String.format("TRADE: %s - %s - Quantity:%d", trade.getStock().getSymbol(), trade.getType().name(), trade.getQuantity()));
		
		trade = sm.recordTrade(sm.getStock("GIN"), 16, TradeType.BUY, 300);
		logger.info(String.format("TRADE: %s - %s - Quantity:%d", trade.getStock().getSymbol(), trade.getType().name(), trade.getQuantity()));
		
		// Req# 1./a./iv.
		value = sm.calculateVolumeWeightedStockPrice(stock, 15);
		logger.info(String.format("Stock:%s Price:%f Volume Weighted Stock Price=%f", stock.getSymbol(), 15f, value));

		// Req# 1./b.
		value = sm.calculateGBCEAllShareIndex();
		logger.info(String.format("GBCE All Share Index=%f", value));
	}
}