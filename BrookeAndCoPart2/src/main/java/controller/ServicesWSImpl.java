package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import model.Address;
import model.Book;
import model.Card;
import model.Client;
import model.Entry;
import model.Game;
import model.Gmail;
import model.Movie;
import model.Order;
import model.Product;
import model.SQLConnection;

public class ServicesWSImpl implements ServicesWS{

	@Override
	public Product getProductById(int id) {
		/*
		Product pr = null;
			for(Product product : list) {
				if(product.getId() == id){
					pr = product; 
					break; 
				}
			}
		return pr;
		*/
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
    	Product product = new Product();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.product where id=" + id + ";");  
				while (resultSet.next()) {
					product.setId(id);
					product.setInventory(resultSet.getInt("inventory"));
					product.setPrice(resultSet.getDouble("price"));
					product.setType(resultSet.getString("type"));
					product.setCategory(resultSet.getString("category"));
					product.setTitle(resultSet.getString("title"));
					product.setGenre(resultSet.getString("genre"));
					product.setPicture(resultSet.getString("picture"));
					product.setPcode(resultSet.getString("pcode"));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			product.setId(0);
			System.out.println(e);
			}  
		return product;
	}

	@Override
	public ArrayList<Product> getProductByTitle(String title) {
		/*
		ArrayList<Product> product_list_title = new ArrayList<>();
			for(Product pr : list) {
				if(pr.getTitle().contains(title)) {
					product_list_title.add(pr);
				}
			}
		return product_list_title;
		*/
		ArrayList<Product> list = new ArrayList<Product>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.product where title like '%" + title + "%';");  
				
				while (resultSet.next()) {
					
				    int id = resultSet.getInt("id");
				    int inventory = resultSet.getInt("inventory");
					double price = resultSet.getDouble("price");
					String Title = resultSet.getString("title");
					String type = resultSet.getString("type");
					String category = resultSet.getString("category");
					String genre = resultSet.getString("genre");
					String picture = resultSet.getString("picture");
					String pcode = resultSet.getString("pcode");

				    
					list.add(new Product( id,  pcode,  picture,  type,  Title,  category,  inventory,  genre,  price));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public ArrayList<Product> getProducts() {
		
		ArrayList<Product> list = new ArrayList<Product>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.product;");  
				
				while (resultSet.next()) {
					
				    int id = resultSet.getInt("id");
				    int inventory = resultSet.getInt("inventory");
					double price = resultSet.getDouble("price");
					String type = resultSet.getString("type");
					String category = resultSet.getString("category");
					String title = resultSet.getString("title");
					String genre = resultSet.getString("genre");
					String picture = resultSet.getString("picture");
					String pcode = resultSet.getString("pcode");
					list.add(new Product( id,  pcode,  picture,  type,  title,  category,  inventory,  genre,  price));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}
	
	@Override
	public boolean updateProduct(Entry entry) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
			sql.executeUpdate("update u579109085_jmdata.product set inventory=(product.inventory -"+ entry.getQuantity() + ") where id =" + entry.getProduct().getId() + ";"); 
			sql.closeConnection();
			return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		
		return false;
	}


	@Override
	public ArrayList<Book> getBooks() {
		/*
		ArrayList<Book> book_list = new ArrayList<>();
			for(Product pr : list) {
				if(pr.getType().equals("book")) {
					book_list.add((Book)pr);
				}
			}
		return book_list;
		*/
		
		ArrayList<Book> list = new ArrayList<Book>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.books;");  
				
				while (resultSet.next()) {
					
				    int id = resultSet.getInt("id");
				    int inventory = resultSet.getInt("inventory");
					double price = resultSet.getDouble("price");
					String type = resultSet.getString("type");
					String category = resultSet.getString("category");
					String title = resultSet.getString("title");
					String genre = resultSet.getString("genre");
					String picture = resultSet.getString("picture");
					String pcode = resultSet.getString("pcode");
					String authors = resultSet.getString("authors");
			        String pubCo = resultSet.getString("pubco");
			        java.sql.Date dbSqlDate = resultSet.getDate("pubdate");
				    String pubDate = dbSqlDate.toString();
			        
					list.add(new Book( id,  pcode,  picture,  type,  title,  category,  inventory,  genre,  price, authors, pubCo, pubDate));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public ArrayList<Book> getBooksByCategory(String category) {
		/*
		ArrayList<Book> book_list_category = new ArrayList<>();
			for(Product pr : list) {
				if(pr.getCategory().equalsIgnoreCase(category) && pr.getType().equals("book")) {
					book_list_category.add((Book)pr);
				}
			}
		return book_list_category;
		*/
		ArrayList<Book> list = new ArrayList<Book>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.books where category='" + category + "';");  
				
				while (resultSet.next()) {
					
				    int id = resultSet.getInt("id");
				    int inventory = resultSet.getInt("inventory");
					double price = resultSet.getDouble("price");
					String type = resultSet.getString("type");
					String title = resultSet.getString("title");
					String genre = resultSet.getString("genre");
					String picture = resultSet.getString("picture");
					String pcode = resultSet.getString("pcode");
					String authors = resultSet.getString("authors");
			        String pubCo = resultSet.getString("pubco");
			        java.sql.Date dbSqlDate = resultSet.getDate("pubdate");
				    String pubDate = dbSqlDate.toString();
			        
					list.add(new Book(id, pcode, picture, type, title, category, inventory, genre, price, authors, pubCo, pubDate));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public Book getBookById(int id) {
		/*
		Book book = null;
			for(Product pr : list) {
				if(pr.getType().equals("book") && pr.getId() == id) {
					book = (Book)pr;
					break;
				}
			}
		return book;
		*/
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	Book book = new Book();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.books where id=" + id + ";");  
				
				while (resultSet.next()) {

					book.setId(id);
					book.setInventory(resultSet.getInt("inventory"));
					book.setPrice(resultSet.getDouble("price"));
					book.setType(resultSet.getString("type"));
					book.setCategory(resultSet.getString("category"));
					book.setTitle(resultSet.getString("title"));
					book.setGenre(resultSet.getString("genre"));
					book.setPicture(resultSet.getString("picture"));
					book.setPcode(resultSet.getString("pcode"));
					book.setAuthors(resultSet.getString("authors"));
			        book.setPubCo(resultSet.getString("pubco"));
			        java.sql.Date dbSqlDate = resultSet.getDate("pubdate");
				    book.setPubDate(dbSqlDate.toString());
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return book;
	}
	
	@Override
	public ArrayList<Game> getGames() {
		/*
		ArrayList<Game> game_list = new ArrayList<>();
		for(Product pr : list) {
			if(pr.getType().equals("game")) {
				game_list.add((Game)pr);
			}
		}
	return game_list;
	*/
		
		ArrayList<Game> list = new ArrayList<Game>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.games;");
				
				while (resultSet.next()) {
					
				    int id = resultSet.getInt("id");
				    int inventory = resultSet.getInt("inventory");
					double price = resultSet.getDouble("price");
					String type = resultSet.getString("type");
					String title = resultSet.getString("title");
					String genre = resultSet.getString("genre");
					String picture = resultSet.getString("picture");
					String pcode = resultSet.getString("pcode");
					String category = resultSet.getString("category");
					String console = resultSet.getString("console");
					String company = resultSet.getString("company");
					java.sql.Date dbSqlDate = resultSet.getDate("reldate");
			        String reldate = dbSqlDate.toString();
			        
					list.add(new Game(id, pcode, picture, type, title, category, inventory, genre, price, console, company, reldate));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public ArrayList<Game> getGamesByCategory(String category) {
		/*
		ArrayList<Game> game_list_category = new ArrayList<>();
		for(Product pr : list) {
			if(pr.getCategory().equalsIgnoreCase(category) && pr.getType().equals("game")) {
				game_list_category.add((Game)pr);
			}
		}
	return game_list_category;
	*/
		
		ArrayList<Game> list = new ArrayList<Game>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.games where category='"+ category +"';");
				
				while (resultSet.next()) {
					
				    int id = resultSet.getInt("id");
				    int inventory = resultSet.getInt("inventory");
					double price = resultSet.getDouble("price");
					String type = resultSet.getString("type");
					String title = resultSet.getString("title");
					String genre = resultSet.getString("genre");
					String picture = resultSet.getString("picture");
					String pcode = resultSet.getString("pcode");
					String console = resultSet.getString("console");
					String company = resultSet.getString("company");
					java.sql.Date dbSqlDate = resultSet.getDate("reldate");
			        String reldate = dbSqlDate.toString();
			        
					list.add(new Game(id, pcode, picture, type, title, category, inventory, genre, price, console, company, reldate));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public Game getGamebyId(int id) {
		
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	Game game = new Game();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.games where id=" + id + ";");  
				
				while (resultSet.next()) {

					game.setId(resultSet.getInt("id"));
					game.setInventory(resultSet.getInt("inventory"));
					game.setPrice(resultSet.getDouble("price"));
					game.setType(resultSet.getString("type"));
					game.setCategory(resultSet.getString("category"));
					game.setTitle(resultSet.getString("title"));
					game.setGenre(resultSet.getString("genre"));
					game.setPicture(resultSet.getString("picture"));
					game.setPcode(resultSet.getString("pcode"));
					game.setCompany(resultSet.getString("company"));
					game.setConsole(resultSet.getString("console"));
			        java.sql.Date dbSqlDate = resultSet.getDate("reldate");
			        game.setReldate(dbSqlDate.toString());
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return game;
	}

	@Override
	public ArrayList<Movie> getMovies() {

		ArrayList<Movie> list = new ArrayList<>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.movies;");
				
				while (resultSet.next()) {
					
				    int id = resultSet.getInt("id");
				    int inventory = resultSet.getInt("inventory");
					double price = resultSet.getDouble("price");
					String type = resultSet.getString("type");
					String title = resultSet.getString("title");
					String genre = resultSet.getString("genre");
					String picture = resultSet.getString("picture");
					String pcode = resultSet.getString("pcode");
					String category = resultSet.getString("category");
					String director = resultSet.getString("director");
					String actors = resultSet.getString("actors");
					java.sql.Date dbSqlDate = resultSet.getDate("relyear");
			        String relyear = dbSqlDate.toString();
			        
					list.add(new Movie(id, pcode, picture, type, title, category, inventory, genre, price, director, actors, relyear));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public ArrayList<Movie> getMoviesByCategory(String category) {

		ArrayList<Movie> list = new ArrayList<>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.movies where category='"+ category +"';");
				
				while (resultSet.next()) {
					
				    int id = resultSet.getInt("id");
				    int inventory = resultSet.getInt("inventory");
					double price = resultSet.getDouble("price");
					String type = resultSet.getString("type");
					String title = resultSet.getString("title");
					String genre = resultSet.getString("genre");
					String picture = resultSet.getString("picture");
					String pcode = resultSet.getString("pcode");
					String director = resultSet.getString("director");
					String actors = resultSet.getString("actors");
					java.sql.Date dbSqlDate = resultSet.getDate("relyear");
			        String relyear = dbSqlDate.toString();
			        
					list.add(new Movie(id, pcode, picture, type, title, category, inventory, genre, price, director, actors, relyear));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public Movie getMoviebyId(int id) {

		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	Movie movie = new Movie();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.movies where id=" + id + ";");  
				
				while (resultSet.next()) {

					movie.setId(resultSet.getInt("id"));
					movie.setInventory(resultSet.getInt("inventory"));
					movie.setPrice(resultSet.getDouble("price"));
					movie.setType(resultSet.getString("type"));
					movie.setCategory(resultSet.getString("category"));
					movie.setTitle(resultSet.getString("title"));
					movie.setGenre(resultSet.getString("genre"));
					movie.setPicture(resultSet.getString("picture"));
					movie.setPcode(resultSet.getString("pcode"));
					movie.setDirector(resultSet.getString("director"));
					movie.setActors(resultSet.getString("actors"));
			        java.sql.Date dbSqlDate = resultSet.getDate("relyear");
			        movie.setRelyear(dbSqlDate.toString());
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return movie;
	}
	
	private Client constructClient(ResultSet resultSet ) throws SQLException {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	Client client = new Client();

				while (resultSet.next()) {

					client.setId(resultSet.getInt("id"));
					client.setEmail(resultSet.getString("email"));
					client.setLastname(resultSet.getString("lastname"));
					client.setName(resultSet.getString("firstname"));
					client.setOrders(getCartOrdersByClientId(client.getId()));
					client.setAddresses(getAddressesByClientId(client.getId()));
				}
				sql.closeConnection();

		return client;
	}

	@Override
	public Client getClientByEmail(String email) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	Client client = new Client();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.client where email='" + email + "';");  
				Client cl = constructClient(resultSet);
				sql.closeConnection();
				return cl;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return client;
	}
	
	public Client getClientById(int id) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	Client client = new Client();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.client where id='" + id + "';");  
				Client cl = constructClient(resultSet);
				sql.closeConnection();
				return cl;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return client;
	}
	
	@Override
	public Client login(String email, String password) {

		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	Client client = new Client();
    	String hashpass = MD5(password);
    	System.out.println(hashpass);
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.client where email='" + email + "' and password='" + hashpass + "';");  
				Client cl = constructClient(resultSet);
				sql.closeConnection();
				return cl;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return client;
	}

	@Override
	public int addClient(Client client) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				String password = MD5(client.getPassword());
				int id = 0;
				sql.executeUpdate("insert into u579109085_jmdata.client values(null, '"+ client.getEmail() + "', '" + client.getFirstname() + "', '" + client.getLastname() + "', '" + password + "');");
				ResultSet set = sql.executeQuery("SELECT LAST_INSERT_ID();");
				 while (set.next()) {
			        	id = set.getInt("LAST_INSERT_ID()");
			        }
				 set.close();
				 Order cart = new Order();
				 cart.setClient_id(id);
				 int e = addOrder(cart);
				 sql.closeConnection();
				 return id;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return 0;
	}
	
	//
	//Found on stack overflow https://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash
	//
	public String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	//=======================================================================================================

	@Override
	public boolean updateClient(Client client) {

		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	String hashpass = MD5(client.getPassword());
    	System.out.println(hashpass);
    	
		try{    
				sql.executeUpdate("update u579109085_jmdata.client set firstname='"+ client.getFirstname() + "', lastname='" + client.getLastname() + "', password='" + hashpass + "' where id="+ client.getId() +";");
				sql.closeConnection();
				return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return false;
	}
	
	@Override
	public ArrayList<Address> getAddressesByClientId(int ClientId) {
		ArrayList<Address> list = new ArrayList<>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.address where client_id="+ ClientId +";");
				
				while (resultSet.next()) {
					
					int id = resultSet.getInt("id");
					String country = resultSet.getString("country");
					String province = resultSet.getString("province");
					String city = resultSet.getString("city");
					String street = resultSet.getString("street");
					int civicnumber = resultSet.getInt("civicnumber");
					String appartment =  resultSet.getString("appartment");
					String zipcode = resultSet.getString("zipcode");
					list.add(new Address( id, country, province, city, street, civicnumber, appartment, zipcode, ClientId));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}
	
	public Address getAddressById(int id) {
		Address address = new Address();
		address.setId(0);
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.address where id="+ id +";");
				
				while (resultSet.next()) {
					
					address.setId(id);
					address.setClient_id(resultSet.getInt("client_id"));
					address.setCountry(resultSet.getString("country"));
					address.setProvince(resultSet.getString("province"));
					address.setCity(resultSet.getString("city"));
					address.setStreet(resultSet.getString("street"));
					address.setCivicnumber(resultSet.getInt("civicnumber"));
					address.setAppartment(resultSet.getString("appartment"));
					address.setZipcode(resultSet.getString("zipcode"));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return address;
	}

	@Override
	public boolean updateAddress(Address address) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				sql.executeUpdate("UPDATE u579109085_jmdata.address set country='"+address.getCountry()+"', province='"+address.getProvince()+"', city='"+address.city+"', street='"+address.getStreet()+"', civicnumber='"+address.getCivicnumber()+"', appartment='"+address.getAppartment()+"', zipcode='"+address.getZipcode()+"' where id="+ address.getId() +";");
				sql.closeConnection();
				return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			return false;
			}
	}

	@Override
	public int addAddress(Address address) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	int id = 0;
    	
		try{    
				sql.executeUpdate("insert into u579109085_jmdata.address values(null,"+address.getClient_id()+",'"+address.getCountry()+"', '"+address.getProvince()+"', '"+address.city+"', '"+address.getStreet()+"', "+address.getCivicnumber()+", '"+address.getAppartment()+"', '"+address.getZipcode()+"');");
				ResultSet set = sql.executeQuery("SELECT LAST_INSERT_ID();");
				 while (set.next()) {
			        	id = set.getInt("LAST_INSERT_ID()");
			        }
				 set.close();
				sql.closeConnection();
				return id;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return 0;
	}
	
	@Override
	public ArrayList<Order> getCartOrdersByClientId(int ClientId) {
		
		ArrayList<Order> list = new ArrayList<>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.order where client_id="+ ClientId +";");
				
				while (resultSet.next()) {
					
					Order order = new Order();
					String status = resultSet.getString("status");
					
					if(status.contentEquals("ongoing")) {
						order.setId(resultSet.getInt("id"));
						order.setClient_id(ClientId);
						order.setStatus(status);
						order.setEntries(getEntriesByOrderId(order.getOrder_id()));
						list.add(order);
					}
				}
				if(list.isEmpty()) {
					Order cart = new Order();
					cart.setClient_id(ClientId);
					int cartId = addOrder(cart);
					cart.setId(cartId);
					cart.setStatus("ongoing");
					list.add(cart);
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public ArrayList<Order> getOrdersByClientId(int ClientId) {
		ArrayList<Order> list = new ArrayList<>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.order where client_id="+ ClientId +";");
				
				while (resultSet.next()) {
					
					Order order = new Order();
					
					String status = resultSet.getString("status");
					
					if(!(status.contentEquals("ongoing")));
					
					order.setId(resultSet.getInt("id"));
					order.setClient_id(ClientId);
					order.setStatus(resultSet.getString("status"));
					order.setEntries(getEntriesByOrderId(order.getOrder_id()));
					java.sql.Date dbSqlDate = resultSet.getDate("orderdate");
			        order.setOrder_date(dbSqlDate.toString());
			        java.sql.Date dbSqlDate2 = resultSet.getDate("deliveryDate");
			        order.setDelivery_date(dbSqlDate2.toString());
					order.setSubtotal(resultSet.getDouble("subtotal"));
					order.setTotal(resultSet.getDouble("total"));
					order.setTransaction(resultSet.getString("transaction"));
					int deliveryAddress = resultSet.getInt("deliveryaddress");
					order.setDeliveryAddress(getAddressById(deliveryAddress));
					list.add(order);
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public boolean updateOrder(Order order, int addressId) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
			 sql.executeUpdate("update u579109085_jmdata.order set status='paid', orderdate='"+order.getOrder_date()+"', deliverydate='"+order.getDelivery_date()+"', subtotal="+order.getSubtotal()+", total="+order.getTotal()+", transaction='"+order.getTransaction()+"', deliveryaddress="+addressId+" where id="+order.getId()+";");
			 Address address = getAddressById(addressId);
			 Client client = getClientById(order.getClient_id());
				 if(address.getId() != 0) {
					 //Gmail.sendEmail(client.getEmail(), order, address);
				 }
			 sql.closeConnection();
			 return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return false;
	}

	@Override
	public int addOrder(Order order) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
			int id = 0;
			sql.executeUpdate("insert into u579109085_jmdata.order (id, client_id, status) values(null," + order.getClient_id() + ", 'ongoing');");
			ResultSet set = sql.executeQuery("SELECT LAST_INSERT_ID();");
			 while (set.next()) {
		        	id = set.getInt("LAST_INSERT_ID()");
		        }
			 set.close();
			 sql.closeConnection();
			 return id;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return 0;
	}

	@Override
	public ArrayList<Entry> getEntriesByOrderId(int OrderId) {
		
		ArrayList<Entry> list = new ArrayList<>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.entry where order_id="+ OrderId +";");
				
				while (resultSet.next()) {
					
					int id = resultSet.getInt("id");
					int quantity = resultSet.getInt("quantity");
					double price = resultSet.getDouble("price");
					Product product = getProductById(resultSet.getInt("product_id"));
					list.add(new Entry(id, OrderId, product, quantity, price));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public boolean updateEntry(int entryId, int quantity) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				sql.executeUpdate("update u579109085_jmdata.entry set quantity=" + quantity + " where id=" + entryId + ";");
				sql.closeConnection();
				return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return false;
	}

	@Override
	public boolean deleteEntry(int id) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
			sql.executeUpdate("delete u579109085_jmdata.entry from u579109085_jmdata.entry where id=" + id + ";");
				sql.closeConnection();
				return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return false;
	}

	@Override
	public int addEntry(Entry entry, int productId) {
		System.out.println(entry.toString());
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	int id=0;
		try{    
				sql.executeUpdate("insert into u579109085_jmdata.entry values(null, " + entry.getorderId() + ", " + productId + ", " + entry.getQuantity() + ", " + entry.getPrice() + ");");
				ResultSet set = sql.executeQuery("SELECT LAST_INSERT_ID();");
				 while (set.next()) {
			        	id = set.getInt("LAST_INSERT_ID()");
			        }
				 set.close();
				 sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return id;
	}

	@Override
	public ArrayList<Card> getCardsByClientId(int ClientId) {
		ArrayList<Card> list = new ArrayList<>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				ResultSet resultSet = sql.executeQuery("SELECT * FROM u579109085_jmdata.card where client_id="+ ClientId +";");
				
				while (resultSet.next()) {
					
					int id = resultSet.getInt("id");
					String type = resultSet.getString("type");
					String cardnumber = resultSet.getString("cardnumber");
					String securitycode = resultSet.getString("securitycode");
					String holdername = resultSet.getString("holdername");
					java.sql.Date dbSqlDate = resultSet.getDate("orderdate");
			        String expiry = (dbSqlDate.toString());
					list.add(new Card(id, ClientId, type, cardnumber, securitycode, holdername, expiry));
				}
				sql.closeConnection();
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return list;
	}

	@Override
	public boolean updateCard(Card card) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				sql.executeUpdate("update u579109085_jmdata.card set holdername='"+card.getHoldername()+"', expiration='"+card.getExpiration()+"'  where id="+ card.getCard_id() +";");
				sql.closeConnection();
				return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		return false;
	}

	@Override
	public boolean deleteCard(int id) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				sql.executeUpdate("delete u579109085_jmdata.card FROM u579109085_jmdata.card where id="+ id +";");
				sql.closeConnection();
				return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		
		return false;
	}

	@Override
	public boolean addCard(Card card) {
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	
		try{    
				sql.executeUpdate("insert into u579109085_jmdata.card values(null, "+card.getClient_id()+", '"+card.getType()+"', '"+card.getCard_number()+"', '"+card.getSecurity_code()+"', '"+card.holdername+"', '"+card.getExpiration()+"');");
				sql.closeConnection();
				return true;
			}
		catch(Exception e){ 
			System.out.println(e);
			}  
		
		return false;
	}


}
