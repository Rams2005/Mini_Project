package ecomproj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserOperations {
	public static Scanner sc=new Scanner(System.in);
	AdminOperations adminOperation = new AdminOperations();

	public void getUserList()
	{
		System.out.println("User List:\n");

		Connection conn=MySqlConnection.getConnection();
		try {
			PreparedStatement ps1=conn.prepareStatement("select * from ecom_user");
			ResultSet rs = ps1.executeQuery();
			while(rs.next())
			{
				

				System.out.println("uid="+rs.getInt("uid")+" u_name="+rs.getString("u_name")+" address="+rs.getString("address")+" email="+rs.getString("email")+" role="+rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void reducePQuantityDB(int id,int quantity)
	{
		try {
		Connection conn=MySqlConnection.getConnection();
		PreparedStatement ps1=conn.prepareStatement("select * from product where pid=?");
		ps1.setInt(1, id);
		ResultSet rs=ps1.executeQuery();
		int dbQuantity=0;
		if(rs.next())
		{
			 dbQuantity=rs.getInt("pa_quantity");
		}
		String sql="update product set pa_quantity=? where pid=?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("dbQuantity-quantity="+(dbQuantity-quantity));
			ps.setInt(1,(dbQuantity-quantity) );
			ps.setInt(2, id);
			int r = ps.executeUpdate();
			System.out.println("quantity updated in database for id="+id+" new quantity="+(dbQuantity-quantity)+" rows affected="+r);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	
	
	
	
	public void cart(int userId)
	{
					Map<Integer,Integer> m=new HashMap<>();
	             	
					CartClass newCart=new CartClass();
	             	boolean status=true;
	        		while(status)
	        		{
	        			System.out.println("Do you want to buy product\n1.yes\n2.no");
	        			int n=sc.nextInt();
	        			if(n==1)
	        			{
	        				
	        				adminOperation.getListOfProduct();
	        				System.out.println("Enter product number which you want to buy:");
	        				int id=sc.nextInt();
	        				System.out.println("Enter the quantity:");
	        				int quantity=sc.nextInt();
	    	             	m.put(id, quantity);


	        			}
	        			else
	        			{
	        				status=false;
	        			}
	        		}
	        			
	        			System.out.println("Do you want to make payment\n1.yes\n2.no");
	        			int j=sc.nextInt();
	        			if(j==1)
	        			{
	        				int totalAmount=0;

	        				for(Map.Entry<Integer,Integer> e:m.entrySet())
		        			{
	        					System.out.println("key="+(int)e.getKey()+" value="+(int)e.getValue());
	        	
	        					adminOperation.changeProductQuantity((int)e.getKey(), (int)e.getValue());
	        
	        					this.reducePQuantityDB((int)e.getKey(), (int)e.getValue());
	        					totalAmount=totalAmount+(adminOperation.getPricePbyId((int)e.getKey())*(int)e.getValue());
	        					//System.out.println("TotalAmount="+totalAmount);
		        			}
		        		
		        			System.out.println("Total AMOUNT= "+totalAmount);
		        			System.out.println("-----------------------------------------");

		        			System.out.println("Payment successfully done!\n Bill Generated:\n\n");
		        			//values added in history table
		        					        			 
		        			
		        			for(Map.Entry<Integer,Integer> e:m.entrySet())
		        			{
		        				Connection conn=MySqlConnection.getConnection();
			        			String sql1="insert into ecom_History (uid,pid,bquantity,total_amount,payment_status)values(?,?,?,?,?)";
			        			try {
									PreparedStatement ps1=conn.prepareStatement(sql1);
                                     ps1.setInt(1, userId);		//		 to set userid					
									ps1.setInt(2, (int)e.getKey());//pid
									ps1.setInt(3, (int)e.getValue());//quantity
									int price=adminOperation.getPricePbyId((int)e.getKey());
									ps1.setInt(4, (price*(int)e.getValue()));
									ps1.setString(5,"Y");
									int executeUpdaterows = ps1.executeUpdate();
								//	System.out.println("rows updated in history table:"+executeUpdaterows);
								//	System.out.println();
									
									Product p1=adminOperation.getProductById( (int)e.getKey());
									p1.setPa_quantity((int)e.getValue());
									System.out.println(p1);

	
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
			        			

	        	
	        
		        			}
		        			System.out.println("-----------------------------------------");
		        			
		        			System.out.println("Total AMOUNT= "+totalAmount);
		        			System.out.println("Payment Status = Completed");
		        			System.out.println("-----------------------------------------");
	        			}
	        			adminOperation.getAllProduct();

	        			
	        			

	        					
	}
	

	
	
	public void addNewUser()
	{
		try {
			Connection conn=MySqlConnection.getConnection();

			String sql="insert into ecom_user(u_name,address,email,role)values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

				System.out.println("Enter new User information:");
				System.out.println("Enter your name :");
				ps.setString(1, sc.next());
				System.out.println("\nEnter your address :");
				ps.setString(2, sc.next());

				System.out.println("\nEnter your email :");
				ps.setString(3, sc.next());
				System.out.println("\nAre you  customer?\n1.yes\n2.no");
				int c=sc.nextInt();
				if(c==1)
				{
					ps.setString(4, "user");

				}
				else {
					ps.setString(4, "admin");

				}

				int rowsUpdated = ps.executeUpdate();
				System.out.println("rowsUpdated="+rowsUpdated);
							

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
