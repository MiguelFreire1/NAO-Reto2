import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParser;            

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class PruebasCSV {
	

	public static void main(String[] args) throws IOException, CsvException  {
		
		List<String[]> csvData = createCsvDataSimple();
        try (CSVWriter writer = new CSVWriter(new FileWriter("pruebas.csv"))) {
            writer.writeAll(csvData);
        }
        
        try {

            FileReader filereader = new FileReader("pruebas.csv");
            
            CSVReader csvReader = new CSVReader(filereader);
                          
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "   ");
                }
                System.out.println();
            }
        }     
         catch (IOException e) {
            e.printStackTrace();
        }
        
        

    }


    private static List<String[]> createCsvDataSimple() {
        String[] header = {"Nombre","Codigo","Estatura","Apellido","Telefono"};
        String[] persona1 = {"Jhon","121","180","Smith","111111111"};
        String[] persona2 = {"Lisa","122","160","Smith","222222222"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
		list.add(persona1);
		list.add(persona2);
    
        return list;
    }
	
		
		
		

}