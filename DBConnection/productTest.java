package db;

import java.util.ArrayList;

public class productTest {

	public static void main(String[] args) {

		Db<Integer, Product> db = new ProductDb("127.0.0.1", "db", "db");

		// insert
		Product product = new Product(7, "치마", 7000, 7.3);
		try {
			db.insert(product);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
		// select
		Product product2 = null;
		try {
			product2 = db.select(2); 
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		System.out.println(product2);
		
		
		// update
		Product product3 = new Product(9, "점퍼", 10000, 83.8);
		try {
			db.update(product3); 
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
		
		// delete
		try {
			db.delete(1); 
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
		
		// selectAll
		ArrayList<Product> list = new ArrayList<>();
		try {
			list = db.select();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		for(Product u : list) {
			System.out.println(u);
		}
	}

}
