package Forms;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
public class Posts {
	private int id;
	private int UserId;
	private Date date;
	private String email;
	private String text;
	private Time time;
	public int getUserId() {
		return UserId;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
	public Posts(int id, String text,Date date,Time time,int UserId,String  email) {
		this.UserId=UserId;
		this.date=date;
		this.time=time;
		this.id = id;
		this.text = text;
		this.email=email;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Posts( String text,int UserId) {
		this.UserId=UserId;
	    this.text = text;
	}
	
	
	public void addPosts(){
		
		DbRequest db = new DbRequest();
		db.addPosts(UserId,text);
		
	}
	
	public ArrayList<Posts> givePosts() {
		ArrayList<Posts> posts=new ArrayList<Posts>();
		DbRequest db = new DbRequest();
		posts=db.givePosts();
		return posts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
