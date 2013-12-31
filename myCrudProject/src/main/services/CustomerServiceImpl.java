package main.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.myproj.config.SpringMongoConfig;
import com.myproj.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService,Serializable{

 
	private static final long serialVersionUID = 1L;
	
	MongoOperations mongoOperation;
	
	 
	 public CustomerServiceImpl() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	 }


	@Override
	public Customer findCustomerById(String id) {
		Query searchUserQuery = new Query(Criteria.where("customerId").is(id));
		Customer findCust = mongoOperation.findOne(searchUserQuery, Customer.class);
		return findCust;
	}


	@Override
	public List<Customer> getCustomerList() {
		List<Customer> cList=mongoOperation.findAll(Customer.class);
		return cList;
	}


	@Override
	public void saveCustomer(Customer customer) {
		mongoOperation.save(customer);
		
	}


	@Override
	public void updateCustomer(Customer customer) {
		Query searchUserQuery = new Query(Criteria.where("customerId").is(customer.getCustomerId()));
//		Update 
//		mongoOperation.updateFirst("", searchUserQuery, Customer.class);
		
	}


	@Override
	public void deleteCustomer(String id) {
		Query searchUserQuery = new Query(Criteria.where("customerId").is(id));
		mongoOperation.remove(searchUserQuery, Customer.class);
		
	}
	 
 

 


}