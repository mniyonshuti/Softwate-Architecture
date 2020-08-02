package cs590.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCallService {

    @Autowired
    private RestOperations restTemplate;

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate;
    }

    public void createOrder(ShoppingCartDTO shoppingCartDTO) {
        restTemplate.postForObject("http://localhost:8084/order/createorder", shoppingCartDTO, ShoppingCartDTO.class);
    }

    public ProductDTO getProduct(String productnumber) {
        return restTemplate.getForObject("http://localhost:8082/product/" + productnumber, ProductDTO.class);
    }
}
