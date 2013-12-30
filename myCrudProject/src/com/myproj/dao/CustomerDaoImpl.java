package com.myproj.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproj.model.Customer;

public class CustomerDaoImpl implements CustomerDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired(required=true)
	SessionFactory sessionFactory;

	public boolean addEmployee(Customer emp) {
		try {
			sessionFactory.getCurrentSession().save(emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Customer findEmployeeById(long empId) {
		Customer result = new Customer();
		try {
			result = (Customer) sessionFactory.getCurrentSession().get(
					Customer.class, empId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer findCustomerById(long empId) {
		// TODO Auto-generated method stub
		return null;
	}
}
