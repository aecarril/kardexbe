package com.angel.bean;


public class kardex {
	String concepto;
	int unidadesEntrada;
	int unidadesSalida;
	int saldo;
	double precioCompra;
	Producto producto;
	
	public kardex(Producto producto) {
		
		this.producto = producto;		
	}
	
	public kardex(Producto producto, int saldoInicial) {
	
		this(producto);
		this.saldo = saldoInicial;
	}
	
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public int getUnidadesEntrada() {
		return unidadesEntrada;
	}
	public void setUnidadesEntrada(int unidadesEntrada) {
		this.unidadesEntrada = unidadesEntrada;
	}
	public int getUnidadesSalida() {
		return unidadesSalida;
	}
	public void setUnidadesSalida(int unidadesSalida) {
		this.unidadesSalida = unidadesSalida;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
