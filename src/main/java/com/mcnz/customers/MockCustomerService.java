package com.mcnz.customers;

import java.util.*;

public class MockCustomerService implements CustomerService {

	static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	static {
		customers.add(new Customer(1 , "Bruce"         , "pass"    , "bruce@a.com"       ));
		customers.add(new Customer(2 , "Paul"          , "pass"    , "paul@b.com"        ));
		customers.add(new Customer(3 , "Rick"          , "pass"    , "rick@c.com"        ));
		customers.add(new Customer(4 , "Cameron"       , "123456"  , "cameron@mcnz.com"  ));
		customers.add(new Customer(6 , "Curtis"        , "abcdefg" , "curtis@example.com"));
		customers.add(new Customer(7 , "andy@gmail.com", null      , "andy"              ));
		customers.add(new Customer(8 , "Aaron"         , null      , "Aaron@example.com" ));
		customers.add(new Customer(9 , "nn"            , "rr"      , "aa"                ));
		customers.add(new Customer(11, "Jake"          , "pass"    , "jblatt@wowway.com" ));
		customers.add(new Customer(12, "Test"          , "passtest", "test@test.com"     ));
	}	
	
	@Override
	public List<Customer> getCustomers() {
		return customers;
	}
	
	@Override
	public Customer getCustomerById(int id) {
		return customers.get(id);
	}
	
	@Override
	public void addCustomer(Customer newCustomer)
	{
		long id = newCustomer.getId();
		if (id >= 1)
		{			
			while (id >= customers.size())
			{
				customers.add(null);
			}
			customers.add(newCustomer);
		}
	}
	
	@Override 
	public void deleteCustomer(int id)
	{
		if (id < customers.size())
		{
			customers.set(id, null);
			customers.trimToSize();
		}
	}

	@Override
	public void updateCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		
	}

}
