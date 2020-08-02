package cs590.products.service;

import cs590.products.domain.Product;
import cs590.products.domain.Stock;
import cs590.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ProductCatalogService {
	@Autowired
	ProductRepository productRepository;

	public void addProduct(String productnumber, String description, double price) {
		Product product = new Product(productnumber, description,  price);
		productRepository.save(product);
		
	}
	public ProductDTO getProduct(String productnumber) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent())
		  return ProductAdapter.getProductDTO(result.get());
		else
			return null;
	}
	public void setStock(String productnumber, int quantity, String locationcode) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = new Stock(quantity, locationcode);
			product.setStock(stock);
			productRepository.save(product);
		}		
	}
}
