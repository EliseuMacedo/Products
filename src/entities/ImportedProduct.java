package entities;

public class ImportedProduct extends Product{
	
	public Double custonsFee;
	
	public ImportedProduct() {
	}

	public ImportedProduct(String name, Double price, Double custonsFee) {
		super(name, price);
		this.custonsFee = custonsFee;
	}

	public Double getCustonsFee() {
		return custonsFee;
	}

	public void setCustonsFee(Double custonsFee) {
		this.custonsFee = custonsFee;
	}
	
	@Override
	public String priceTag() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" $ ");
		sb.append(String.format("%.2f", totalPrice()));
		sb.append("(Customs fee: $ ");
		sb.append(String.format("%.2f",custonsFee));
		sb.append(")");
		return sb.toString();
	}
	
	public Double totalPrice() {
		return price + custonsFee;
	}

}
