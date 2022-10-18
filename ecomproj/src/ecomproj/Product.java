package ecomproj;

public class Product {
	private int pid;
	private String p_name;
	private String p_descrition;
	private int p_price;
	private int pa_quantity;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String p_name, String p_descrition, int p_price, int pa_quantity) {
		super();
		this.pid = pid;
		this.p_name = p_name;
		this.p_descrition = p_descrition;
		this.p_price = p_price;
		this.pa_quantity = pa_quantity;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_descrition() {
		return p_descrition;
	}
	public void setP_descrition(String p_descrition) {
		this.p_descrition = p_descrition;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getPa_quantity() {
		return pa_quantity;
	}
	public void setPa_quantity(int pa_quantity) {
		this.pa_quantity = pa_quantity;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", p_name=" + p_name + ", p_descrition=" + p_descrition + ", p_price=" + p_price
				+ ", pa_quantity=" + pa_quantity + "]";
	}
}
