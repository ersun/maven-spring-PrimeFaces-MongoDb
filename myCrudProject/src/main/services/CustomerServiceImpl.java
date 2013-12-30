package main.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproj.dao.CustomerDao;
import com.myproj.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService,Serializable{

 
	private static final long serialVersionUID = 1L;
	
	
	 
	 

	private List<Customer> empList=new ArrayList<Customer>();
	public  CustomerServiceImpl(){
	Customer emp1 = new Customer();
	emp1.setEmpId(1L);
	emp1.setFirstName("Huong");
	emp1.setLastName("Nguyen");
	Customer emp2 = new Customer();
	emp2.setEmpId(2L);
	emp2.setFirstName("Khang");
	emp2.setLastName("Le");
	getEmpList().add(emp1);
	getEmpList().add(emp2);
	} 
	
	
@Override
public Customer findCustomerById(Long id) {
	for(Customer emp: getEmpList()){
		if(emp.getEmpId()==id){
		return emp; 
			}
		}
	return null;
}


public List<Customer> getEmpList() {
	return empList;
}


public void setEmpList(List<Customer> empList) {
	this.empList = empList;
}


}