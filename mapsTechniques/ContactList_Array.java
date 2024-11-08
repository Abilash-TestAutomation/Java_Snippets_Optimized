package mapsTechniques;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactList_Array {

	/*
	 * This HashMap takes Name and will map other details like Email, address as ArrayList
	 * Arraylist allows duplicate. Example: you can create multiple name with same info
	 */
	private HashMap<String,HashMap<String,ArrayList<String>>> contacts = new HashMap<>();

	public void addContact(String name,String Mobile, String Email, String Address)
	{
		contacts.putIfAbsent(name, new HashMap<>());
		contacts.get(name).computeIfAbsent("Mobile", K -> new ArrayList<>()).add(Mobile);
		contacts.get(name).computeIfAbsent("Address", K -> new ArrayList<>()).add(Address);
		contacts.get(name).computeIfAbsent("Email", K -> new ArrayList<>()).add(Email);
	}

	public void displayContact(String name)
	{
		System.out.println("Name:" +name);
		System.out.println("Mobile Number:" + contacts.get(name).get("Mobile"));
		System.out.println("Email:" + contacts.get(name).get("Email"));
		System.out.println("Address:" + contacts.get(name).get("Address"));
	}
	
	public void addDetails(String name, String type,String detail)
	{
		if(contacts.containsKey(name))
		{
			contacts.get(name).get(type).add(detail);
			
		}else {
			System.out.println("Contact is not found");
		}
	}
	/*
	 * In the ContactList constructor, we added contacts = new HashMap<>(); 
	 * to ensure that contacts is initialized when a new instance of ContactList is created.
	 */
//	public ContactList() {
//		contacts = new HashMap<>();
//	}

	public static void main(String[] args) {
		ContactList_Array contactList = new ContactList_Array();
		//Adding name with other values as Empty
		contactList.addContact("Abilash","9884641823","Chennai","ksabi@gmail.com");
		contactList.displayContact("Abilash");
		contactList.addContact("Abilash","9884641823","Chennai","ksabi@gmail.com");
		contactList.displayContact("Abilash");
		contactList.addContact("Sofy","9884641824","Chennai",null);
		//Adding other values to the name
		
		//Display the contact.
		contactList.displayContact("Abilash");

	}

}
