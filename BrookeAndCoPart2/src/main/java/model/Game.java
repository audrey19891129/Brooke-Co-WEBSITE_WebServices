package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlType(name="Game")
@XmlAccessorType(XmlAccessType.FIELD)
public class Game extends Product{

	@XmlElement(name="console")
	public String console;
	@XmlElement(name="company")
    public String company;
	@XmlElement(name="reldate")
    public String reldate;
    
	public Game() {
		
	}
	
    public Game(int id, String pcode, String picture, String type, String title, String category, int inventory, String genre, double price, String console, String company, String reldate){
        super(id, pcode, picture, type, title, category, inventory, genre, price);
        this.console = console;
        this.company = company;
        this.reldate = reldate;
    }

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getReldate() {
		return reldate;
	}

	public void setReldate(String reldate) {
		this.reldate = reldate;
	}
    
    

    /*
    public Game(string pcode)
    {
        String request = "Select * from games where pcode='" + pcode + "';";
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DbDataReader reader = DBManager.executeQuery(request);

        while (reader.Read())
        {
            this.pcode = reader.GetString(0);
            this.console = reader.GetString(1);
            this.company = reader.GetString(2);
            DateTime date = reader.GetDateTime(3);
            this.reldate = date.ToString("yyyy-MM-dd");
            this.type = reader.GetString(4);
            this.category = reader.GetString(5);
            this.price = reader.GetDouble(6);
            this.picture = reader.GetString(7);
            this.title = reader.GetString(8);
            this.inventory = reader.GetInt32(9);
            this.genre = reader.GetString(12);
        }
        DBManager.closeConnection();
    }

    public static List<Game> getGameListByCategory(string cat)
    {
        String request = "Select * from games where category ='" + cat + "';";
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<Game> listeProduits = new List<Game>();

        while (reader.Read())
        {
            string pcode = reader.GetString(0);
            string console = reader.GetString(1);
            string company = reader.GetString(2);
            DateTime date = reader.GetDateTime(3);
            string reldate = date.ToString("yyyy-MM-dd");
            string type = reader.GetString(4);
            string category = reader.GetString(5);
            double price = reader.GetDouble(6);
            string picture = reader.GetString(7);
            string title = reader.GetString(8);
            int inventory = reader.GetInt32(9);
            string genre = reader.GetString(12);

            listeProduits.Add(new Game(pcode, picture, type, title, category, inventory, genre, price, console, company, reldate));
        }
        DBManager.closeConnection();
        return listeProduits;
    }
    public static List<Game> getGameList()
    {
        String request = "Select * from games";
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<Game> listeProduits = new List<Game>();

        while (reader.Read())
        {
            string pcode = reader.GetString(0);
            string console = reader.GetString(1);
            string company = reader.GetString(2);
            DateTime date = reader.GetDateTime(3);
            string reldate = date.ToString("yyyy-MM-dd");
            string type = reader.GetString(4);
            string category = reader.GetString(5);
            double price = reader.GetDouble(6);
            string picture = reader.GetString(7);
            string title = reader.GetString(8);
            int inventory = reader.GetInt32(9);
            string genre = reader.GetString(12);

            listeProduits.Add(new Game(pcode, picture, type, title, category, inventory, genre, price, console, company, reldate));
        }
        DBManager.closeConnection();
        return listeProduits;
    }

    public void save()
    {
        String request = "insert into product values(null, '" + pcode + "', '" + type + "', '" + category + "', " + price + ", '" + picture + "', '" + title + "','" + genre + "', 0, 0, 'inactive', 2 , 20)";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);

        request = "insert into game values('" + pcode + "', '" + console + "', '" + company + "', '" + reldate + "');";
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        lines = DBManager.executeUpdate(request);
        DBManager.closeConnection();
    }

    public void modify()
    {
        String request = "update product set type='" + type + "', category='" + category + "', price=" + price + ", title='" + title + "'  where pcode='" + pcode + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);

        request = "update book set console='" + console + "', company='" + company + "', reldate='" + reldate + "' where pcode='" + pcode + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        lines = DBManager.executeUpdate(request);
        DBManager.closeConnection();
    }

    public void delete()
    {
        String request = "DELETE game, product FROM game inner join product on product.pcode = game.pcode where game.pcode = '" + pcode + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
        DBManager.closeConnection();
    }
    */
}
