package co.edu.uptc.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 *@author Sebastian Matallana
 *@author Felipe Penagos
 *@author Alejandra Leal

 */
public class Management {
    /*
        + Cadena a usar inmutable
        */
    private static String CHAR_STRING;

    /*
     + @param constructor de la clase
     */
    public Management(String CHAR_STRING) {
        this.CHAR_STRING = CHAR_STRING;
    }

    /**
     + Metodo que consiste en convertir una frase es un nombre propio.
     + @return cadena como un nombre propio
     */
    public String own_Name(){
        String phrase = "";
        char first_letter = ' ';
        char characters = ' ';
        int aux = 0;

        for (int i = 0; i < CHAR_STRING.length(); i++) {
            first_letter = CHAR_STRING.charAt(0);
            characters = CHAR_STRING.charAt(i);
            if (first_letter == ' '){
                phrase = "No se puede iniciar con un espacio el nombre propio";
            }else if(!Character.isLetter(first_letter)){
                phrase = "No se puede iniciar con un caracter \n"
                        + "diferente al alfabeto" + first_letter;
            }
            if (i == 0){
                characters = Character.toUpperCase(characters);
            }
            if (i >= 1){
                characters = Character.toLowerCase(characters);
            }
            if (characters == ' '){
                aux = (i+1);
            }
            if (aux == i){
                characters = Character.toUpperCase(characters);
            }

            phrase += characters;
        }
        return phrase;
    }
    /**
     * Metodo que busca una palabra en una cadena de caracteres y cuenta la catidad de veces que aparece
     * @param search_String
     * @param text_String
     * @return Entero 
     */
    
    public int Search_String_Characters(String search_String,String text_String) {
    	
    	
    	
    	String phrase = "";
    	  
		Pattern regex = Pattern.compile("\\b" + Pattern.quote(search_String) + "\\b", Pattern.CASE_INSENSITIVE);
		Matcher match = regex.matcher(text_String);
		
		int accountant=0; 

		
		while(match.find()==true) {  
		   accountant++;
		} 
		 if(accountant>=1){
			phrase ="Se encontró '" + search_String
		                     + "' y esta aparece " + accountant +" veces";
	
		}
			
		  
		if(accountant==0){
		 
		   phrase= "'" + search_String + "' NO está dentro del texto ";
		  
	
	}
		return accountant ;
	
	}
    /**
     * Metodo que cuenta la cantidad de vocales que hay en un texto
     * @param text
     * @return contador
     */
    
    public int Count_Vowels(String text) {
    	
    	String phrase = "";
    	int accountant = 0;
    	

		for(int x=0;x<text.length();x++) {
			 if  ((text.charAt(x)=='a') || (text.charAt(x)=='e') || (text.charAt(x)=='i') || (text.charAt(x)=='o') || (text.charAt(x)=='u') || (text.charAt(x)=='A') || (text.charAt(x)=='E') || (text.charAt(x)=='I') || (text.charAt(x)=='O') || (text.charAt(x)=='U')) {
				 accountant++;
			  
			}
		

	}
		phrase=("El texto contiene '" + accountant + "' vocales");

		return accountant;

    	    }
    
    
    /**
     + Metodo para agregar un caracter segun la cantidad ed veces dada.
     + Ya sea por izquierda o por derecha
     + @param character
     + @param quantify
     + @param address
     + @return auxCharString
     */

    public String fill_Characters(char character, int quantify, String address){
        String modified_String = "";
        String auxCharString = CHAR_STRING;
        for (int i = 0; i < quantify; i++) {
            if (address.equals("Derecha")){
                modified_String = auxCharString + character;
            }else{
                modified_String = character + auxCharString;
            }
            auxCharString = modified_String;
        }
        return auxCharString;
    }
    
    

	/**Metodo usado para borrar un caracter de una cadena
	 * @param cadena
	 * @param caracter
	 * @return
	 */
		public String borrar(String sentence, String caracter) {
		
			 String aRemplazar=sentence;
				String remplazado=aRemplazar.replace(caracter, "");
				return remplazado;
			
		}
			
			
		/**Metodo usado para comparar dos cadenas y saber cuales caracteres se repiten
		 * @param sentence
		 * @param cadena
		 * @return
		 */
		public String interseccion(String sentence, String cadena) {
			String 	interseccion="";
			for(int i=0;i<sentence.length();i++){ 		     
				for(int j=0;j<cadena.length();j++){           
					if(sentence.charAt(i)==cadena.charAt(j)){  
						interseccion += sentence.charAt(i)+" ";  
	               break;
	           }  
	       }  
	}  
			return interseccion;
		}
		/**Metodo usado para quitar los caracteres que se repiten 
		 * @param sentence
		 * @return
		 */
		public String borrarDuplicados(String sentence) {
			StringBuilder cadena=new StringBuilder();
        for(int i=0;i<sentence.length();i++){
            if(sentence.indexOf(sentence.charAt(i))==i){
                cadena.append(sentence.charAt(i));
            }

        }
        String result=cadena.toString();
        return result;
    }
		
	/**
     * Metodo que cuenta todas las palabras que se encuentran en una frase
     * @param text
     * @return Contador
     */
    
    public String Count_Words(String text){
    	
    	String phrase="";
    	 StringTokenizer st = new StringTokenizer(text);
    	 return phrase="Número de palabras: " + st.countTokens();
  }
	public static int Count(String s) {
	    int accountant = 1, pos;
	    s = s.trim();                               
	    if (s.isEmpty()) { 
	    	accountant = 0;
	    } else {
	            pos = s.indexOf(" "); 
	            while (pos != -1) {                   
	            	accountant++;    
	            }
	                   pos = s.indexOf(" ", pos + 1); 
	    }
	    return accountant;
	}
		


    /**
     * metodo que permite confirmar correos electrÃ³nicos
     * @param sentence,direction
     * @return string
     */

    public String validateEmailConfirmation(String sentence) {
        String result = "";
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


        Matcher mather = pattern.matcher(sentence);

        if (mather.find() == true) {
            result = "El email ingresado es vÃ¡lido.";
        } else {
            result = "El email ingresado es invÃ¡lido.";
        }return result;
    }
    /**
     * Metodo que cuenta los minutos que faltan para que sea año nuevo teniendo en cuenta que fuera hoy 31 de diciembre de 2021 
     * @param hour
     * @return int
     */
    
    
    public String newYear(String hour){
    	String phrase="";
        int hours, minutes, timeLeft = 0;
            if(Pattern.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", hour)) {
                hours = Integer.parseInt(hour.substring(0, 2));
                minutes = Integer.parseInt(hour.substring(3, 5));
                timeLeft = ((23 - hours) * 60) + (60 - minutes);
               phrase=("Para año nuevo faltan "+timeLeft+" minutos");
            }else{
                phrase=("La cadena no está formada en formato 00:00");
            }

        return phrase;

    }
    
}
