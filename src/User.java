
public class User {
	
	private String userName;// declare private variables to get/set
	private String userPass;
	private int userPermiss = 0;
	private String userID;

	public String getKey (String key) {//returns userid variable
		return userID;
		
	}
	
	public String getName () {//returns username
		return userName;
	}
	
	public String getPass () {//returns pass
		return userPass;
	}
	
	public int getPermission () {//return permission flag
		return userPermiss;	
	}
	
	public void setName (String name) {	//sets private variable username to argument passed to it
		this.userName = name;
	}
	
	public void setPass (String pass) {//sets private variable password to argument passed to it
		this.userPass = pass;
		
	}
	
	
}