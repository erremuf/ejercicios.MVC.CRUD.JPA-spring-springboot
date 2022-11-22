package com.rmf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmf.entity.Factura;
import com.rmf.respository.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IFacturaService{
	
	@Autowired
	IFacturaRepo facturaRepo;


	@Override
	public List<Factura> findAllFacturas() {

		return facturaRepo.findAll();
	}

	@Override
	public void saveFactura(Factura factura) {
		facturaRepo.save(factura);	
	}

	@Override
	public void deleteFactura(Factura factura) {
		facturaRepo.delete(factura);
		
	}

	@Override
	public Factura findByIdFactura(Integer idFactura) {
		
		return facturaRepo.findById(idFactura).get();
	}


}
