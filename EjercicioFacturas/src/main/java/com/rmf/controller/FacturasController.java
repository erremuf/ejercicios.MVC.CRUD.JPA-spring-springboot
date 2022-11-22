package com.rmf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.rmf.entity.Factura;
import com.rmf.services.IFacturaService;

@Controller
@SessionAttributes("factura")
public class FacturasController {
	
	@Autowired
	IFacturaService iFacturaServicio;	

	
	
/////////////////////////// INICIO
	
	@GetMapping("/")
	public String inicio(Model model) {
	
		model.addAttribute("titulo", "¡Bienvenido a tu app de gestión de facturas!");
		model.addAttribute("titular", "¿Qué desea realizar?");
		
		return "inicio";		
	}
	
	
	
/////////////////////////// REGISTRO NUEVA FACTURA
	
	@GetMapping("/nuevaFactura") 
	public String form(Model model) {
		model.addAttribute("titulo", "Usted está agregando una nueva factura");
		model.addAttribute("titular", "");
		model.addAttribute("factura",new Factura());
		
		return "registrar";
	}		
	@PostMapping("/guardarFactura")
	public String resultado(@Valid Factura factura, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Usted está agregando una nueva factura");
			model.addAttribute("titular", "* Debe rellenar todo los campos");
			
			return "registrar";
		}
		
		model.addAttribute("titulo", "Usted está agregando una nueva factura");
		model.addAttribute("titular", "Factura creada y agregada correctamente a la base de datos");
		iFacturaServicio.saveFactura(factura);
		
		return "registrar";
	}
	
	
	
/////////////////////////// VER Y EDITAR Y ELIMINAR
	
	@GetMapping("/total-facturas")
	public String verTodas(Model model) {
		model.addAttribute("titulo", "Estas son las facturas agregadas en la BBDD");
		model.addAttribute("lista", iFacturaServicio.findAllFacturas());
		
		return "facturas";
	}

	@GetMapping("/eliminar/{idFactura}")
	public String eliminar(@PathVariable(name="idFactura") Integer idFactura, Model model) {
		iFacturaServicio.deleteFactura(iFacturaServicio.findByIdFactura(idFactura));
		
		return "redirect:/total-facturas";
	}
	
	@GetMapping("/editar/{idFactura}")
	public String editar(@PathVariable(name="idFactura") Integer idFactura, Model model) {
		model.addAttribute("titulo","Editar valor de la factura seleccionada");
		model.addAttribute("factura", iFacturaServicio.findByIdFactura(idFactura)) ;
		
		return "editar";
	}
	@PostMapping("/editar")
	public String editar(@Valid Factura factura, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Editar valor de la factura seleccionada");
			model.addAttribute("titular", "* Debe rellenar todo los campos");
			
			return "editar";
		}
		
		model.addAttribute("titulo","Editar valor de la factura seleccionada");
		model.addAttribute("titular", "Factura modificada correctamente");
		iFacturaServicio.saveFactura(factura);
		status.setComplete();
		
		return "redirect:/total-facturas";
	}
	
	
	
}
