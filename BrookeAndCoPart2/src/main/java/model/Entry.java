package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlType(name="Entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

	@XmlElement(name="id")
	 public int id;
	
	@XmlElement(name="orderId")
     public int orderId;
	
	@XmlElement(name="product")
     public Product product;
	
	@XmlElement(name="quantity")
     public int quantity;
	
	@XmlElement(name="price")
     public double price;

     
     public Entry() {
		
	}

	public Entry(int id, int orderId, Product product, int quantity, double price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getorderId() {
		return orderId;
	}

	public void setorderId(int order_id) {
		this.orderId = order_id;
	}	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", orderId=" + orderId + ", product=" + product + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

	
}
