package controller;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import model.*;

@WebService(serviceName="BrookeAndCo")
public interface ServicesWS {

	//PRODUCTS
		@WebMethod(operationName = "PRODUCT_ID")
		public @WebResult(name="Product")Product getProductById(@WebParam(name="id")int id);
		
		@WebMethod(operationName = "PRODUCT_Title")
		public  @WebResult(name="Product")List<Product> getProductByTitle(@WebParam(name="title")String title);
		
		@WebMethod(operationName = "PRODUCT_List", action = "call_PRODUCT_List")
		public @WebResult(name="Product")List<Product> getProducts();
		
//		@WebMethod
//		public boolean updateProduct(@WebParam(name="id")int id);
		
		@WebMethod(operationName = "PRODUCT_Update")
		public boolean updateProduct(@WebParam(name="Entry")Entry entry);
	

	//BOOKS 
		@WebMethod(operationName = "BOOK_List")
		public  @WebResult(name="Book")List<Book> getBooks();
	   
		@WebMethod(operationName = "BOOK_Category")
		public  @WebResult(name="Book")List<Book> getBooksByCategory(@WebParam(name="category")String category);
		
		@WebMethod(operationName = "BOOK_ID")
		public  @WebResult(name="Book")Book getBookById(@WebParam(name="id")int id);
	
	//GAMES 
		@WebMethod(operationName = "GAME_List")
		public  @WebResult(name="Game")List<Game> getGames();
	   
		@WebMethod(operationName = "GAME_Category")
		public  @WebResult(name="Game")List<Game> getGamesByCategory(@WebParam(name="category")String category);
		
		@WebMethod(operationName = "GAME_ID")
		public  @WebResult(name="Game")Game getGamebyId(@WebParam(name="id")int id);
		
		
	//MOVIES 
		@WebMethod(operationName = "MOVIE_List")
		public  @WebResult(name="Movie")List<Movie> getMovies();
	   
		@WebMethod(operationName = "MOVIE_Category")
		public @WebResult(name="Movie")List<Movie> getMoviesByCategory(@WebParam(name="category")String category);
		
		@WebMethod(operationName = "MOVIE_ID")
		public @WebResult(name="Movie")Movie getMoviebyId(@WebParam(name="id")int id);
	

	//CLIENTS 
		
		@WebMethod(operationName = "CLIENT_EMAIL")
		public @WebResult(name="Client")Client getClientByEmail(@WebParam(name="email")String email);

		@WebMethod(operationName = "CLIENT_Login")
		public @WebResult(name="Client")Client login(@WebParam(name="email")String email, @WebParam(name="password")String password);
		
		@WebMethod(operationName = "CART")
		public ArrayList<Order> getCartOrdersByClientId(@WebParam(name="id")int ClientId);
		
		@WebMethod(operationName = "CLIENT_Add")
		public int addClient(@WebParam(name="Client") Client client);
		
		@WebMethod(operationName = "CLIENT_Update")
		public boolean updateClient(@WebParam(name="Client") Client client);
	
		
	//ADDRESSES
		@WebMethod(operationName = "ADDRESS_AddressesByClientId")
		public List<Address> getAddressesByClientId(@WebParam(name="ClientId")int ClientId);
		
		@WebMethod(operationName = "ADDRESS_UPDATE")
		public boolean updateAddress(@WebParam(name="id")Address address);
		
		@WebMethod(operationName = "ADDRESS_ADD")
		public int addAddress(@WebParam(name="Address")Address address);

	//ORDERS
		@WebMethod(operationName = "ORDER_GETBYCLIENTID")
		public List<Order> getOrdersByClientId(@WebParam(name="ClientId")int ClientId);
		
		@WebMethod(operationName = "ORDER_UPDATE")
		public boolean updateOrder(@WebParam(name="Order")Order order, @WebParam(name="AddressId")int addressId);
		
		@WebMethod(operationName = "ORDER_ADD")
		public int addOrder(@WebParam(name="Order")Order order);
		
		
	//ENTRY
		@WebMethod(operationName = "ENTRY_EntriesByOrderId")
		public List<Entry> getEntriesByOrderId(@WebParam(name="OrderId")int OrderId);
		
		@WebMethod(operationName = "ENTRY_UPDATE")
		public boolean updateEntry(@WebParam(name="entryId")int entryId, @WebParam(name="quantity")int quantity);
		
		@WebMethod(operationName = "ENTRY_DELETE")
		public boolean deleteEntry(@WebParam(name="id")int id);
		
		@WebMethod(operationName = "ENTRY_ADD")
		public int addEntry(@WebParam(name="Entry")Entry entry, @WebParam(name="productId")int productId);
		
		
	//CARDS
		@WebMethod
		public List<Card> getCardsByClientId(@WebParam(name="ClientId")int ClientId);
		
		@WebMethod
		public boolean updateCard(@WebParam(name="Card")Card card);
		
		@WebMethod
		public boolean deleteCard(@WebParam(name="id")int id);
		
		@WebMethod
		public boolean addCard(@WebParam(name="Card")Card card);
	
}
     