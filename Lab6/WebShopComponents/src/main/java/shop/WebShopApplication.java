package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import shop.customers.service.AddressDTO;
import shop.customers.service.CustomerDTO;
import shop.order.service.OrderDTO;
import shop.products.service.ProductDTO;
import shop.shopping.service.ShoppingCartDTO;

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

		// get customer
		//todo: call the customer component to get the customer with id 101 and print the result
		
		//create products
		
		//todo: call the product component to create the first product 
		//todo: call the product component to create the second product 

		//set stock	
		//todo: call the product component to set the stock for the first product

		//get a product
		//todo: call the product component to get the the first product and print the result
		
		// add products to the shoppingcart
		//todo: call the shopping component to add the first product to the cart
		//todo: call the shopping component to add the second product to the cart


		//get the shoppingcart
		//todo: call the shopping component to get the cart and print the result

		//checkout the cart		
		//todo: call the shopping component to checkout the cart 
		
		//get the order
		//todo: call the order component to get the order and print the result 
		
		//add customer to order
		//todo: call the order component to add a customer to the order
		
		//confirm the order
		//todo: call the order component to confirm the order
		
		//get the order
		//todo: call the order component to get the order and print the result
		
	}


}
