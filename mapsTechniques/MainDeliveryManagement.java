package mapsTechniques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Delivery{

	String deliveryId;
	String orderId;
	String status;

	public Delivery(String deliveryId, String orderId) {
		this.deliveryId = deliveryId;
		this.orderId = orderId;
		this.status = "Pending";
	}
	public void updateStatus(String newStatus) {
		this.status = newStatus;
		System.out.println("Delivery " + deliveryId + " status updated to " + newStatus);
	}

	@Override
	public String toString() {
		return "DeliveryID: " + deliveryId + ", OrderID: " + orderId + ", Status: " + status;
	}

}

class DeliveryManagement{

	private ArrayList<Delivery> deliveries;
	private HashMap<String,Delivery> deliveryMap;

	public DeliveryManagement() {
		deliveries = new ArrayList<>();
		deliveryMap = new HashMap<>();
	}

	public void createDelivery(String deliveryID, String orderID)
	{
		Delivery delivery = new Delivery(deliveryID,orderID);
		deliveries.add(delivery);//gets updated based on object reference when ever object is updated
		deliveryMap.put(deliveryID, delivery);
		System.out.println("Delivery created with ID: " + deliveryID);
	}

	// Display all deliveries
	public void displayAllDeliveries() {
		System.out.println("All Deliveries:");
		for (Delivery delivery : deliveries) {//gets the updated object
			System.out.println(delivery);//As seen many times, toString will be called
		}
	}

	public void updateDeliveryStatus(String deliveryID, String status) {
		Delivery delivery = deliveryMap.getOrDefault(deliveryID, null);//returns object ref or null if id not found
		if(delivery !=null)
		{
			delivery.updateStatus(status);//this will update the status of deliverid based on object reference 
		}
		else {
			System.out.println("Delivery not found for ID: " + deliveryID);
		}

	}

}

public class MainDeliveryManagement {

	public static void main(String[] args) {

		//creating instance for Delivery Management
		DeliveryManagement deliveryManagement = new DeliveryManagement();
		deliveryManagement.createDelivery("D001","O001");
		deliveryManagement.createDelivery("D002","O002");

		// Update the status of a delivery
		deliveryManagement.updateDeliveryStatus("D001", "Delivered");

		// Attempt to update a non-existing delivery
		deliveryManagement.updateDeliveryStatus("D004", "Cancelled");
		

		// Display all deliveries
		deliveryManagement.displayAllDeliveries();

	}

}

