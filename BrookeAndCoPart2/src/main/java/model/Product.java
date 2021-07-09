package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlType(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	@XmlElement(name="id")
	private int id;

	@XmlElement(name="pcode")
	private String pcode;
	
	@XmlElement(name="picture")
	private String picture;
	
	@XmlElement(name="type")
	private String type;
	
	@XmlElement(name="title")
	private String title;
	
	@XmlElement(name="category")
	private String category;
	
	@XmlElement(name="inventory")
	private int inventory;
	
	@XmlElement(name="genre")
	private String genre;
	
	@XmlElement(name="price")
	private double price;

     public Product(){
    	 
     }

     public Product(int id, String pcode, String picture, String type, String title, String category, int inventory, String genre, double price){
    	 this.id = id;
    	 this.pcode = pcode;
    	 this.picture = picture;
    	 this.type = type;
    	 this.title = title;
    	 this.category = category;
    	 this.inventory = inventory;
    	 this.genre = genre;
    	 this.price = price;
	}
     

    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
     
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pcode=" + pcode + ", picture=" + picture + ", type=" + type + ", title=" + title
				+ ", category=" + category + ", inventory=" + inventory + ", genre=" + genre + ", price=" + price + "]";
	}
     
     


     /*
     public Product(string Pcode)
     {
         String request = "Select * from products2 where pcode='" + Pcode + "';";
         DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
         //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
         DbDataReader reader = DBManager.executeQuery(request);

         while (reader.Read())
         {
             try
             {
                 this.pcode = reader.GetString(0);
                 this.type = reader.GetString(1);
                 this.title = reader.GetString(2);
                 this.category = reader.GetString(3);
                 this.price = reader.GetDouble(4);
                 this.picture = reader.GetString(5);
                 this.bought = reader.GetInt32(6);
                 this.left = reader.GetInt32(7);
                 this.genre = reader.GetString(8);
                 
             }
             catch (System.Data.SqlTypes.SqlNullValueException)
             {
             }
         }
         DBManager.closeConnection();
     }

     public static List<Product> getProducts()
     {

         String request = "Select * from products";
         DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
         //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
         DbDataReader reader = DBManager.executeQuery(request);
         List<Product> list = new List<Product>();

         while (reader.Read())
         {
             string pcode = reader.GetString(0);
             string type = reader.GetString(1);
             string title = reader.GetString(2);
             string category = reader.GetString(3);
             string genre = reader.GetString(4);
             double price = reader.GetDouble(5);
             string picture = reader.GetString(6);
             int bought = reader.GetInt32(7);
             int left = reader.GetInt32(8);
             int warehouse = reader.GetInt32(9);
             list.Add(new Product(pcode, type, title, category, genre, price, picture, bought, left, warehouse));
         }
         DBManager.closeConnection();
         return list;
     }

     public static List<Product> getProductsByTitle(string title)
     {

         String request = "Select * from products where title like \"%" + title + "%\"";
         
         DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
         //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
         DbDataReader reader = DBManager.executeQuery(request);
         List<Product> list = new List<Product>();

         while (reader.Read())
         {
             string pcode = reader.GetString(0);
             string type = reader.GetString(1);
             string category = reader.GetString(3);
             string genre = reader.GetString(4);
             double price = reader.GetDouble(5);
             string picture = reader.GetString(6);
             int bought = reader.GetInt32(7);
             int left = reader.GetInt32(8);
             int warehouse = reader.GetInt32(9);
             list.Add(new Product(pcode, type, title, category, genre, price, picture, bought, left, warehouse));
         }
         DBManager.closeConnection();
         return list;
     }

     public static List<Product> getTopTen()
     {

         String request = "Select * from topTen";
         DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
         //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
         DbDataReader reader = DBManager.executeQuery(request);
         List<Product> list = new List<Product>();

         while (reader.Read())
         {
             string pcode = reader.GetString(0);
             string type = reader.GetString(1);
             string title = reader.GetString(2);
             string category = reader.GetString(3);
             string genre = reader.GetString(4);
             double price = reader.GetDouble(5);
             string picture = reader.GetString(6);
             int bought = reader.GetInt32(7);
             int left = reader.GetInt32(8);
             int warehouse = reader.GetInt32(9);
             list.Add(new Product(pcode, type, title, category, genre, price, picture, bought, left, warehouse));
         }
         DBManager.closeConnection();
         return list;
     }

     public void save()
     {
         String request = "insert into product values(null, '" + pcode + "', '" + type + "', '" + category + "', " + price + ", '" + picture + "', '" + title + "','" + genre + "', 0, 0, 'inactive', 1 , 20)";
         DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
         //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
         int lines = DBManager.executeUpdate(request);
         DBManager.closeConnection();
     }

     public void modify(String request)
     {
         DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
         //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
         int lines = DBManager.executeUpdate(request);
         DBManager.closeConnection();
     }
	*/
}
