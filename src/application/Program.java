package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formato desejado de data
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter cliente data:");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.next();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next()); //formatar pra data dd/MM/yyyy
		
		Client client = new Client(name, email, birthDate); //criar um novo cliente usando nome, email e data
		
		System.out.println("Enter order data:");
		System.out.print("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.next()); //instanciar o valor ao status
		
		Order order = new Order(new Date(), status, client); //adicionar um status ao pedido
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) { //criar um laço pra pegar os dados do order
			System.out.println("Enter #"+ i +" item data:");
			System.out.print("Product name:");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price:");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(nameProduct, productPrice); //criar um novo product com nome e preço
			
			System.out.println("Quantity:");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product); //criando um novo orderItem usando quantidade, preço e o produto criado 
			
			order.addItem(orderItem); //adicionando o produto na lista
		}
	
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order); //imprimir o produto
		sc.close();
	}
}
