package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlType(name="Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

	@XmlElement(name="id")
	public int id;
	
	@XmlElement(name="clientId")
    public int clientId;
	
	@XmlElement(name="order_date")
    public String order_date;
	
	@XmlElement(name="status")
    public String status; // cart/wishlist/ongoing/paid
	
	@XmlElement(name="subtotal")
    public double subtotal;
	
	@XmlElementWrapper(name="entries")
    @XmlElement(name="entry")
    public List<Entry> entries;
	
	@XmlElement(name="delivery_date")
    public String delivery_date;
	
	@XmlElement(name="total")
    public double total;
	
	@XmlElement(name="transaction")
    public String transaction;
	
	@XmlElement(name="deliveryAddress")
    public Address deliveryAddress;

    public Order() {
    	this.entries = new ArrayList<Entry>();
    }
    
	public Order(int clientId, String status){
        this.clientId = clientId;  
        this.status = status;
        this.entries = new ArrayList<Entry>();
    }


	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	
	public Order(int id, int clientId, String order_date, String status, double subtotal, List<Entry> entries,
			String delivery_date, double total, String transaction, Address deliveryAddress) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.order_date = order_date;
		this.status = status;
		this.subtotal = subtotal;
		this.entries = entries;
		this.delivery_date = delivery_date;
		this.total = total;
		this.transaction = transaction;
		this.deliveryAddress = deliveryAddress;
	}

	public Order(int id, int clientId, String status) {
		this.id = id;
		this.clientId = clientId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", clientId=" + clientId + ", order_date=" + order_date + ", status=" + status
				+ ", subtotal=" + subtotal + ", entries=" + entries + ", delivery_date=" + delivery_date + ", total="
				+ total + ", transaction=" + transaction + ", deliveryAddress=" + deliveryAddress + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

    public String getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getOrder_id() {
		return id;
	}

	public void setOrder_id(int order_id) {
		this.id = order_id;
	}

	public int getClient_id() {
		return clientId;
	}

	public void setClient_id(int client_id) {
		this.clientId = client_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(ArrayList<Entry> entries) {
		this.entries = entries;
	}
}
