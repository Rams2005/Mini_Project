package ecomproj;

public class CartClass {
	private int cid;
	private int pid;
	private int uid;
	private int pb_quantity;
	private int totalAmount;
	private int PaymentStatus;
	public  CartClass() {
	}
	public CartClass(int cid, int pid, int uid, int pb_quantity, int totalAmount, int paymentStatus) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.uid = uid;
		this.pb_quantity = pb_quantity;
		this.totalAmount = totalAmount;
		PaymentStatus = paymentStatus;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPb_quantity() {
		return pb_quantity;
	}
	public void setPb_quantity(int pb_quantity) {
		this.pb_quantity = pb_quantity;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getPaymentStatus() {
		return PaymentStatus;
	}
	public void setPaymentStatus(int paymentStatus) {
		PaymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "CartClass [cid=" + cid + ", pid=" + pid + ", uid=" + uid + ", pb_quantity=" + pb_quantity
				+ ", totalAmount=" + totalAmount + ", PaymentStatus=" + PaymentStatus + "]";
	}
	
	
}
