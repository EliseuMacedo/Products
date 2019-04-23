package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProducts;

public class Program {

	public static void main(String[] args) throws ParseException {
				
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> listProd = new ArrayList<>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char cui = sc.next().charAt(0);

			if (cui == 'c') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				listProd.add(new Product(name, price));

			} else if (cui == 'u') {

				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String manufactureDate = sc.next();
				listProd.add(new UsedProducts(name, price, sdf.parse(manufactureDate)));

			} else if (cui == 'i') {

				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				double custonsFee = sc.nextDouble();
				listProd.add(new ImportedProduct(name, price, custonsFee));
			}
		}
		System.out.println("\nPRICE TAGS:");
		for (Product prod : listProd) {
			System.out.println(prod.priceTag());
		}

	}

}
