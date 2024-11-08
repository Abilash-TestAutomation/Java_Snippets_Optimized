package mapsTechniques;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class MyContactList {
	private HashMap<String, HashMap<String, Set<String>>> contacts;

	public MyContactList() {
		this.contacts = new HashMap<>();
	}

	// Add or update a contact with multiple details at once
	public void addContact(String name, String mobile, String email, String address) {
		// Ensure at least one detail (mobile, email, or address) is provided, except when name is "null"
		if ((mobile == null && email == null && address == null) && (name == null || name.equals("null"))) {
			System.out.println("At least one detail (Mobile, Email, Address) must be provided.");
			return;
		}

		// If the name is "null" as a string, it's still a valid contact name
		if (name == null || name.equals("null")||name.isEmpty()) {
			name = ""; // Replace "null" name with an empty string
		}

		// Initialize contact if it doesn't exist
		contacts.putIfAbsent(name, new HashMap<>());
		contacts.get(name).putIfAbsent("Mobile", new HashSet<>());
		contacts.get(name).putIfAbsent("Email", new HashSet<>());
		contacts.get(name).putIfAbsent("Address", new HashSet<>());

		// Add non-null details to the contact
		if (mobile != null) contacts.get(name).get("Mobile").add(mobile);
		if (email != null) contacts.get(name).get("Email").add(email);
		if (address != null) contacts.get(name).get("Address").add(address);

		System.out.println("Contact created/updated for " + (name.isEmpty() ? "No Name" : name));
	}

	// Search contact by name
	public void searchByName(String name) {
		if (contacts.containsKey(name)) {
			displayContact(name);
		} else {
			System.out.println("Contact not found.");
		}
	}

	// Search contact by mobile number
	public void searchByMobile(String number) {
		for (String name : contacts.keySet()) {
			Set<String> mobileNumbers = contacts.get(name).get("Mobile");
			if (mobileNumbers.contains(number)) {
				displayContact(name);
				return;
			}
		}
		System.out.println("Contact with this mobile number not found.");
	}

	// Search contact by email
	public void searchByEmail(String email) {
		for (String name : contacts.keySet()) {
			Set<String> emails = contacts.get(name).get("Email");
			if (emails.contains(email)) {
				displayContact(name);
				return;
			}
		}
		System.out.println("Contact with this email not found.");
	}

	// Search contact by address
	public void searchByAddress(String address) {
		for (String name : contacts.keySet()) {
			Set<String> addresses = contacts.get(name).get("Address");
			if (addresses.contains(address)) {
				displayContact(name);
				return;
			}
		}
		System.out.println("Contact with this address not found.");
	}

	// Update a contact detail
	public void updateDetail(String name, String type, String newDetail) {
		if (contacts.containsKey(name)) {
			Set<String> details = contacts.get(name).get(type);
			if (details.remove(newDetail)) {
				details.add(newDetail);  // Adding back ensures uniqueness
				System.out.println(type + " updated for " + name);
			} else {
				System.out.println("Detail not found for " + name);
			}
		} else {
			System.out.println("Contact not found.");
		}
	}

	// Delete a contact
	public void deleteContact(String name) {
		if (contacts.remove(name) != null) {
			System.out.println("Contact " + name + " deleted.");
		} else {
			System.out.println("Contact not found.");
		}
	}

	// Display a specific contact's information
	public void displayContact(String name) {
		// If name is empty, just display "Name:" with no value
		String displayName = name.isEmpty() ? "" : name;
		System.out.println("Name: " + displayName);
		System.out.println("Mobile Numbers: " + contacts.get(name).get("Mobile"));
		System.out.println("Emails: " + contacts.get(name).get("Email"));
		System.out.println("Addresses: " + contacts.get(name).get("Address"));
	}

	// Display all contacts
	public void displayAllContacts() {
		if (contacts.isEmpty()) {
			System.out.println("No contacts found.");
		} else {
			for (String name : contacts.keySet()) {
				displayContact(name);
				System.out.println("-----------");
			}
		}
	}


	public static void main(String[] args) {
		MyContactList contactList = new MyContactList();

		// Adding contacts with all details at once
		contactList.addContact("John Doe", "1234567890", "john.doe@example.com", "123 Main St");
		contactList.addContact("Jane Smith", "9876543210", "jane.smith@example.com", null);
		//contactList.addContact("null", null, "alice@example.com", null);
		contactList.addContact("", null, "alice@example.com", "Chennai");
		contactList.addContact("", null, "ali@example.com", "Chennai");

		// Searching for contacts
		System.out.println("\nSearching for John Doe by name:");
		contactList.searchByName("John Doe");

		System.out.println("\nSearching for contact by mobile number 9876543210:");
		contactList.searchByMobile("9876543210");

		System.out.println("\nSearching for contact by email alice@example.com:");
		contactList.searchByEmail("alice@example.com");
		
		System.out.println("\nSearching for contact by email ali@example.com:");
		contactList.searchByEmail("ali@example.com");

		// Updating a contact detail
		System.out.println("\nUpdating John Doe's mobile number:");
		contactList.updateDetail("John Doe", "Mobile", "1112223333");

		// Displaying all contacts
		System.out.println("\nDisplaying all contacts:");
		contactList.displayAllContacts();

		// Deleting a contact
		System.out.println("\nDeleting Jane Smith's contact:");
		contactList.deleteContact("Jane Smith");

		// Displaying all contacts after deletion
		System.out.println("\nDisplaying all contacts after deletion:");
		contactList.displayAllContacts();
	}
}
