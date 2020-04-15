package model.logic;

import java.awt.List;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.data_structures.ArbolRojoNegro;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	private ArbolRojoNegro<String,Comparendos> listaComparendos = new ArbolRojoNegro<>();

	public void loadComparendos (String comparendosFile)
	{
		JSONParser parser = new JSONParser();

		try {     
			Object obj = parser.parse(new FileReader(comparendosFile));

			JSONObject jsonObject =  (JSONObject) obj;
			JSONArray jsArray = (JSONArray) jsonObject.get("features");

			for(Object o: jsArray) {
				JSONObject comp = (JSONObject) o;	
				JSONObject properties =  (JSONObject) comp.get("properties");
				JSONObject geometry =  (JSONObject) comp.get("geometry");
				JSONArray coordinates = (JSONArray) geometry.get("coordinates");
				Comparendos comparendo = new Comparendos(String.valueOf(comp.get("type")), Integer.parseInt(String.valueOf(properties.get("OBJECTID"))), String.valueOf(properties.get("FECHA_HORA")), String.valueOf(properties.get("CLASE_VEHI")), String.valueOf(properties.get("TIPO_SERVI")), String.valueOf(properties.get("INFRACCION")), String.valueOf(properties.get("DES_INFRAC")), String.valueOf(properties.get("LOCALIDAD")), String.valueOf(geometry.get("type")), String.valueOf(coordinates));
				String objectId = Integer.toString(comparendo.getOBJECTID());			
				listaComparendos.put(objectId, comparendo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e){
			e.printStackTrace();
		}
	}

	public int numeroComparendos() 
	{
		return listaComparendos.size();
	}
	public String valorMinimoObjectId() 
	{
		return listaComparendos.min();	
	}
	public String valorMaximoObjectId() 
	{
		return listaComparendos.max();	
	}

	public String buscarComparendoId(String id) 
	{
		Comparendos comparendo = listaComparendos.get(id);
		
		
		return "OBJECTID: " + comparendo.getOBJECTID() + "\nFECHA_HORA: " + comparendo.getFECHA_HORA() + "\nTIPO_SERVI: " + comparendo.getTIPO_SERVI() + "\n CLASE_VEHI: " + comparendo.getCLASE_VEHI() + "\nINFRACCION: " + comparendo.getINFRACCION();
	}

	public void consultarComparendosRango(String idMenor, String idMayor) 
	{
		Iterator<String> iter = listaComparendos.keysInRange(idMenor, idMayor);
		System.out.println(iter.hasNext());
		while(iter.hasNext()) 
		{	
			String llave = iter.next();
			Comparendos comparendo = listaComparendos.get(llave);
			System.out.println("OBJECTID: " + comparendo.getOBJECTID() + "\nFECHA_HORA: " + comparendo.getFECHA_HORA() + "\nTIPO_SERVI: " + comparendo.getTIPO_SERVI() + "\n CLASE_VEHI: " + comparendo.getCLASE_VEHI() + "\nINFRACCION: " + comparendo.getINFRACCION());
		}
	}


}