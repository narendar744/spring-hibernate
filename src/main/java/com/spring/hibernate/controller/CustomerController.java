package com.spring.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.hibernate.entity.Customer;
import com.spring.hibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		List<Customer> theCustomers = service.getCustomer();
		theModel.addAttribute("customers", theCustomers);
		return "customer-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		service.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showformForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer= service.getCustomer(theId);
		theModel.addAttribute("customer",	theCustomer);
		return"customer-form";
		
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		service.deleteCustomer(theId);
		return"redirect:/customer/list";
	}
	
	 @GetMapping("/search")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        // search customers from the service
	        List<Customer> theCustomers = service.searchCustomers(theSearchName);
	                
	        // add the customers to the model
	        theModel.addAttribute("customers", theCustomers);

	        return "customer-list";        
	    }

}
