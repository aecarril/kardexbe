package com.angel.controller;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.angel.bean.Producto;
import com.angel.service.KardexService;


@Path("/kardexlist")
public class KardexController {
	KardexService kardexService = new KardexService();
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public Producto crearProducto(Producto producto)
	{
		return kardexService.crearProducto(producto);
	}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Producto venderProducto(Producto producto) throws Exception
	{
		return kardexService.venderProducto(producto);
		
	}
}
