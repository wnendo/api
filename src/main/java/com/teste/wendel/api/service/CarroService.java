package com.teste.wendel.api.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONObject;

import com.teste.wendel.api.bean.Carro;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class CarroService {

	static HashMap<Integer,Carro> carroIdMap=getCarroIdMap();


	public CarroService() {
		super();

		if(carroIdMap==null)
		{
			LocalDate localDate = LocalDate.now();
			carroIdMap=new HashMap<Integer,Carro>();
			Carro corola = new Carro(1, "Corolla", "Toyota", 2021, "Carro novo", true, localDate, null);
			Carro civic = new Carro(2, "Civic", "Honda", 2021, "Carro novo", true, localDate, null);
			Carro uno = new Carro(3, "Uno", "Fiat",2021, "Carro novo", false, localDate, null);
			Carro gol = new Carro(4, "Gol","Volkswagen", 2021, "Carro novo", false, localDate, null);

			carroIdMap.put(1,corola);
			carroIdMap.put(2,civic);
			carroIdMap.put(3,uno);
			carroIdMap.put(4,gol);
		}
	}

	public List<Carro> listar()
	{
		List<Carro> carros = new ArrayList<Carro>(carroIdMap.values());
		return carros;
	}
	

	public Carro getCarro(int id)
	{
		Carro carro = carroIdMap.get(id);
		return carro;
	}
	
	public LocalDate getPegaDataAtual() throws ParseException { 
		return java.time.LocalDate.now();
	}
	
	public Carro salvar(Carro carro) throws ParseException
	{
		carro.setId(carroIdMap.size()+1);
		carro.setCriado(getPegaDataAtual());
		carroIdMap.put(carro.getId(), carro);
		return carro;
	}
	
	public Carro updateCarro(int id, Carro carro) throws ParseException
	{
		if(carro.getId()<=0) {
			return null;
		}
		carro.setAlterado(getPegaDataAtual());
		carroIdMap.put(carro.getId(), carro);
		return carro;

	}
	public void deleteCarro(int id)
	{
		carroIdMap.remove(id);
	}

	public static HashMap<Integer, Carro> getCarroIdMap() {
		return carroIdMap;
	}


}
