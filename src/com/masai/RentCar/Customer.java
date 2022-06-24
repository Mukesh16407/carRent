package com.masai.RentCar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int bill;
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String aadhar, String name, String contact_no, int bill) {
		// TODO Auto-generated constructor stub
		super(id, aadhar, name, contact_no);
		this.bill =bill;
	}
   
	public static ArrayList<Customer> searchByName(String name)
	{
		//code
		ArrayList<Customer>customerList = RentRunner.customerList;
		
		ArrayList<Customer> result = new ArrayList<>();
		
		for(int i =0; i < customerList.size(); i++)
		{
			if(customerList.get(i).name.equals(name)) {
				result.add(customerList.get(i));
			}
		}
		return result;
	}
	
	public static Customer searchByAadhar(String aadhar)
	{
		//code
		
		return null;
	}
	public static Customer searchByID(int id)
	{
		//code
    ArrayList<Customer>customerList = View();
		
		
		for(int i =0; i < customerList.size(); i++)
		{
			if(customerList.get(i).id == id) {
				return customerList.get(i);
			}
		}
		return null;
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		
		ArrayList<Customer> customerList = View();
		
		if(customerList.isEmpty()) {
			this.id=1;
		}else {
			int last_person_id = customerList.get(customerList.size() -1).id +1;
			this.id = last_person_id;
		}
		
		customerList.add(this);
		File file = new File("Customer.txt");
		//System.out.println("created");
		
		if(file.exists() == false) {
			try {
				file.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		FileOutputStream fo;
		try {
			fo = new FileOutputStream(file);
			
			ObjectOutputStream outputStream = new ObjectOutputStream(fo);
			
			 for(int i =0; i < customerList.size(); i++) {
				 outputStream.writeObject(customerList.get(i));
			 }
			 outputStream.close();
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
       ArrayList<Customer>customerList = View();
		
		for(int i =0; i <customerList.size(); i++) {
			if(customerList.get(i).id == this.id) {
				customerList.remove(i);
			}
		}
		
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		  ArrayList<Customer>customerList = View();
			
			for(Customer c:customerList) {
				System.out.println(c);
			}
			
	}
	
	public static ArrayList<Customer>View(){
		ArrayList<Customer>customerList = new ArrayList<>();
		
		FileInputStream fi;
		
		try {
			fi = new FileInputStream("Customer.txt");
			
			ObjectInputStream inputStream = new ObjectInputStream(fi);
			
			boolean EOF = false;
			
			while(EOF != true)
			{
				Customer obj = null;
				try {
					obj = (Customer) inputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				customerList.add(obj);
			}
			
			inputStream.close();
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return customerList;
	}

}
