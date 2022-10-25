import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.exceptions.CsvException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;



public class WriteCSV {
	

	public static void main(String[] args) throws IOException, ParseException  {
		
		WriteToCSV();
	}
	
	private static void WriteToCSV() throws IOException, ParseException {
		
		try {
			CSVWriter csvWriter;
			try {
				
				csvWriter = new CSVWriter(new FileWriter("Ciclo2.csv",true));
				
				String[] header = new String[]{"URL","SOPUES_ID","TITULO","CREADOR","NOMBRE","ISSN","ELSSN","VOLUMEN",
						"RANGODEPAGINA","FECHA","MESYAÑO","DOI","DESCRIPCION","CUENTA","TIPO","SUBTIPO","DESCRIPCIONSUBTIPO"};
				csvWriter.writeNext(header);
				csvWriter.close();
			} catch (IOException e) {
	            e.printStackTrace();
	        } 
		
		JSONParser parser = new JSONParser ();
		try (FileReader reader = new FileReader("Ejemplo1.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject resultados = (JSONObject) jsonObject.get("search-results");
            JSONArray Entrys = (JSONArray) resultados.get("entry"); { 
            for(Object entry: Entrys) {
				mostrarInformacionEntrys ((JSONObject) entry);}
			}   
		}} catch (FileNotFoundException e) {
			e.printStackTrace();	
			} catch(IOException e) {
				e.printStackTrace();		
			} catch(ParseException e) {
				e.printStackTrace();
			} 
	}

	private static void mostrarInformacionEntrys(JSONObject entry) {
		String Url = (String) entry.get("prism:url");
		String Identificador = (String) entry.get("dc:identifier");
		String Titulo = (String) entry.get("dc:title");
		String Creador = (String) entry.get("dc:creator");
		String Nombre = (String) entry.get("prism:publicationName");
		String issn = (String) entry.get("prism:issn");
		String elssn = (String) entry.get("prism:elssn");
		String Volumen = (String) entry.get("prism:volume");
		String Rangodepagina = (String) entry.get("prism:pageRange");
		String Fecha = (String) entry.get("prism:coverDate");
		String Mesano = (String) entry.get("prism:coverDisplayDate");
		String doi = (String) entry.get("prism:doi");
		String Descripcion = (String) entry.get("dc:description");
		String Cuenta = (String) entry.get("citedby-count");
		String Tipo = (String) entry.get("prism:aggregationType");
		String Subtipo = (String) entry.get("subtype");
		String DescripcionSubtipo = (String) entry.get("subtypeDescription");
		
		CSVWriter  DataWriter;
		try {
			DataWriter = new CSVWriter(new FileWriter("Ciclo2.csv",true));
			
			String[] data ={ Url,Identificador,Titulo,Creador,Nombre,issn, elssn,Volumen,Rangodepagina,Fecha,Mesano,doi,Descripcion,
					Cuenta,Tipo,Subtipo,DescripcionSubtipo};
			DataWriter.writeNext(data);  
			DataWriter.close();
            
        }catch (IOException e) {
            e.printStackTrace();
        } 
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
	}	
}			

	