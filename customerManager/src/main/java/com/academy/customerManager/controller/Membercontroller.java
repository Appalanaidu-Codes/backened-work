package com.academy.customerManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.academy.customerManager.exception.ResourceNotFoundException;
import com.academy.customerManager.model.Member;
import com.academy.customerManager.repository.Memberrepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")


public class Membercontroller {
	
	@Autowired
	private Memberrepository Memberrepository;
	
	@GetMapping("/customers")
	public List <Member>getcustomer(){
		return Memberrepository.findAll();
	}
	
	
	@PostMapping("/customers")
	public Member createcustomer (@RequestBody Member member) {
		System.out.println("this data is being posted");
		return Memberrepository.save(member);
	}
	 
	@DeleteMapping("/customers/{id}")
	public ResponseEntity < Map < String, Boolean >> deleteCustomer(@PathVariable Long id){
		Member member = Memberrepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("customer not exist with id:" + id));
		
		Memberrepository.delete(member);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/customers/{id}")
	  public ResponseEntity < Member > getcustomerById(@PathVariable Long id) {
	  	Member member = Memberrepository.findById(id)
	         .orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + id));
	      return ResponseEntity.ok(member);
	   }
	
	

	   @PutMapping("/customers/{id}")
	  public ResponseEntity < Member > updatecustomer(@PathVariable Long id, @RequestBody Member  customer) {
			
			Member updatecustomer = Memberrepository.findById(id)
	           .orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + id));
			
			
			updatecustomer.setName(customer.getName());
			updatecustomer.setPhone(customer.getPhone());
			updatecustomer.setAge(customer.getAge());
			updatecustomer.setProduct(customer.getProduct());
			updatecustomer.setQuantity(customer.getQuantity());
			updatecustomer.setAddress(customer.getAddress()); 
			
			Member updatecustomer1 = Memberrepository.save(customer);
			return ResponseEntity.ok(updatecustomer1);}
	

	
	

}
