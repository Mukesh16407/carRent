package com.masai.RentCar;

import java.util.ArrayList;

public class RentRunner {
  
	static ArrayList<Customer>customerList = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer ramu = new Customer(1,"Y","Ramu","Z",1);
		Customer papu = new Customer(2,"z","Pappu","A",3);
		ramu.add();
		papu.add();
		ramu.print();
//		ArrayList<Customer> res = Customer.searchByName("Ramu");
//		System.out.println(res.toString());
//		

	}

}
