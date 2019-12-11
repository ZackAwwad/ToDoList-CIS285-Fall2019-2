/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp;

/**
 *
 * @author Duncan Rodman
 */
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public Connection DbConnect() throws ClassNotFoundException, SQLException { //connects to the MS Access DB and returns the connection
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		String path = System.getProperty("user.dir")+"\\"+"ToDoDB.accdb";
		String url = "jdbc:ucanaccess://"+path;
		Connection con = DriverManager.getConnection(url);
		return con;
    }
	public void taskUpdate(Timestamp datecreated, String tasktext, int taskId) throws ClassNotFoundException, SQLException { //takes creation date, task text, and task ID values and sets them accordingly in the database.       
		
        String query = "UPDATE tasks SET datecreated=?, tasktext=? WHERE taskid=?";
        PreparedStatement pst = DbConnect().prepareStatement(query);
        pst.setTimestamp(1, datecreated);
        pst.setString(2, tasktext);
        pst.setInt(3, taskId);
        pst.executeUpdate();
        pst.close();
        
        
	}
	public void taskDelete(int userid, int taskid) throws ClassNotFoundException, SQLException { //deletes a task (the whole row) from the database
		
        String query = "DELETE FROM tasks WHERE userid=? AND taskid=?";
        PreparedStatement pst = DbConnect().prepareStatement(query);
        pst.setInt(1, userid);
        pst.setInt(2, taskid);
        pst.execute();
        pst.close();		
	}
	public void addUser(User user) throws ClassNotFoundException, SQLException {//inserts a new username, password, and permission flag into the database
		String add = "INSERT INTO users (username, password, permission) VALUES(?,?,?)";
		PreparedStatement pst = DbConnect().prepareStatement(add);
		pst.setString(1, user.getName());
		pst.setString(2, user.getPass());
		pst.setInt(3, user.getPermission());
		pst.executeUpdate();
		}
	public void addTask(User user) throws ClassNotFoundException, SQLException {//adds a new task for a specific user to the database
		String add = "INSERT INTO tasks(userid, datecreated, tasktext) VALUES(?,?,?)";
		PreparedStatement pst = DbConnect().prepareStatement(add);
		pst.setInt(1, task.getUserId());
        pst.setTimestamp(2, task.getDatecreated());
        pst.setString(3, task.getDescription());
		pst.executeUpdate();
		}
    public ResultSet getUserTasks(int userid) throws ClassNotFoundException, SQLException {//returns a resultset of all tasks assigned to a specific user from the database
    	
        ResultSet taskSet = null;
        
        String query = "SELECT * FROM tasks WHERE userid=?";
        PreparedStatement pst = DbConnect().prepareStatement(query);
        pst.setInt(1, userid);
        taskSet = pst.executeQuery(); 
        
        return taskSet;
	}
}