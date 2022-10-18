package ecomproj;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		
		
		System.out.println("-----------------------------------------------------------");
		
		
		
		Scanner sc = new Scanner(System.in);
		AdminOperations adminOperation = new AdminOperations();
		UserOperations userOperation=new UserOperations();
		adminOperation.getAllProduct();

		try {
			while (true) {
				System.out.println("Enter \n0.exit\n1.Admin\n2.User");
				int n = sc.nextInt();
				switch (n) {
				case 0:
					System.out.println("0 th case");

					System.exit(0);
					break;
				case 1:// admin
					System.out.println("1 st case");
					System.out.println("Are you admin \n1.Yes\n2.No");
					int t=sc.nextInt();
					//boolean status=false;
					
					if(t==1) {
						String role="admin";
						System.out.println("Enter Your Username");
						String name=sc.next();
						String result=adminOperation.varifyAdmin(role,name);
					if(result.equals("notvarified")) {
						System.out.println("You are not registered admin");
						break;
					}
					}else {
						break;
					}
					System.out.println("Enter\n1.Add new product\n2.Get all product\n3.Check the quantity of each product by using the product id\n4.Display the entire registered user list\n5.to check the particular user history for product purchase details.");
					int k=sc.nextInt();
					if(k==1)
					{
					boolean status=true;
					while(status)
					{
						System.out.println("Do you want to add new product enter \n1 for yes \n2 for no");
						int m=sc.nextInt();
						if(m==1)
						{
							adminOperation.addProduct();
							System.out.println("product added");
						}
						else
						{
							status=false;
						}
						

					}
					}
					else if(k==2)
					{
						adminOperation.getListOfProduct();
					}
					else if(k==3)
					{
						System.out.println("Enter the product id for which you want to see quantity in store");
						int prodtId=sc.nextInt();
						Product p=adminOperation.getProductById(prodtId);
						System.out.println("Product ID="+p.getPid()+", product name="+p.getP_name()+", quantity left in store="+p.getPa_quantity());
						
					}
					else if(k==4)
					{//display the entire registered user list
						userOperation.getUserList();
					}
					else if(k==5)
					{
						// check the particular user history for product purchase details.
						System.out.println("Check the particular user history for product purchase details.");
						System.out.println("Enter user id:");
						int uid=sc.nextInt();
						System.out.println("Enter product id");
						int pid=sc.nextInt();

						adminOperation.historyOfProduct(uid,pid);
					}
					System.out.println(" -------------------------------------");

					break;
				case 2:// user
					System.out.println("2 nd case");
					
					System.out.println("Enter\n1.Are You new user =>Register here\n2.Get all product\n3.Buy new product");
				 k=sc.nextInt();
					if(k==1)
					{
						
						userOperation.addNewUser();
						System.out.println("you are successifylly registered...");
						
						
					}
					else if(k==2)
					{
						adminOperation.getListOfProduct();

						
					}
					else if(k==3)
					{
						System.out.println("Enter your user Id:");
						int userId=sc.nextInt();
						//userOperation.buyNewpoduct();
						userOperation.cart(userId);
					}
					
					break;
				}
			}

		} catch (Exception e) {
		} finally {
			sc.close();
		}

	}

}
