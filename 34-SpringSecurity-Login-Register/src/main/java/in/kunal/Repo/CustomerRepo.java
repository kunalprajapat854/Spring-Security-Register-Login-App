package in.kunal.Repo;

import org.springframework.data.repository.CrudRepository;

import in.kunal.bindings.Customer;

public interface CustomerRepo  extends CrudRepository<Customer, Integer> {
	
	public Customer findBycname (String cname);

}
