package com.dove.grupo1.msn.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Utilities {

	//devuelve los un arraylist con los nombres aleatorios para los usuarios
	public static ArrayList<String> getUsersNamesArrayList() {
		ArrayList<String> usersNames = new ArrayList<>();
		
		//declaracion de objetos para realizar lectura de archivos
		File archivo = new File("src/main/resources/templates/assets/names.txt");
        BufferedReader br = null;
        try{
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            
            String nameInLine = br.readLine();
            //ciclo para llenar el arraylist
            while (nameInLine != null && !nameInLine.equals("")) {
				usersNames.add(nameInLine);
            	nameInLine = br.readLine();
			}
            br.close();
        }
        catch(FileNotFoundException fnfe){
            throw new RuntimeException("Error finding the names.txt");
        }catch (IOException ioe) {
        	throw new RuntimeException("Error reading the names.txt");
		}
		return usersNames;
	}
}
