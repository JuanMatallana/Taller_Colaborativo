package co.edu.uptc.logic;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 *@author Sebastian Matallana
 *@author Felipe Penagos
 *@author

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
			phrase ="Se encontr? '" + search_String
		                     + "' y esta aparece " + accountant +" veces";
	
		}
			
		  
		if(accountant==0){
		 
		   phrase= "'" + search_String + "' NO est? dentro del texto ";
		  
	
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
    
    
    
    /**
     * Metodo que cuenta todas las palabras que se encuentran en una frase
     * @param text
     * @return Contador
     */
    
    public String Count_Words(String text){
    	
    	String phrase="";
    	 StringTokenizer st = new StringTokenizer(text);
    	 return phrase="N?mero de palabras: " + st.countTokens();
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
     * metodo que permite confirmar correos electr??nicos
     * @param sentence,direction
     * @return string
     */

    public String validateEmailConfirmation(String sentence) {
        String result = "";
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


        Matcher mather = pattern.matcher(sentence);

        if (mather.find() == true) {
            result = "El email ingresado es v??lido.";
        } else {
            result = "El email ingresado es inv??lido.";
        }return result;
    }
}