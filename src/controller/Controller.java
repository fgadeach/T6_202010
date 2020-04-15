package controller;

import java.io.FileReader;



import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import model.data_structures.ArbolRojoNegro;

import model.logic.Comparendos;
import model.logic.Modelo;
import view.View;

public class Controller {

	/*
	 * 
	 */
	private ArbolRojoNegro<String,Comparendos> listaComparendos;

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private Comparendos comparendo;

	public static final String ruta="./data/comparendos.geojson";
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller()
	{
		listaComparendos= new ArbolRojoNegro<String,Comparendos>();
		view = new View();
		modelo = new Modelo();
	}

	@SuppressWarnings("null")
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		Integer n = null;
		Integer i = 1;
		Object datoS = null;
		String respuesta = "";
		String tipo = null;


		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 0:
				modelo = new Modelo(); 
				modelo.loadComparendos(ruta);
				System.out.println("--------- \nDar N comparendos a buscar: ");
				n = lector.nextInt();
				System.out.println("Numero actual de elementos " + modelo.numeroComparendos() + "\n---------");	
				break;

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;

			}
		}
	}
}	