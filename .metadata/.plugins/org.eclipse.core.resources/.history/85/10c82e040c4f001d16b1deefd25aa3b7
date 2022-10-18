package ecomproj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdminOperations {
	public static Scanner sc=new Scanner(System.in);
	private static List<Product>list=new LinkedList<>();
	public int getPricePbyId(int id)
	{
		//System.out.println("id="+id);
		Product p = (Product) AdminOperations.list.get((id-1));//as id=1 means first product in table but in list it is of 0th no row product
		//System.out.println(p);
	//	System.out.println( p.getP_price());

		return p.getP_price();
		
	}
	public boolean changeProductQuantity(int id,int quantity)
	{//after buying roduct to change product quantity
		System.out.println("inside changeProductQuantity method");
		Product product = new Product();
		
		for(Product p:list)
		{
			if(p.getPid()==id)
			{
				product.setP_name(p.getP_name());
				product.setP_descrition(p.getP_descrition());
				product.setP_price(p.getP_price());
				product.setPa_quantity((p.getPa_quantity()-quantity));
				product.setPid(p.getPid());
				break;

			}
		}
			System.out.println("index updated="+(id-1)+" product updated to is="+product);
		AdminOperations.list.set((id-1), product);
		System.out.println("quantity changed in list");
		
		return true;

	}
	public Product getProductById(int id)
	{
		Product product=null;
		for(Product p:list)
		{
			if(p.getPid()==id)
			{
				product= p;
				break;
			}
		}
		return product;
		
	}
	public void getAllProduct()
	{
		System.out.println("getting products");
		              Connection conn=MySqlConnection.getConnection();
						try {
							Statement st = conn.createStatement();
							
							ResultSet rs=st.executeQuery("SELECT * FROM mini_proj.product order by pid ASC");
							while(rs.next())
							{
								Product p=new Product(rs.getInt("pid"),rs.getString("p_name"),rs.getString("p_descrition"),rs.getInt("p_price"),rs.getInt("pa_quantity"));
								list.add(p);
//								System.out.println(rs.getInt("pid")+" "+ "productNname="+rs.getString("p_name")+" ,"+rs.getString("p_descrition")+", "+" price="+rs.getInt("p_price")+" ,"+" quantity="+rs.getInt("pa_quantity"));
//								System.out.println();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
		
		return ;
		
		
	}
	
	
	
	public void getListOfProduct()
	{
		System.out.println("getting list of  products");
					
		
		for(Product p:list)
		{
			System.out.println(p);
		}
		
		
	}
	public void addProduct()
	{
		try {
			Connection conn=MySqlConnection.getConnection();

			String sql="insert into product(p_name,p_descrition,p_price,pa_quantity) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

				System.out.println("Enter new Product information:\n");
				System.out.println("\n Enter price of product:");
				ps.setInt(3, sc.nextInt());

				System.out.println("\nEnter available quantity of product: ");
				ps.setInt(4, sc.nextInt());
				System.out.println("Enter name of new product:");
				ps.setString(1, sc.next());
				System.out.println("\n Enter description of product:");
				ps.setString(2, sc.next());
System.out.println();
				

				int rowsUpdated = ps.executeUpdate();
			
				list.clear();
				this.getAllProduct();
				System.out.println("rowsUpdated="+rowsUpdated);
							

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void historyOfProduct(int uid, int pid) {
		Connection conn=MySqlConnection.getConnection();
	
			try {
				PreparedStatement ps1=conn.prepareStatement("select * from ecom_history where uid=? and pid=?");
				ps1.setInt(1, uid);
				ps1.setInt(2, pid);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					System.out.println("cid="+rs.getInt("cid")+" uid="+rs.getInt("uid")+" pid="+rs.getInt("pid")+" bquantity="+rs.getInt("bquantity")+" total_amount="+rs.getInt("total_amount")+" payment_status="+rs.getString("payment_status"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public String varifyAdmin(String role, String name) {
		Connection conn=MySqlConnection.getConnection();
		
		try {
			PreparedStatement ps1=conn.prepareStatement("select * from ecom_user where u_name=? and role=? ");
			ps1.setString(1, name);
			ps1.setString(2, role);
			ResultSet rs=ps1.executeQuery();
			
			if(rs.next()) {
				String w=rs.getString("u_name");
				System.out.println("w="+w);
				if(w.equals(name)) {
					
					return "varified";
				}
			}else {
				
				return "notvarified";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

}
