package com.myproj.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import main.services.CustomerService;
import main.services.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.request.SessionScope;

import com.myproj.model.Customer;


@ManagedBean(name="customerManagedBean")
@SessionScoped
public class CustomerManagedBean {
	
@Autowired(required=true)
	CustomerService customerService=new CustomerServiceImpl();
	 
	  Customer customer=new Customer();
	 private Boolean captcha=false;
	
	public void save(){
		customerService.saveCustomer(getCustomer());
		setFacesMessages("New record saved");
	}
	public List<Customer> getCustomerList(){
		return customerService.getCustomerList();
	}
	public void update(){
		customerService.updateCustomer(getCustomer());
		setFacesMessages("Record updated");
		 
	}
	public void delete(String id){
		customerService.deleteCustomer(id);
       setFacesMessages("Record deleted");
	}
	
	public void setFacesMessages(String msg){
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage(msg));  
	}
	
	
	public void edit(Customer c){
		setCaptcha(false);
		setCustomer(c);
	}
	public void newCustomer(){
		setCaptcha(true);
		setCustomer(new Customer());
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<SelectItem> getGenderList(){
		List<SelectItem> sList=new ArrayList<SelectItem>();
		sList.add(new SelectItem("", "Choose"));
		sList.add(new SelectItem("male", "Male"));
		sList.add(new SelectItem("female", "Female"));
		return sList;
	}
	public List<SelectItem> getJobList(){
		List<SelectItem> sList=new ArrayList<SelectItem>();
		sList.add(new SelectItem("", "Choose"));
		sList.add(new SelectItem("student", "Student"));
		sList.add(new SelectItem("worker", "worker"));
		return sList;
	}
	public Boolean getCaptcha() {
		return captcha;
	}
	public void setCaptcha(Boolean captcha) {
		this.captcha = captcha;
	}

}
