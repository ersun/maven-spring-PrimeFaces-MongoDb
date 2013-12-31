package com.myproj.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import main.services.CustomerService;
import main.services.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.myproj.model.Customer;


@ManagedBean(name="customerManagedBean")
public class CustomerManagedBean {
	
@Autowired(required=true)
	CustomerService customerService=new CustomerServiceImpl();
	
	private static final long serialVersionUID = 1L;
	private Customer customer=new Customer();
	
	 
	public void setEmployee(Customer customer) {
	this.setCustomer(customer);
	}
	
	public String test(){
		return "heyyyhoooot";
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String save(){
		customerService.saveCustomer(customer);
		return "Başarılı";
	}
	public List<Customer> getCustomerList(){
		return customerService.getCustomerList();
	}
	public void update(){
		customerService.updateCustomer(customer);
		 
	}
	public void delete(String id){
		customerService.deleteCustomer(id);
		FacesContext context = FacesContext.getCurrentInstance();  
        
        context.addMessage(null, new FacesMessage("Record Deleted"));  
       
	}
	public void edit(Customer c){
		customer=c;
	}
	public void newCustomer(){
		customer=new Customer();
	}

}
