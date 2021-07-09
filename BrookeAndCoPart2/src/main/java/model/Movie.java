package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlType(name="Movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie extends Product{

	@XmlElement(name="director")
	public String director;
	
	@XmlElement(name="actors")
    public String actors;
	
	@XmlElement(name="relyear")
    public String relyear;

	public Movie() {
		
	}

    public Movie(int id, String pcode, String picture, String type, String title, String category, int inventory, String genre, double price, String director, String actors, String relyear){
        super(id, pcode, picture, type, title, category, inventory, genre, price);
        this.director = director;
        this.actors = actors;
        this.relyear = relyear;
    }
    
	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getActors() {
		return actors;
	}


	public void setActors(String actors) {
		this.actors = actors;
	}


	public String getRelyear() {
		return relyear;
	}


	public void setRelyear(String relyear) {
		this.relyear = relyear;
	}

    
    /*
    public Movie(string pcode)
    {
        String request = "Select * from movies where pcode='" + pcode + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);

        while (reader.Read())
        {
            this.pcode = reader.GetString(0);
            this.director = reader.GetString(1);
            this.actors = reader.GetString(2);
            DateTime date = reader.GetDateTime(3);
            this.relyear = date.ToString("yyyy");
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

    public static List<Movie> getMovieListByCategory(string cat)
    {
        String request = "Select * from movies where category ='" + cat + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<Movie> listeProduits = new List<Movie>();

        while (reader.Read())
        {
            string pcode = reader.GetString(0);
            string director = reader.GetString(1);
            string actors = reader.GetString(2);
            DateTime date = reader.GetDateTime(3);
            string relyear = date.ToString("yyyy");
            string type = reader.GetString(4);
            string category = reader.GetString(5);
            double price = reader.GetDouble(6);
            string picture = reader.GetString(7);
            string title = reader.GetString(8);
            int inventory = reader.GetInt32(9);
            string genre = reader.GetString(12);

            listeProduits.Add(new Movie(pcode, picture, type, title, category, inventory, genre, price, director, actors, relyear));
        }
        DBManager.closeConnection();
        return listeProduits;
    }
    public static List<Movie> getMovieList()
    {
        String request = "Select * from movies";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        DbDataReader reader = DBManager.executeQuery(request);
        List<Movie> listeProduits = new List<Movie>();

        while (reader.Read())
        {
            string pcode = reader.GetString(0);
            string director = reader.GetString(1);
            string actors = reader.GetString(2);
            DateTime date = reader.GetDateTime(3);
            string relyear = date.ToString();
            string type = reader.GetString(4);
            string category = reader.GetString(5);
            double price = reader.GetDouble(6);
            string picture = reader.GetString(7);
            string title = reader.GetString(8);
            int inventory = reader.GetInt32(9);
            string genre = reader.GetString(12);

            listeProduits.Add(new Movie(pcode, picture, type, title, category, inventory, genre, price, director, actors, relyear));
        }
        DBManager.closeConnection();
        return listeProduits;
    }

    public void save()
    {
        String request = "insert into product values(null, '" + pcode + "', '" + type + "', '" + category + "', " + price + ", '" + picture + "', '" + title + "','" + genre + "', 0, 0, 'inactive', 3 , 20)";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);

        request = "insert into movie values('" + pcode + "', '" + director + "', '" + actors + "', '" + relyear + "');";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
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

        request = "update book set director='" + director + "', actors='" + actors + "', relyear='" + relyear + "' where pcode='" + pcode + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        lines = DBManager.executeUpdate(request);
        DBManager.closeConnection();
    }

    public void delete()
    {
        String request = "DELETE movie, product FROM movie inner join product on product.pcode = movie.pcode where movie.pcode = '" + pcode + "';";
        //DBManager.createConnection("sql3.freemysqlhosting.net", "sql3373608", "sql3373608", "cHKivCByKH", 3306);
        DBManager.createConnection("localhost", "brookeandco", "root", "buzzy2626", 3306);
        int lines = DBManager.executeUpdate(request);
        DBManager.closeConnection();
    }
    */
}
