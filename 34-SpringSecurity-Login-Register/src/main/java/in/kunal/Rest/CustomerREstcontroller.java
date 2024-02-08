package in.kunal.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.kunal.Repo.CustomerRepo;
import in.kunal.bindings.Customer;

@RestController

public class CustomerREstcontroller {
	
	
	@Autowired
	private CustomerRepo service;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager manager;
	
	
	
	@PostMapping("/register")
	public String register(@RequestBody Customer customer) {
		 String encodedpwd =    encoder.encode(customer.getPwd());
		 customer.setPwd(encodedpwd);
		   service.save(customer);
		return "Register successfully";
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login (@RequestBody Customer customer ) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(customer.getCname(), customer.getPwd());
		       try {
		    	 Authentication authentication =   manager.authenticate(token);
		    	 if(authentication.isAuthenticated()) {
		    		 return new ResponseEntity<String>("Welcome to Spring Security" , HttpStatus.OK);
		    	 }
		    	 else {
		    		
		    	 }
			} catch (Exception e) {
				// logger
			}
		       return new ResponseEntity<String>("Invaild Password" , HttpStatus.BAD_REQUEST);
		       
	}
		       
		       
		        
	}


