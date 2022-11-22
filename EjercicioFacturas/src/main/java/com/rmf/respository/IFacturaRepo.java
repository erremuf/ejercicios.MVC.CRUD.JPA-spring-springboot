package com.rmf.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmf.entity.Factura;

@Repository
public interface IFacturaRepo extends JpaRepository<Factura, Integer>{


}
