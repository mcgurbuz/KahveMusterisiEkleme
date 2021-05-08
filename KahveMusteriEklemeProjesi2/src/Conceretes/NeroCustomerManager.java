package Conceretes;

import Abstracts.BaseCustomerManager;
import Entity.Customer;

public class NeroCustomerManager extends BaseCustomerManager {

	public void save(Customer customer)throws Exception {
		
		System.out.println("Müsteri eklendi NERO " + " "+ customer.getFirsName());
		
		
	}
	
}
