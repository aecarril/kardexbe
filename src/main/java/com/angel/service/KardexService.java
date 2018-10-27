package com.angel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.angel.bean.Producto;
import com.angel.bean.kardex;

public class KardexService {
	static HashMap<Integer, kardex> kardexIdMap = getKardexIdMap();

	public KardexService() {
		super();

		if (kardexIdMap == null) {
			kardexIdMap = new HashMap<Integer, kardex>();
			//
			kardex kardexA = new kardex(new Producto(1, "Camisetas", 10), 10);
			kardex kardexB = new kardex(new Producto(2, "Vasos", 15), 15);
			kardex kardexC = new kardex(new Producto(3, "Comics", 3), 3);
			kardex kardexD = new kardex(new Producto(4, "Jugetes", 5), 5);
			
			kardexIdMap.put(1, kardexA);
			kardexIdMap.put(2, kardexB);
			kardexIdMap.put(3, kardexC);
			kardexIdMap.put(4, kardexD);
		}
	}

	public List<kardex> getAllKardexlist()
	{
		List<kardex> kardexList = new ArrayList<kardex>(kardexIdMap.values());
		return kardexList;
	}

	public Producto crearProducto(Producto producto) {
		
		producto.setId(getMaxId() + 1);
		
		kardex kardex = new kardex(producto);
		//Inicia con saldo cero
		kardex.setSaldo(producto.getCantidad());
		
		kardexIdMap.put(producto.getId(), kardex);

		return producto;
	}

	public Producto venderProducto(Producto producto) throws Exception
	{
		//Disminuye el saldo
		List<kardex> kardexList = getAllKardexlist();
		
		for(kardex kardex: kardexList) {
			if (kardex.getProducto().getId() == producto.getId()){
				if (kardex.getSaldo() < producto.getCantidad()) {
					throw new Exception("Saldo insuficiente");
				}
				else {
					kardex.setSaldo(kardex.getSaldo() - producto.getCantidad());
					
					kardexIdMap.put(kardex.getProducto().getId(), kardex);
					break;
				}
			}
		}
		
		return producto;
	}
	
	public static int getMaxId() {
		int max = 0;
		
		for (int id : kardexIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}

	public static HashMap<Integer, kardex> getKardexIdMap() {
		return kardexIdMap;
	}
}
