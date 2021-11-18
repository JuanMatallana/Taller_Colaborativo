package co.edu.uptc.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 *@author Sebastian Matallana
 *@author
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
     * metodo que permite confirmar correos electrónicos
     * @param sentence,direction
     * @return string
     */

    public String validateEmailConfirmation(String sentence) {
        String result = "";
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


        Matcher mather = pattern.matcher(sentence);

        if (mather.find() == true) {
            result = "El email ingresado es válido.";
        } else {
            result = "El email ingresado es inválido.";
        }return result;
    }
}