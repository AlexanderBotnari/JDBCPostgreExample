package main;

import java.sql.SQLException;

import connector.Connector;

public class Application {

	public static void main(String[] args) throws SQLException {
		
		Connector conn = new Connector();
		
		//create
//		conn.createTable("categories");
		
		
		//insert
//		conn.insert("products", 1, "Puma");
//		conn.insert("products", 2, "Adidas");
//		conn.insert("products", 3, "Nike");
//		conn.insert("products", 4, "Jordan");
//		conn.insert("products", 5, "D&G");
		
		
		//select
	//	conn.select("products");
		
		//update
//		conn.update("products",1,"Lacoste");
		
		//delete
		conn.delete("products", 3);
	}

}
