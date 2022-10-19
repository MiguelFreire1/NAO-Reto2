import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadJSON {

	public static void main(String[] args) {
		
		leer();

	}

	private static void leer() {
		JSONParser parser = new JSONParser();
		
		try(Reader reader = new FileReader("Ejemplo1.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
			System.out.println("El archivo contiene el siguiente JSON:");
			System.out.println(jsonObject);
		
			JSONObject resultados = (JSONObject) jsonObject.get("search-results"); 
			System.out.println("Resultados de la busqueda: ");
			 
			String totales = (String) resultados.get("opensearch:totalResults");
			System.out.println("Resultados Totales:"+ totales);
			
			String index = (String) resultados.get("opensearch:startIndex");
			System.out.println("Index:"+ index);
			
			String itemspagina = (String) resultados.get("opensearch:itemsPerPage");
			System.out.println("Items por pagina:"+ itemspagina);
			
			JSONObject query = (JSONObject) resultados.get("opensearch:Query");
			System.out.println("Query:");
			
			String rol = (String) query.get("@role");
			System.out.println("Rol:"+ rol);
			
			String TerminoBusqueda = (String) query.get("@searchTerms");
			System.out.println("Termino buscado:"+ TerminoBusqueda);
			
			String PaginaInicio = (String) query.get("@startPage");
			System.out.println("Pagina de inicio:"+ PaginaInicio);
			
			JSONArray Links = (JSONArray) resultados.get("link");
			System.out.println("Links:");
			for(Object Link: Links) {
				mostrarInformacionLinks ((JSONObject) Link);
			}
				
			JSONArray Entrys = (JSONArray) resultados.get("entry");
			System.out.println("Entrys:");
			for(Object Entry: Entrys) {
				mostrarInformacionEntrys ((JSONObject) Entry);
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

	private static void mostrarInformacionLinks(JSONObject link) {
		String fa = (String) link.get("@_fa");
		System.out.println("fa:"+ fa);
		
		String ref = (String) link.get("@ref");
		System.out.println("Ref:"+ ref);
		
		String href = (String) link.get("@href");
		System.out.println("href:"+ href);
		
		String type = (String) link.get("@type");
		System.out.println("Type:"+ type);
		
		
	}
	
	private static void mostrarInformacionEntrys(JSONObject entry) {
		String fa2 = (String) entry.get("@_fa");
		System.out.println("fa:"+ fa2);
		
		JSONArray Links2 = (JSONArray) entry.get("link");
		System.out.println("Links de los entrys:");
		for(Object Link2: Links2) {
			mostrarInformacionLinks2 ((JSONObject) Link2);
		}
		
		String Url = (String) entry.get("prism:url");
		System.out.println("Url:"+ Url);
		
		String Identificador = (String) entry.get("dc:identifier");
		System.out.println("Identificador:"+ Identificador);
		
		String Titulo = (String) entry.get("dc:title");
		System.out.println("Titulo:"+ Titulo);
		
		String Creador = (String) entry.get("dc:creator");
		System.out.println("Creador:"+ Creador);
		
		String Nombre = (String) entry.get("prism:publicationName");
		System.out.println("Nombre:"+ Nombre);
		
		String issn = (String) entry.get("prism:issn");
		System.out.println("issn:"+ issn);
		
		String elssn = (String) entry.get("prism:elssn");
		System.out.println("elssn:"+ elssn);
		
		String Volumen = (String) entry.get("prism:volume");
		System.out.println("Volumen:"+ Volumen);
		
		String Rangodepagina = (String) entry.get("prism:pageRange");
		System.out.println("Rango de pagina:"+ Rangodepagina);
		
		String Fecha = (String) entry.get("prism:coverDate");
		System.out.println("Fecha:"+ Fecha);
		
		String Mesano = (String) entry.get("prism:coverDisplayDate");
		System.out.println("Mes y año:"+ Mesano);
		
		String doi = (String) entry.get("prism:doi");
		System.out.println("doi:"+ doi);
		
		String Descripcion = (String) entry.get("dc:description");
		System.out.println("Descripcion:"+ Descripcion);
		
		String Cuenta = (String) entry.get("citedby-count");
		System.out.println("Cuenta:"+ Cuenta);
		
		JSONArray Affiliations = (JSONArray) entry.get("affiliation");
		System.out.println("Affiliations de los entrys:");
		for(Object Affiliation: Affiliations) {
			mostrarInformacionAffiliation ((JSONObject) Affiliation);
		}
		
		String Tipo = (String) entry.get("prism:aggregationType");
		System.out.println("Tipo:"+ Tipo);
		
		String Subtipo = (String) entry.get("subtype");
		System.out.println("Subtipo:"+ Subtipo);
		
		String DescripcionSubtipo = (String) entry.get("subtypeDescription");
		System.out.println("Descripcion del Subtipo:"+ DescripcionSubtipo);
		
		JSONArray Autores = (JSONArray) entry.get("author");
		System.out.println("Autores de los entrys:");
		for(Object Autor: Autores) {
			mostrarInformacionAutores ((JSONObject) Autor);
		}
		
		String keywords = (String) entry.get("authkeywords");
		System.out.println("Keywords:"+ keywords);
		
	}

	private static void mostrarInformacionLinks2(JSONObject link2) {
		String fa3 = (String) link2.get("@_fa");
		System.out.println("fa:"+ fa3);
		
		String ref2 = (String) link2.get("@ref");
		System.out.println("Ref:"+ ref2);
		
		String href2 = (String) link2.get("@href");
		System.out.println("href:"+ href2);
		
	}

	private static void mostrarInformacionAffiliation(JSONObject affiliation) {
		String fa4 = (String) affiliation.get("@_fa");
		System.out.println("fa:"+ fa4);
		
		String affiliationUrl = (String) affiliation.get("affiliation-url");
		System.out.println("Url:"+ affiliationUrl);
		
		String ID = (String) affiliation.get("afid");
		System.out.println("ID:"+ ID);
		
		String affiliationName = (String) affiliation.get("affilname");
		System.out.println("Affiliation Name:"+ affiliationName);
		
		String City = (String) affiliation.get("affiliation-city");
		System.out.println("Ciudad:"+ City);
		
		String Pais = (String) affiliation.get("affiliation-country");
		System.out.println("Pais:"+ Pais);
		
		JSONArray NameVariants = (JSONArray) affiliation.get("name-variant");
		System.out.println("Affiliations de los entrys:");
		for(Object NameVariant: NameVariants) {
			mostrarInformacionNameVariant ((JSONObject) NameVariant);
		}
		
	}

	private static void mostrarInformacionNameVariant(JSONObject nameVariant) {
		String fa5 = (String) nameVariant.get("@_fa");
		System.out.println("fa:"+ fa5);
		
		String Universidad = (String) nameVariant.get("$");
		System.out.println("Universidad:"+ Universidad);
		
	}
	

	private static void mostrarInformacionAutores(JSONObject autor) {
		String fa6 = (String) autor.get("@_fa");
		System.out.println("fa:"+ fa6);
		
		String UrlAutor = (String) autor.get("author-url");
		System.out.println("Url Autor:"+ UrlAutor);
		
		String IDAutor = (String) autor.get("authid");
		System.out.println("ID:"+ IDAutor);
		
		String NombreAutor = (String) autor.get("authname");
		System.out.println("Nombre:"+ NombreAutor);
		
		String ApellidoAutor = (String) autor.get("surname");
		System.out.println("Apellido:"+ ApellidoAutor);
		
		String Inicial = (String) autor.get("initials");
		System.out.println("Inicial:"+ Inicial);
		
	}
	
		
}
