package com.masai.RentCar;

import java.io.Serializable;

public abstract class Person implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String aadhar;
	protected String name;
	protected String contact_no;
	
	public Person() {
		super();
	}

	public Person(int id, String aadhar, String name, String contact_no) {
		
		this.id = id;
		this.aadhar = aadhar;
		this.name = name;
		this.contact_no = contact_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	public String toString() {
		return "person [id=" +id + ", aadhar=" + aadhar + ",name=" + name + ", contact_no=" + contact_no + "]";
	}
	
	public abstract void add();
	public abstract void update();
	public abstract void remove();
	public abstract void print();
	
	public static boolean isAadharvalid(String aadhar) 
	{
		//code
		boolean valid = true;
		if(aadhar.length() == 16) {
			
		for(int i =0;i < aadhar.length(); i++)
        {
	       if(Character.isDigit(aadhar.charAt(i)) == false) {
	    	   valid = false;
	    	   break;
	       }
         }
		}else {
			valid = false;
		}
		return valid;
	}
	
	
	public static boolean isNameValid(String name)
	{
		//code
		boolean valid = true;
			
		for(int i =0;i < name.length(); i++)
        {
	       if(Character.isLetter(name.charAt(i)) == false) {
	    	   valid = false;
	    	   break;
	       }
         }
		
		
		return valid;
	}
	
	public static boolean isContactValid(String contact)
	{
		//code
		boolean valid = true;
		if(contact.length()== 12)
		{
			if(contact.substring(0, 2).equals("91")) {
				for(int i =0;i < contact.length(); i++)
		        {
			       if(Character.isDigit(contact.charAt(i)) == false) {
			    	   valid = false;
			    	   break;
			       }
		         }
				
			}else {
				valid = false;
			}
		}else {
			valid = false;
		}
		
		
		return valid;
	}
	
	public static boolean isIDValid(int id)
	{
		//code
		String ID = Integer.toString(id);
		boolean valid = true;
		for(int i =0; i < ID.length(); i++) {
			if(Character.isDigit(ID.charAt(i)) == false) {
				valid = false;
				break;
			}
		}
		return valid;
	}
}
