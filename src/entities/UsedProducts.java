package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProducts extends Product {
	
	private Date manufactureDate;
	
	public UsedProducts() {
	}

	public UsedProducts(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" (used) $ ");
		sb.append(String.format("%.2f", price));
		sb.append(" (Manufacture date: ");
		sb.append(sdf.format(manufactureDate));
		sb.append(")");
		
		return sb.toString();
	}
	

}
