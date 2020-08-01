package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import shop.customers.service.AddressDTO;
import shop.customers.service.CustomerDTO;
import shop.order.service.OrderDTO;
import shop.products.domain.Product;
import shop.products.service.ProductDTO;
import shop.shopping.service.ShoppingCartDTO;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		//create customer
		CustomerDTO customerDto = new CustomerDTO("101","Frank","Brown","fBrown@Hotmail.com","123456");
		AddressDTO addressDTO = new AddressDTO("1000 N main Street", "Fairfield","52557","USA");
		customerDto.setAddress(addressDTO);
		//todo: call the customer component to add the customer
		restTemplate.postForObject("http://localhost:8080/customer", customerDto, CustomerDTO.class);

		// get customer
		//todo: call the customer component to get the customer with id 101 and print the result
		CustomerDTO customerDTO= restTemplate.getForObject("http://localhost:8080/customer/101", CustomerDTO.class);
		System.out.println(customerDTO);
		System.out.println("\n-------------------------------------------------------------------------------------");
		
		//create products
		String createProductUrl = "http://localhost:8080/product/{productnumber}/{description}/{price}";

		//product 1
		Map<String, String> product1 = new HashMap<>();
		product1.put("productnumber", "201");
		product1.put("description", "16 inch Mac book Laptop");
		product1.put("price", "2700");
		//product 2
		Map<String, String> product2 = new HashMap<>();
		product2.put("productnumber", "202");
		product2.put("description", "I Phone 11 pro Max");
		product2.put("price", "1300");
		
		//todo: call the product component to create the first product
		restTemplate.postForObject(createProductUrl, null, ResponseEntity.class, product1);

		//todo: call the product component to create the second product
		restTemplate.postForObject(createProductUrl, null, ResponseEntity.class, product2);

		//set stock
		String setStockUrl = "http://localhost:8080/product/stock/{productnumber}/{quantity}/{locationcode}";
		//Stock 1
		Map<String, String> stock1 = new HashMap<>();
		stock1.put("productnumber", "201");
		stock1.put("quantity", "100");
		stock1.put("locationcode", "100");
		//Stock 2
		Map<String, String> stock2 = new HashMap<>();
		stock2.put("productnumber", "202");
		stock2.put("quantity", "50");
		stock2.put("locationcode", "200");

		//todo: call the product component to set the stock for the first product
		restTemplate.postForObject(setStockUrl, null, ResponseEntity.class, stock1);
		restTemplate.postForObject(setStockUrl, null, ResponseEntity.class, stock2);

		//get a product
		//todo: call the product component to get the the first product and print the result
		String getProductUrl = "http://localhost:8080/product/{productnumber}";
		String productnumber = "201";

		restTemplate.getForEntity(getProductUrl, ProductDTO.class, productnumber).getBody().print();
		System.out.println("\n-------------------------------------------------------------------------------------");
		
		// add products to the shoppingcart
		String addToCartUrl = "http://localhost:8080/cart/{cartId}/{productnumber}/{quantity}";

		//todo: call the shopping component to add the first product to the cart
		Map<String, String> cartProduct1 = new HashMap<>();
		cartProduct1.put("cartId", "501");
		cartProduct1.put("productnumber", "201");
		cartProduct1.put("quantity", "10");

		restTemplate.postForObject(addToCartUrl, null, ResponseEntity.class, cartProduct1);
		//todo: call the shopping component to add the second product to the cart
		Map<String, String> cartProduct2 = new HashMap<>();
		cartProduct2.put("cartId", "501");
		cartProduct2.put("productnumber", "202");
		cartProduct2.put("quantity", "40");

		restTemplate.postForObject(addToCartUrl, null, ResponseEntity.class, cartProduct2);

		//get the shoppingcart
		String getCartUrl = "http://localhost:8080/cart/{cartId}";
		//todo: call the shopping component to get the cart and print the result
		String cartId = "501";
		restTemplate.getForObject(getCartUrl, ShoppingCartDTO.class, cartId).print();
		System.out.println("\n-------------------------------------------------------------------------------------");

		//checkout the cart
		String checkoutCartUrl = "http://localhost:8080/cart/checkout/{cartId}";
		//todo: call the shopping component to checkout the cart
		restTemplate.postForObject(checkoutCartUrl, null, ResponseEntity.class, cartId);
		
		//get the order
		String getOrderUrl = "http://localhost:8080/order/{orderNumber}";
		//todo: call the order component to get the order and print the result
		String orderNumber = "501";
		restTemplate.getForObject(getOrderUrl, OrderDTO.class, orderNumber).print();
		System.out.println("\n-------------------------------------------------------------------------------------");
		
		//add customer to order
		String addCustomerToOrderUrl = "http://localhost:8080/order/setCustomer/{orderNumber}/{customerNumber}";
		//todo: call the order component to add a customer to the order
		Map<String, String> addCustomerToOrder = new HashMap<>();
		addCustomerToOrder.put("orderNumber", "501");
		addCustomerToOrder.put("customerNumber", "101");
		restTemplate.postForObject(addCustomerToOrderUrl, null, OrderDTO.class, addCustomerToOrder);

		//confirm the order
		String confirmOrderUrl = "http://localhost:8080/order/{orderNumber}";
		//todo: call the order component to confirm the order
		restTemplate.postForObject(confirmOrderUrl, null, Void.class, orderNumber);
		System.out.println("\n-------------------------------------------------------------------------------------");
		
		//get the order
		//todo: call the order component to get the order and print the result
		restTemplate.getForObject(getOrderUrl, OrderDTO.class, orderNumber).print();
		
	}


}
