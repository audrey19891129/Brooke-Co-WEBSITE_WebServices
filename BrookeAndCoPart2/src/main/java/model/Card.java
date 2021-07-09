package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlType(name="Card")
@XmlAccessorType(XmlAccessType.FIELD)
public class Card {

	@XmlElement(name="id")
	public int card_id;
	
	@XmlElement(name="clientId")
    public int clientId;
	
	@XmlElement(name="type")
    public String type;
	
	@XmlElement(name="cardnumber")
    public String card_number;
	
	@XmlElement(name="securitycode")
    public String security_code;
	
	@XmlElement(name="holdername")
    public String holdername;
	
	@XmlElement(name="expiration")
    public String expiration;
    
    public Card() {
    	
    }
    
    public Card(int card_id, int clientId, String type, String card_number, String security_code, String holdername, String expiration)
    {
        this.card_id = card_id;
        this.clientId = clientId;
        this.type = type;
        this.card_number = card_number;
        this.security_code = security_code;
        this.holdername = holdername;
        this.expiration = expiration;
    }

    

	public int getCard_id() {
		return card_id;
	}


	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}


	public int getClient_id() {
		return clientId;
	}


	public void setClient_id(int client_id) {
		this.clientId = client_id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCard_number() {
		return card_number;
	}


	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}


	public String getSecurity_code() {
		return security_code;
	}


	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}


	public String getHoldername() {
		return holdername;
	}


	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}


	public String getExpiration() {
		return expiration;
	}


	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
    
    

    /*
    public static List<Card> getCardsByClientId(int client_id)
    {
        String request = "Select * from cards where client_id ='" + client_id + "';";
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<Card> listeCards = new List<Card>();

        while (reader.Read())
        {
            int card_id = reader.GetInt32(0);
            string type = reader.GetString(2);
            string card_number = reader.GetString(3);
            string security_code = reader.GetString(4);
            string holdername = reader.GetString(5);
            DateTime date = reader.GetDateTime(6);
            string expiration = date.ToString("yyyy-MM-dd");
            listeCards.Add(new Card(card_id, client_id, type, card_number, security_code, holdername, expiration));
        }
        DBManager.closeConnection();
        return listeCards;
    }

    public Card(int card_id)
    {
        String request = "Select * from cards where id='" + card_id + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);

        while (reader.Read())
        {
            this.card_id = card_id;
            this.client_id = reader.GetInt32(1);
            this.type = reader.GetString(2);
            this.card_number = reader.GetString(3);
            this.security_code = reader.GetString(4);
            this.holdername = reader.GetString(5);
            DateTime date = reader.GetDateTime(6);
            this.expiration = date.ToString("yyyy-MM-dd");
        }
        DBManager.closeConnection();
    }

    public void save()
    {
        String request = "insert into client_card values(null, " + client_id + ", '" + type + "', '" + card_number + "', " + security_code + ", '" + holdername + "', '" + expiration + "', 'active', null)";
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        int lines = DBManager.executeUpdate(request);
    }

    public void saveTemporary(string delete_on)
    {
        String request = "insert into client_card values(null, " + client_id + ", '" + type + "', '" + card_number + "', " + security_code + ", '" + holdername + "', '" + expiration + "', 'active',  "+ delete_on + ")";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }

    public void modify()
    {
        String request = "update client_card set expiration_date='" + expiration + "', holdername='"+holdername+"' where id=" + card_id;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }

    public void changeStatus(String status)
    {
        String request = "update client_card set status='"+status+"' where id=" + card_id;
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
    }
    */
}
