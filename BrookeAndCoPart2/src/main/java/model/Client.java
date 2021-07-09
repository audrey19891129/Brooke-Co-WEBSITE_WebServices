package model;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlType(name="Client")
@SOAPBinding(style=Style.DOCUMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

	@XmlElement(name="id")
	public int id;
	
	@XmlElement(name="email")
    public String email;
	
	@XmlElement(name="password")
    public String password;
	
	@XmlElement(name="firstname")
    public String firstname;
	
	@XmlElement(name="lastname")
    public String lastname;
	
	@XmlElementWrapper(name="addresses")
    @XmlElement(name="address")
    public List<Address> addresses;
	
	@XmlElementWrapper(name="orders")
    @XmlElement(name="order")
    public List<Order> orders;
	
    public Client() {
    	this.addresses = new ArrayList<Address>();
        this.orders = new ArrayList<Order>();
    }

    public Client(int id, String email, String password, String firstname, String lastname){
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresses = new ArrayList<Address>();
        this.orders = new ArrayList<Order>();
    }

    public Client(String email,String password, String firstname, String lastname)
    {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresses = new ArrayList<Address>();
        this.orders = new ArrayList<Order>();
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> adresses) {
		this.addresses = adresses;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", email=" + email + ", password=" + password + ", name="
				+ firstname + ", lastname=" + lastname + ", addresses=" + addresses + ", orders=" + orders + "]";
	}
    
    

    /*
    public Client(int id)
    {

        String request = "Select * from clients where id=" + id + ";";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);

        while (reader.Read())
        {
            this.id = reader.GetInt32(0);
            this.email = reader.GetString(1);
            this.username = reader.GetString(2);
            this.password = reader.GetString(3);
            this.name = reader.GetString(4);
            this.lastname = reader.GetString(5);
            DateTime date = reader.GetDateTime(6);
            this.bday = date.ToString("yyyy-MM-dd");
            this.orders = new List<Order>();
            this.adresses = new List<DeliveryAdress>();
        }
        DBManager.closeConnection();
    }

    public Client(string user, string pass)
    {
        String request = "Select * from clients where username='" + user + "' and password='" + pass + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        while (reader.Read())
        {
            this.id = reader.GetInt32(0);
            this.email = reader.GetString(1);
            this.username = reader.GetString(2);
            this.password = reader.GetString(3);
            this.name = reader.GetString(4);
            this.lastname = reader.GetString(5);
            DateTime date = reader.GetDateTime(6);
            this.bday = date.ToString("yyyy-MM-dd");
            this.orders = new List<Order>();
            this.adresses = new List<DeliveryAdress>();
        }
        DBManager.closeConnection();
    }

    public Client(string request)
    {
        //String request = "Select * from clients where username='" + username + "'";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        while (reader.Read())
        {
            try
            {
                this.id = reader.GetInt32(0);
                this.email = reader.GetString(1);
                this.username = reader.GetString(2);
                this.password = reader.GetString(3);
                this.name = reader.GetString(4);
                this.lastname = reader.GetString(5);
                DateTime date = reader.GetDateTime(6);
                this.bday = date.ToString("yyyy-MM-dd");
                this.orders = new List<Order>();
                this.adresses = new List<DeliveryAdress>();
            }
            catch
            {
                this.id = 0;
                this.email = "";
                this.username = "";
                this.password = "";
                this.name = "";
                this.lastname = "";
                this.bday = "";
                this.orders = new List<Order>();
                this.adresses = new List<DeliveryAdress>();
            }
           
        }
        DBManager.closeConnection();
    }

    public static List<Client> getClientsList()
    {
        String request = "Select * from clients";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<Client> listeClients = new List<Client>();

        while (reader.Read())
        {
            int id = reader.GetInt32(0);
            string email = reader.GetString(1);
            string username = reader.GetString(2);
            string password = reader.GetString(3);
            string name = reader.GetString(4);
            string lastname = reader.GetString(5);
            DateTime date = reader.GetDateTime(6);
            string bday = date.ToString("yyyy-MM-dd");

            listeClients.Add(new Client(id, email, username, password, name, lastname, bday));
        }
        DBManager.closeConnection();
        return listeClients;
    }


    public void save()
    {
        String request = "insert into client (email, username, password, name, lastname, bday) values('" + email + "', '" + username + "', '" + password + "', '" + name + "', '" + lastname + "', '" + bday +"')";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }

    public void modify()
    {
        String request = "update client set email='" + email + "', username='" + username + "', password='" + password + "', name='" + name + "', lastname='" + lastname + "', bday='" + bday +"' where id =" + id;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }

    public void delete()
    {
        String request = "update client set status='inactive' where id=" + id;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }
    */
}
