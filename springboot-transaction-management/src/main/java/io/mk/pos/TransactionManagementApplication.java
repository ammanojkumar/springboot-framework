package io.mk.pos;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.mk.pos.entity.Customer;
import io.mk.pos.entity.Product;
import io.mk.pos.repository.CustomerRepository;
import io.mk.pos.repository.ProductRepository;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner saveCustomer(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customer("c1", "Arun", "98797"));
			repository.save(new Customer("c2", "Bala", "98798"));
			repository.save(new Customer("c3", "Dani", "98799"));
		};
	}

	@Bean
	public CommandLineRunner saveProducts(ProductRepository repository) {
		return (args) -> {
			repository.save(new Product("p1", "Television", new BigDecimal(2000)));
			repository.save(new Product("p2", "Refrigerator", new BigDecimal(3000)));
			repository.save(new Product("p3", "Fan", new BigDecimal(1000)));
		};
	}
}
