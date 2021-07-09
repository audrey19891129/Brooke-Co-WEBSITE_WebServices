package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;
import model.Client;
import model.Product;
import model.SQLConnection;

public class ClassTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServicesWSImpl sv = new ServicesWSImpl();
		
		/*
		sv.init();
		ArrayList<Client> clients = sv.getClients();
		
		for(Client client : clients) {
			System.out.println(client.toString());
		}
		*/
		/*
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
		*/
		ArrayList<Book> list = new ArrayList<Book>();
		SQLConnection sql = new SQLConnection();
    	sql.openConnection();
    	String category = "Literature";
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
		
		for(Book pr : list) {
			System.out.println(pr.toString());
		}
	}

}
