package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlType(name="Address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	@XmlElement(name="id")
	public int id;
	
	@XmlElement(name="country")
    public String country;
	
	@XmlElement(name="province")
    public String province;
	
	@XmlElement(name="city")
    public String city;
	
	@XmlElement(name="street")
    public String street;
	
	@XmlElement(name="civicnumber")
    public int civicnumber;
	
	@XmlElement(name="appartment")
    public String appartment;
	
	@XmlElement(name="zipcode")
    public String zipcode;
	
	@XmlElement(name="clientId")
    public int clientId;

    public Address() {
    	this.id=0;
	}

	public Address(int id, String country, String province, String city, String street, int civicnumber, String appartment, String zipcode, int clientId) {
		this.id = id;
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.civicnumber = civicnumber;
		this.appartment = appartment;
		this.zipcode = zipcode;
		this.clientId = clientId;
	}

	public int getId() {
		return id;
	}

	public void setId(int delivery_id) {
		this.id = delivery_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getCivicnumber() {
		return civicnumber;
	}

	public void setCivicnumber(int civicnumber) {
		this.civicnumber = civicnumber;
	}

	public String getAppartment() {
		return appartment;
	}

	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getClient_id() {
		return clientId;
	}

	public void setClient_id(int client_id) {
		this.clientId = client_id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", province=" + province + ", city=" + city + ", street="
				+ street + ", civicnumber=" + civicnumber + ", appartment=" + appartment + ", zipcode=" + zipcode
				+ ", clientId=" + clientId + "]";
	}
	
	

    /*
    public DeliveryAdress(int id)
    {
        String request = "Select * from delivery_adresses where id=" + id + ";";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);

        while (reader.Read())
        {
            this.delivery_id = reader.GetInt32(0);
            this.country = reader.GetString(1);
            this.province = reader.GetString(2);
            this.city = reader.GetString(3);
            this.street = reader.GetString(4);
            this.civicnumber = reader.GetInt32(5);
            this.appartment = reader.GetString(6);
            this.zipcode = reader.GetString(7);
            this.client_id = reader.GetInt32(8);
        }
        DBManager.closeConnection();
    }

    
    public static List<DeliveryAdress> getDeliveryAdressList()
    {
        String request = "Select * from delivery_adresses";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<DeliveryAdress> listeClients = new List<DeliveryAdress>();

        while (reader.Read())
        {
            int delivery_id = reader.GetInt32(0);
            string country = reader.GetString(1);
            string province = reader.GetString(2);
            string city = reader.GetString(3);
            string street = reader.GetString(4);
            int civicnumber = reader.GetInt32(5);
            string appartment = reader.GetString(6);
            string zipcode = reader.GetString(7);
            int client_id = reader.GetInt32(8);
            listeClients.Add(new DeliveryAdress(delivery_id, country, province, city, street, civicnumber, appartment, zipcode, client_id));
        }
        DBManager.closeConnection();
        return listeClients;
    }

    public static List<DeliveryAdress> getInactiveDeliveryAdressList(int clientId)
    {
        String request = "Select * from inactive_addresses where client_id = " + clientId;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<DeliveryAdress> listeClients = new List<DeliveryAdress>();

        while (reader.Read())
        {
            int delivery_id = reader.GetInt32(0);
            string country = reader.GetString(1);
            string province = reader.GetString(2);
            string city = reader.GetString(3);
            string street = reader.GetString(4);
            int civicnumber = reader.GetInt32(5);
            string appartment = reader.GetString(6);
            string zipcode = reader.GetString(7);
            int client_id = reader.GetInt32(8);
            listeClients.Add(new DeliveryAdress(delivery_id, country, province, city, street, civicnumber, appartment, zipcode, client_id));
        }
        DBManager.closeConnection();
        return listeClients;
    }

    public static List<DeliveryAdress> getDeliveryAdressListByClientId(int clientId)
    {
        String request = "Select * from adresses where client_id=" + clientId;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<DeliveryAdress> listeClients = new List<DeliveryAdress>();

        while (reader.Read())
        {
            int delivery_id = reader.GetInt32(0);
            string country = reader.GetString(1);
            string province = reader.GetString(2);
            string city = reader.GetString(3);
            string street = reader.GetString(4);
            int civicnumber = reader.GetInt32(5);
            string appartment = reader.GetString(6);
            string zipcode = reader.GetString(7);
            int client_id = reader.GetInt32(8);
            listeClients.Add(new DeliveryAdress(delivery_id, country, province, city, street, civicnumber, appartment, zipcode, client_id));
        }
        DBManager.closeConnection();
        return listeClients;
    }



    public void save()
    {
        String request = "insert into deliveryaddress values(null, " + client_id + ", '" + country + "', '" + province + "', '" + city + "', '" + street + "', " + civicnumber + ", " + appartment + ", '" + zipcode + "', 'active')";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }

    public void modify()
    {
        String request = "update deliveryaddress set country='" + country + "', province='" + province + "', city='" + city + "', street='" + street + "', civicnumber=" + civicnumber + ", appartment=" + appartment + ", zipcode='" + zipcode + "' where id=" + delivery_id;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }

    public void delete()
    {
        String request = "update deliveryaddress set status='inactive' where id=" + delivery_id;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }

    public void activate()
    {
        String request = "update deliveryaddress set status='active' where id=" + delivery_id;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }
    */
}
