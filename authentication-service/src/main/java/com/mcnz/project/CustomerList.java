package com.mcnz.project;

import java.util.ArrayList;
import java.util.List;

public class CustomerList 
{
	public List<Customer> list;
	
	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}	

	public CustomerList() {
		list = new ArrayList<>();
	}
	
	public CustomerList(List<Customer> list)
	{
		this.list = list;
	}
}