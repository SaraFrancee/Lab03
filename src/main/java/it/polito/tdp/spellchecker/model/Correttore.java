package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Correttore {
	
	List<String> dizInglese;
	List<String> dizItaliano;
	
	public Correttore() {
		
		try {
			FileReader fr = new FileReader("English.txt");
			BufferedReader br = new BufferedReader(fr);
			String riga;
			this.dizInglese = new ArrayList<String>();
			while ((riga = br.readLine()) != null) {
				try {
					dizInglese.add(riga.toLowerCase());
				} catch(Exception e) {
					System.out.println("Errore informazioni nella riga");
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
		try {
			FileReader fr = new FileReader("Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String riga;
			this.dizItaliano = new ArrayList<String>();
			while ((riga = br.readLine()) != null) {
				try {
					dizItaliano.add(riga.toLowerCase());
				} catch(Exception e) {
					System.out.println("Errore informazioni nella riga");
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
	}
	
	public List<String> correggi(String lingua, String testo){
		List<String> errori = new ArrayList<String>();
		List<String> diz;
		String testoDepurato = testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String array[] = testoDepurato.split(" ");
		if (lingua.equals("English"))
			diz = this.dizInglese;
		else 
			diz = this.dizItaliano;
		for (String parola : array) {
			if (diz.contains(parola.toLowerCase())) {}	
			else
				errori.add(parola);
		}
	    return errori;
	}
	
	

}
