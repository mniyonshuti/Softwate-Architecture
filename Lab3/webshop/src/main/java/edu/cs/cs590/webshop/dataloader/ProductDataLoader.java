package edu.cs.cs590.webshop.dataloader;

import edu.cs.cs590.webshop.model.*;
import edu.cs.cs590.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataLoader implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address("1000 N", "fairfiled", "52004", "USA");
        Supplier supplier = new Supplier(100, "John Doe", "652-876-7467", "jdoe@gmail.com", address);
        productRepository.save(new Product("123", "Laptop", 2700.00, null, supplier, null));


        Address address1 = new Address("Y23 yield", "Sunnyvale", "34667", "USA");
        Supplier supplier1 = new Supplier(102, "Allen Joel", "123-836-7684", "aJoel@gmail.com", address1);
        productRepository.save(new Product("124", "Phone", 500.00, null, supplier1, null));

        Address address2 = new Address("Robbie Rd", "Plano", "75024", "USA");
        Supplier supplier2 = new Supplier(103, "Moses Alex", "546-876-3524", "malex@gmail.com", address2);
        productRepository.save(new Product("125", "Book", 20.00, null, supplier2, null));
    }
}
