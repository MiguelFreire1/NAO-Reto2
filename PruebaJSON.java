
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;


public class PruebaJSON {
	

	public static void main(String[] args) {
		
		escribir();
		guardar();
		
		
	}

	private static void guardar() {
		JSONParser jsonParser = new JSONParser();
		
		try(FileReader reader= new FileReader("personas.json")){
			Object obj= jsonParser.parse(reader);
			
			JSONArray personasList = (JSONArray) obj;
			System.out.println("El archivo contiene el siguiente JSON:");
			System.out.println(personasList);
			
			for(Object persona: personasList) {
				mostrarInformacionPersona ((JSONObject) persona);
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarInformacionPersona(JSONObject jsonObject) {
		JSONObject persona = (JSONObject) jsonObject.get("persona");
		System.out.println("Personas dentro del JSON");
		
		String nombre = (String) persona.get("Nombre");
		System.out.println("Nombre:"+ nombre);
		
		String apellido = (String) persona.get("Apellido");
		System.out.println("Apellido:"+ apellido);
		
		Long codigo = (Long) persona.get("codigo");
		System.out.println("Codigo:"+ codigo);
		
		Double estatura = (Double) persona.get("estatura");
		System.out.println("Estatura:"+ estatura);
		
		JSONArray telefonosList = (JSONArray) persona.get("telefonos");
		for(Object tel:telefonosList) {
			JSONObject t= (JSONObject) tel;
			System.out.println("Telefono:"+ t.get("telefono"));
		}
		
		
		
		
	}

	private static void escribir() {
		
		JSONObject telefono1= new JSONObject();
		telefono1.put("telefono", "11111111");
		
		JSONObject telefono2= new JSONObject();
		telefono2.put("telefono", "22222222");
		
		JSONArray telefonoList= new JSONArray();
		telefonoList.add(telefono1);
		telefonoList.add(telefono2);
		
		JSONObject persona1= new JSONObject();
		persona1.put("Nombre","Jhon");
		persona1.put("Apellido","Smith");
		persona1.put("codigo",1);
		persona1.put("estatura",1.6);
		persona1.put("telefonos",telefonoList);
		
		
		JSONObject telefono3= new JSONObject();
		telefono3.put("telefono", "33333333");
		
		JSONObject telefono4= new JSONObject();
		telefono4.put("telefono", "44444444");
		
		JSONArray telefonoList2= new JSONArray();
		telefonoList2.add(telefono3);
		telefonoList2.add(telefono4);
		
		JSONObject persona2= new JSONObject();
		persona2.put("Nombre","Mary");
		persona2.put("Apellido","Smith");
		persona2.put("codigo",2);
		persona2.put("estatura",1.5);
		persona2.put("telefonos",telefonoList2);
		
		JSONObject datosPersona1 = new JSONObject();
		datosPersona1.put("persona",persona1);
		JSONObject datosPersona2 = new JSONObject();
		datosPersona2.put("persona",persona2);
		
		JSONArray listapersonas= new JSONArray();
		listapersonas.add(datosPersona1);
		listapersonas.add(datosPersona2);
		
		try(FileWriter file = new FileWriter ("personas.json")){
			file.write (listapersonas.toJSONString());
			file.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}	
}
