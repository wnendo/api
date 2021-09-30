package com.teste.wendel.api.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.Contained;
import org.hibernate.tool.schema.internal.AbstractSchemaValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.teste.wendel.api.bean.Carro;
import com.teste.wendel.api.service.CarroService;

@Controller
public class CarroController {
	
	CarroService carroService = new CarroService();
	
    @RequestMapping(value = "/veiculos", produces = "application/json", method=RequestMethod.GET)
    public ModelAndView veiculos()	{
		
    	ModelAndView mav = new ModelAndView();
    	List<Carro> listOfCarros = carroService.listar();
    	Carro carro = new Carro();
    	int soma = 0;
    	int anos90 = 0;
    	int anos2000 = 0;
    	int anos2010 = 0;
    	int anos= 0;
    	for(int i = 0; i < listOfCarros.size(); i++) {
    		if(listOfCarros.get(i).isVendido() == false) {
    			soma += 1;
    		}
    	}
    	
    	for(int i = 0; i < listOfCarros.size(); i++) {
    		if(listOfCarros.get(i).getAno()>=1990 && listOfCarros.get(i).getAno()<2000) {
    			anos90+=1;
    		}
    		if(listOfCarros.get(i).getAno()>=2000 && listOfCarros.get(i).getAno()<2010) {
    			anos2000+=1;
    		}
    		if(listOfCarros.get(i).getAno()>=2010 && listOfCarros.get(i).getAno()<2020) {
    			anos2010+=1;
    		}if(listOfCarros.get(i).getAno()>=2020 ) {
    			anos+=1;
    		}
    	}
    	mav.setViewName("veiculos");
    	mav.addObject("soma", soma);
    	mav.addObject("anos90", anos90);
    	mav.addObject("anos2000", anos2000);
    	mav.addObject("anos2010", anos2010);
    	mav.addObject("anos", anos);
    	mav.addObject("registro", carro);
    	mav.addObject("lista", listOfCarros);
    	
    	return mav;
	}
    
    @RequestMapping(value = "/salvar", produces = "application/json", method=RequestMethod.POST)
	public ModelAndView salvar(Carro carro) throws ParseException{
    	ModelAndView mav = new ModelAndView();
    	carroService.salvar(carro);
    	mav.setViewName("salvar");
    	return mav;
	}
    
    @RequestMapping(value = "/alterado", produces = "application/json", method=RequestMethod.POST)
	public ModelAndView alteracao(int id) throws ParseException{
    	ModelAndView mav = new ModelAndView();
    	Carro carro = carroService.getCarro(id);
    	carroService.updateCarro(id, carro);
    	mav.addObject("registro", carro);
    	mav.setViewName("alterado");
    	return mav;
	}
    
    @RequestMapping(value = "/veiculos/alterar/{id}", produces = "application/json", method=RequestMethod.GET)
	public ModelAndView alterar(@PathVariable int id) throws ParseException{

    	Carro carro = carroService.getCarro(id);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("alterar");
    	mav.addObject("registro", carro);
    	return mav;
		
	}
    
    @RequestMapping(value = "/veiculos/{id}", produces = "application/json", method=RequestMethod.GET)
   	public ModelAndView excluir(@PathVariable("id") int id){ 
    	
       	carroService.deleteCarro(id);
		
       	return veiculos();
   	}

/*
    @RequestMapping(value = "/veiculos/{id}", produces = "application/json", method=RequestMethod.GET)
   	public ModelAndView excluir(@PathVariable("id") int id){ 
       	ModelAndView mav = new ModelAndView();
       	mav.setViewName("veiculos");
       	carroService.deleteCarro(id);
		
       	return mav;
   	}

    
    
    @RequestMapping(value = "/veiculos/find/{id}", produces = "application/json", method=RequestMethod.GET)
	public ModelAndView getCarroById(@PathVariable("id") int id){ 
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("find");
    	Carro carro = new Carro();
    	carro = carroService.getCarro(id);
    	mav.addObject("encontrar", carro);
    	return mav;
	}
    
    
 *  @RequestMapping(value = "/veiculos/find", produces = "application/json", method=RequestMethod.GET)
	public ModelAndView getCarroById(@PathVariable("id") int id){ 
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("find");
    	carroService.getCarro(id);
    	return mav;
	}
    

    
	
    @RequestMapping(value = "/veiculos/{id}", produces = "application/json", method=RequestMethod.GET)
	public void deleteCarro(@PathVariable("id") int id)
	{
		 carroService.deleteCarro(id);
		
	}*/
	
}
