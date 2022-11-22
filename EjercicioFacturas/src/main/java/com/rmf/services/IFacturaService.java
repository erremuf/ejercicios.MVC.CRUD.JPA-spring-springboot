package com.rmf.services;

import java.util.List;

import com.rmf.entity.Factura;

public interface IFacturaService  {
	
	public List<Factura> findAllFacturas();
	public void saveFactura(Factura factura);
	public void deleteFactura(Factura factura);
	public Factura findByIdFactura(Integer idFactura);
	


}
