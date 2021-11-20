package co.edu.uptc.runner;

import javax.swing.JOptionPane;

import co.edu.uptc.logic.Management;

public class Runner {

    public static void menu() {
        String sentence="";
        String search="";
        boolean aux = true;
        while(aux == true){
            sentence = JOptionPane.showInputDialog("Ingrese la frase con la que desea utilizar el programa");
            if (sentence == null){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error, por lo tanto se cerrara la aplicacion", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            if (sentence.equals("")){
                JOptionPane.showMessageDialog(null, "Asegurese de haber ingresado una frase o cadena de texto", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            }else{
                aux = false;
            }
        }
        Management mg = new Management(sentence);
        int menu = 0;
        do {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog("1. Convertir en nombre propio el contenido de la cadena \n"
                        + "2. Buscar cadena de caracteres \n 3. Contar Vocales \n 4. Año nuevo \n 5. Llenar caracteres \n6. Borrar caracteres \n"
                        + "7. Intersección \n 8. Eliminar repetidos \n 9. Contar Palabras \n 10. Validar dirección de correo electronico \n 11. Salir"));
                switch (menu) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Sentencia : " + sentence + "\n Sentencia modificada: " + mg.own_Name());
                        break;
                    case 2:
                    	search=JOptionPane.showInputDialog("�Qu� palabra que desea buscar del texto anteriormente escrito? " );
                    	 if (mg.Search_String_Characters(search,sentence)==0){
                        	 JOptionPane.showMessageDialog(null, "No se encontro la palabra" );
                    	 }
                    	 if(mg.Search_String_Characters(search,sentence)>=1) {
                    		 JOptionPane.showMessageDialog(null, "La palabra se repite " + mg.Search_String_Characters(search, sentence)+" veces." );
                    	 }


                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, " Hay : " + mg.Count_Vowels(sentence) + " vocal(es) en el texto");


                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, " faltan " + mg.year() + " minutos para año nuevo");
                        break;
                    case 5:
                        boolean menu2 = false;
                        while(menu2 == false){
                            try {
                                int options2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese: \n 1. Para llenar caracteres por derecha\n"
                                        + "2. Para llenar caracteres por izquerda"));
                                String stringOptions2 = String.valueOf(options2);
                                if (stringOptions2 != null){
                                    if (stringOptions2.equals("")){
                                        JOptionPane.showMessageDialog(null, "Opcion invalida, debe elegir alguna opcion","ERROR",JOptionPane.ERROR_MESSAGE);
                                    }else {
                                        switch (options2){
                                            case 1:
                                                String address = "Derecha";
                                                String character = JOptionPane.showInputDialog("Ingrese el caracter que se agregara a la sentencia indicada al inicio");
                                                char character2 = character.charAt(0);
                                                int limit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese (en número) de la cantidad de caracteres a añadir"));
                                                JOptionPane.showMessageDialog(null, mg.fill_Characters(character2, limit,address));
                                                menu2 = true;
                                                break;

                                            case 2:
                                                String addressLeft = "Izquierda";
                                                String characterLeft = JOptionPane.showInputDialog("Ingrese el caracter que se agregara a la sentencia indicada al inicio");
                                                char character2Left = characterLeft.charAt(0);
                                                int limitLeft = Integer.parseInt(JOptionPane.showInputDialog("Ingrese (en número) de la cantidad de caracteres a añadir"));
                                                JOptionPane.showMessageDialog(null, mg.fill_Characters(character2Left, limitLeft,addressLeft));
                                                menu2 = true;
                                                break;
                                        }
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Volviendo al menú", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                                    menu2 = true;
                                }
                            }catch (Exception e){
                                JOptionPane.showMessageDialog(null, "Debe ingresar algun dato");
                            }
                        }
                        break;
                    case 6:
                    	String caracter = JOptionPane.showInputDialog("Ingrese caracter a borrar");
                    	JOptionPane.showMessageDialog(null, "Cadena inicial: " +  sentence + "\nCadena Final: " + mg.borrar(sentence, caracter));
                        break;
                    case 7:
                    	String cadena = JOptionPane.showInputDialog("Ingrese cadena a comparar");
                    	JOptionPane.showMessageDialog(null, mg.interseccion(sentence, cadena));
            			break;
                    case 8:
                    	JOptionPane.showMessageDialog(null, mg.borrarDuplicados(sentence));
                    	
                    	break;

                    case 9:
                    	JOptionPane.showMessageDialog(null, mg.Count_Words(sentence));

                        break;
                    case 10:
                        sentence = JOptionPane.showInputDialog("escriba el email para su posterior confirmación");
                        JOptionPane.showMessageDialog(null, mg.validateEmailConfirmation(sentence));
                        break;
                    case 11:
                        JOptionPane.showMessageDialog(null, "Ha salido del programa","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);

                        break;
                    default: JOptionPane.showMessageDialog(null, "Opcion invalida","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }while(menu!=11);
    }

    public static void main(String[] args) {
        menu();

    }

}
