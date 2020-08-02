package cs590.products.service;


import cs590.products.domain.Stock;

public class StockAdapter {
	public static Stock getStock(StockDTO stockDTO) {
		Stock stock = new Stock(
				stockDTO.getQuantity(),
				stockDTO.getLocationcode()
				);		
		return stock;				
	}
	
	public static StockDTO getStockDTO(Stock stock) {
		StockDTO stockDTO = new StockDTO(
				stock.getQuantity(),
				stock.getLocationcode()
				);		
		return stockDTO;				
	}
}