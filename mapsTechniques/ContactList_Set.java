package mapsTechniques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContactList_Set {

	/*
	 * This HashMap takes Name and will map other details like Email, address as Set
	 * Set wont accept duplicate contacts
	 */
	private HashMap<String,HashMap<String,Set<String>>> contacts = new HashMap<>();

	public void addContact(String name,String Mobile, String Email, String Address)
	{
		contacts.putIfAbsent(name, new HashMap<>());
		//Lamda Expression reduces code. separately you dont need to have seperate method to add details.
		//Instead of below method called  addDetail, we can use Lamda
		contacts.get(name).computeIfAbsent("Mobile", K -> new HashSet<>()).add(Mobile);
		contacts.get(name).computeIfAbsent("Address", K -> new HashSet<>()).add(Address);
		contacts.get(name).computeIfAbsent("Email", K -> new HashSet<>()).add(Email);
	}
	
//    public void addDetail(String name, String type, String detail) {
//        if (contacts.containsKey(name)) {
//            contacts.get(name).get(type).add(detail);
//            System.out.println(type + " added for " + name);
//        } else {
//            System.out.println("Contact not found.");
//        }
//    }

	public void displayContact(String name)
	{
		System.out.println("Name:" +name);
		System.out.println("Mobile Number:" + contacts.get(name).get("Mobile"));
		System.out.println("Email:" + contacts.get(name).get("Email"));
		System.out.println("Address:" + contacts.get(name).get("Address"));
	}
	
	public void searchByMobileNumber(String mobile)
	{
		for(String name:contacts.keySet())
		{
			Set<String>MobileNumber = contacts.get(name).get("Mobile");
			if(MobileNumber.contains(mobile))
			{
				displayContact(name);
				return;
			}
		}
		System.out.println("Contacts not found");
	}
	
	/*
	 * In the ContactList constructor, we added contacts = new HashMap<>(); 
	 * to ensure that contacts is initialized when a new instance of ContactList is created.
	 */
//	public ContactList() {
//		contacts = new HashMap<>();
//	}

	public static void main(String[] args) {
		ContactList_Set contactList = new ContactList_Set();
		//Adding name with other values as Empty
		contactList.addContact("Abilash","9884641823","Chennai","ksabi@gmail.com");
		contactList.displayContact("Abilash");
		//Trying to add Duplicate
		contactList.addContact("Abilash","9884641823","Chennai","ksabi@gmail.com");
		contactList.displayContact("Abilash");
		//Adding Null values
		contactList.addContact("Sofy","9884641824","Chennai",null);
		//Display the contact.
		contactList.displayContact("Abilash");
		//Search the contact by number
		contactList.searchByMobileNumber("9944102732");
		contactList.searchByMobileNumber("9884641823");

	}

}
