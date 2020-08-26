package Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entidades_enum.Status;

public class Ordem {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private Status status;
	
	private Clientes cliente;
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Ordem(Date momento, Status status, Clientes cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void removerPedido(Pedido pedido) {
		pedidos.remove(pedido);
	}
	
	public double total() {

		double soma = 0.0;

		for (Pedido item : pedidos) {

			soma += item.subTotal();

		}

		return soma;
	}
	
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Momento do pedido: ");

		sb.append(sdf.format(momento) + "\n");

		sb.append("Status: ");

		sb.append(status + "\n");

		sb.append("Cliente: ");

		sb.append(cliente + "\n");

		sb.append("Itens pedidos:\n");

		for (Pedido item : pedidos) {

			sb.append(item + "\n");

		}

		sb.append("Preço total: R$");

		sb.append(String.format("%.2f", total()));

		return sb.toString();

	}
}