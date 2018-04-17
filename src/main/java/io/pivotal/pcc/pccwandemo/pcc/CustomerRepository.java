package io.pivotal.pcc.pccwandemo.pcc;


import io.pivotal.pcc.pccwandemo.domain.Customer;
import org.springframework.data.gemfire.repository.GemfireRepository;

public interface CustomerRepository extends GemfireRepository<Customer, String> {
	
}
