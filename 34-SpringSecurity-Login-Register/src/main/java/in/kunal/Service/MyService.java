package in.kunal.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.kunal.Repo.CustomerRepo;
import in.kunal.bindings.Customer;

@Service
public class MyService  implements UserDetailsService  {
	
	@Autowired
	private CustomerRepo service;
	
	// retrive customer register info using findBycname method 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer c =service.findBycname(username);
		
		return new User (c.getCname(), c.getPwd(),Collections.emptyList());
	}

	
}

	

