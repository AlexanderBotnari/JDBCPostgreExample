package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

	private final String URL = "jdbc:postgresql://localhost/ecommerce?user=postgres&password=felicia&ssl=false";
	private Connection conn;
	
	public Connector() throws SQLException {
		conn = DriverManager.getConnection(URL);
	}
	
	public void createTable (String name) throws SQLException {
		String createTable_query ="CREATE TABLE "+name+"(id integer,name text)";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(createTable_query);
	}
	
	public void insert(String name , Integer id, String value) throws SQLException {
		String insert_table_query = "INSERT INTO "+name+"(id,name) VALUES ("+id+",'"+value+"')";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(insert_table_query);
	}
	
	public void select(String tableName) throws SQLException {
		String select_table_query = "SELECT * FROM "+tableName;
		Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(select_table_query);
	    
	    while(res.next()) {
	    	String name = res.getString("name");
	    	Integer id = res.getInt("id");
	    	
	    	System.out.println("id: "+id +". - "+name);
	    };
	}
	    
	 public void update(String tableName , Integer id , String name) throws SQLException {
		 String update_table_query = "UPDATE "+tableName+" SET name='"+name+"' WHERE id="+id;
		 Statement stm = conn.createStatement();
		 stm.executeUpdate(update_table_query);
	 }
	     
	public void delete(String tableName ,Integer id) throws SQLException {
		 String delete_table_query = "DELETE FROM "+tableName+" WHERE id="+id;
		 Statement stm = conn.createStatement();
		 stm.executeUpdate(delete_table_query);
	}

}
