package edu.cs.cs590.webshop.webshopclient;

import edu.cs.cs590.webshop.webshopclient.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebShopClientApplication implements CommandLineRunner {
    @Autowired
    private RestOperations restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(WebShopClientApplication.class, args);
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

        //Creating product
        Address address = new Address("1000 N", "fairfiled", "52004", "USA");
        Supplier supplier = new Supplier(100, "John Doe", "652-876-7467", "jdoe@gmail.com", address);
        Product product1 = new Product("244", "Laptop", 2700.00, null, supplier, null);

        Address address1 = new Address("Y23 yield", "Sunnyvale", "34667", "USA");
        Supplier supplier1 = new Supplier(102, "Allen Joel", "123-836-7684", "aJoel@gmail.com", address1);
        Product product2 = new Product("245", "Phone", 500.00, null, supplier1, null);

        //Saving products
        restTemplate.postForObject("http://localhost:8080/product", product1, Product.class);
        restTemplate.postForObject("http://localhost:8080/product", product2, Product.class);

        //Adding products to cart
        ProductDto productDto1 = new ProductDto("1", "244", 3);
        ProductDto productDto2 = new ProductDto("1", "245", 2);

        restTemplate.postForObject("http://localhost:8080/shoppingcart", productDto1, ProductDto.class);
        restTemplate.postForObject("http://localhost:8080/shoppingcart", productDto2, ProductDto.class);

        //Creating order
        restTemplate.postForObject("http://localhost:8080/order/create", "1", String.class);

        //Retrieving order
        Order order = restTemplate.getForObject("http://localhost:8080/order/1", Order.class);
        System.out.println("Retrieving Order:" + order);
    }
}
