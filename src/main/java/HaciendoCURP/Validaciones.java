/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HaciendoCURP;

import javax.swing.JOptionPane;

/**
 *
 * @author Chilam Guzman
 */
public class Validaciones {
    
    public boolean validarTextField(String inputFieldData){
        
        char[] arrayInputFieldData = inputFieldData.toCharArray();
        for(int i = 0; i<=(arrayInputFieldData.length)-1; i++){
            try {
                int number = Integer.parseInt(String.valueOf(arrayInputFieldData[i]));
                return false;
            }
            catch(NumberFormatException e) {
                //System.out.println("Dentro del Catch " + arrayInputFieldData[i]);
            }            
        }
        return true;
    }
    
    public boolean validarTextFieldNumerico(String inputFieldData){
        
        char[] arrayInputFieldData = inputFieldData.toCharArray();
        for(int i = 0; i<=(arrayInputFieldData.length)-1; i++){
            try {
                int number = Integer.parseInt(String.valueOf(arrayInputFieldData[i]));
                return true;
            }
            catch(NumberFormatException e) {
                //System.out.println("Dentro del Catch " + arrayInputFieldData[i]);
            }            
        }
        return false;
    }
    
    public String validandoCURPGrosero(String cadenaRecibida){
        String cadenaValidada = "";
        switch(cadenaRecibida)
        {
            case "BUEI":
            	cadenaValidada = "BUEX";
            	break;

            case "BUEY":
            	cadenaValidada = "BUEX";
            	break;

            case "CACA":
            	cadenaValidada = "CACX";
            	break;

            case "CACO":
            	cadenaValidada = "CACX";
            	break;

            case "CAGA":
            	cadenaValidada = "CAGX";
            	break;

            case "CAGO":
            	cadenaValidada = "CAGX";
            	break;

            case "CAKA":
            	cadenaValidada = "CAKX";
            	break;

            case "CAKO":
            	cadenaValidada = "CAKX";
            	break;

            case "COGE":
            	cadenaValidada = "COGX";
            	break;

            case "COJA":
            	cadenaValidada = "COJX";
            	break;

            case "COJE":
            	cadenaValidada = "COJX";
            	break;

            case "COJI":
            	cadenaValidada = "COJX";
            	break;

            case "COJO":
            	cadenaValidada = "COJX";
            	break;

            case "CULO":
            	cadenaValidada = "CULX";
            	break;

            case "FETO":
            	cadenaValidada = "FETX";
            	break;

            case "GUEY":
            	cadenaValidada = "GUEX";
            	break;

            case "JOTO":
            	cadenaValidada = "JOTX";
            	break;

            case "KACA":
            	cadenaValidada = "KACX";
            	break;

            case "KACO":
            	cadenaValidada = "KACX";
            	break;

            case "KAGA":
            	cadenaValidada = "KAGX";
            	break;

            case "KAGO":
            	cadenaValidada = "KAGX";
            	break;

            case "KAKA":
            	cadenaValidada = "KAKX";
            	break;

            case "KOGE":
            	cadenaValidada = "KOGX";
            	break;

            case "KOJO":
            	cadenaValidada = "KOJX";
            	break;

            case "KULO":
            	cadenaValidada = "KULX";
            	break;

            case "MAME":
            	cadenaValidada = "MAMX";
            	break;

            case "MAMO":
            	cadenaValidada = "MAMX";
            	break;

            case "MEAR":
            	cadenaValidada = "MEAX";
            	break;

            case "MEAS":
            	cadenaValidada = "MEAX";
            	break;

            case "MEON":
            	cadenaValidada = "MEOX";
            	break;

            case "MION":
            	cadenaValidada = "MIOX";
            	break;

            case "MOCO":
            	cadenaValidada = "MOCX";
            	break;

            case "MULA":
            	cadenaValidada = "MULX";
            	break;

            case "PEDA":
            	cadenaValidada = "PEDX";
            	break;

            case "PEDO":
            	cadenaValidada = "PEDX";
            	break;

            case "PENE":
            	cadenaValidada = "PENX";
            	break;

            case "PUTA":
            	cadenaValidada = "PUTX";
            	break;

            case "PUTO":
            	cadenaValidada = "PUTX";
            	break;

            case "QULO":
            	cadenaValidada = "QULX";
            	break;

            case "RATA":
            	cadenaValidada = "RATX";
            	break;

            case "RUIN":
            	cadenaValidada = "RUIX";
            	break;
            
            default:
                cadenaValidada = cadenaRecibida;
        }
        return cadenaValidada;
    }
    
}
