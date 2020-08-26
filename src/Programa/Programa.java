package Programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Clientes;
import Entidades.Ordem;
import Entidades.Pedido;
import Entidades.Produto;
import Entidades_enum.Status;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
			
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento: ");
		Date dataNascimento = sdf.parse(sc.next());
		
		Clientes cliente = new Clientes(nome, email, dataNascimento);
		
		System.out.println("Insira os dados do pedido:");
		System.out.print("Status: ");
		Status status = Status.valueOf(sc.next());
		
		Ordem ordem = new Ordem(new Date(), status, cliente);
		
		System.out.print("Quantos itens serão pedidos? ");
		int n = sc.nextInt();
		
		for(int x=1; x<=n; x++)
		{
			System.out.println("Pedido #" + x + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço: ");
			double precoProduto = sc.nextDouble();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			
			Pedido pedido = new Pedido (quantidade, precoProduto, produto);
			ordem.addPedido(pedido);
		}
		System.out.println();

		System.out.println("SUMÁRIO:");

		System.out.println(ordem);

		sc.close();

	}

}