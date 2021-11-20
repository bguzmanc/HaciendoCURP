/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HaciendoCURP;

/**
 *
 * @author chilamguzman
 */
public class EstudioSocioeconomico {
    
    public int pregunta_1(String respuestaSeleccionada){
        int puntaje = 0;
        switch(respuestaSeleccionada)
        {
            case ("Sin Instrucción"):
            puntaje = 0;
            break;
            
            case ("Preescolar"):
            puntaje = 0;
            break;
            
            case ("Primaria Incompleta"):
            puntaje = 10;
            break;
            
            case ("Primaria Completa"):
            puntaje = 22;
            break;
            
            case ("Secundaria Incompleta"):
            puntaje = 23;
            break;
            
            case ("Secundaria Completa"):
            puntaje = 31;
            break;
            
            case ("Preparatoria Incompleta"):
            puntaje = 35;
            break;
            
            case ("Preparatoria Completa"):
            puntaje = 43;
            break;
            
            case ("Licenciatura Incompleta"):
            puntaje = 59;
            break;
            
            case ("Licenciatura Completa"):
            puntaje = 73;
            break;
            
            case ("Posgrado"):
            puntaje = 101;
            break;
        }
        return puntaje;
    }
    
    public int pregunta_2(String respuestaSeleccionada){
        int puntaje = 0;
        switch(respuestaSeleccionada)
        {
            case ("0"):
            puntaje = 0;
            break;
            
            case ("1"):
            puntaje = 24;
            break;
            
            case ("2 o más"):
            puntaje = 47;
            break;
        }
        return puntaje;
    }
    
    public int pregunta_3(String respuestaSeleccionada){
        int puntaje = 0;
        switch(respuestaSeleccionada)
        {
            case ("0"):
            puntaje = 0;
            break;
            
            case ("1"):
            puntaje = 18;
            break;
            
            case ("2 o más"):
            puntaje = 37;
            break;
        }
        return puntaje;
    }
    
    public int pregunta_4(String respuestaSeleccionada){
        int puntaje = 0;
        switch(respuestaSeleccionada)
        {
            case ("NO TIENE"):
            puntaje = 0;
            break;
            
            case ("SI TIENE"):
            puntaje = 31;
            break;
        }
        return puntaje;
    }
    
    public int pregunta_5(String respuestaSeleccionada){
        int puntaje = 0;
        switch(respuestaSeleccionada)
        {
            case ("0"):
            puntaje = 0;
            break;
            
            case ("1"):
            puntaje = 15;
            break;
            
            case ("2"):
            puntaje = 31;
            break;
            
            case ("3"):
            puntaje = 46;
            break;
            
            case ("4 o más"):
            puntaje = 61;
            break;
        }
        return puntaje;
    }
    
    public int pregunta_6(String respuestaSeleccionada){
        int puntaje = 0;
        switch(respuestaSeleccionada)
        {
            case ("0"):
            puntaje = 0;
            break;
            
            case ("1"):
            puntaje = 6;
            break;
            
            case ("2"):
            puntaje = 12;
            break;
            
            case ("3"):
            puntaje = 17;
            break;
            
            case ("4 o más"):
            puntaje = 23;
            break;
        }
        return puntaje;
    }
    
    public String obtenerResultado (int p1, int p2, int p3, int p4, int p5, int p6){
        /*
        A/B 205 o más
        C+ 166 a 204
        
        C 136 a 165
        C- 112 a 135
        
        D+ 90 a 111
        D 48 a 89
        E 0 a 47
        */
        String resultado = "";
        int sumaPuntos = p1+p2+p3+p4+p5+p6;
        
        if(sumaPuntos <= 47){
            resultado = "E (muy baja)";
        } else if(sumaPuntos >= 48 && sumaPuntos <=89){
            resultado = "D (baja)";
        } else if(sumaPuntos >= 90 && sumaPuntos <=111){
            resultado = "D+ (media baja)";
        } else if(sumaPuntos >= 112 && sumaPuntos <=135){
            resultado = "C- (media)";
        } else if(sumaPuntos >= 136 && sumaPuntos <=165){
            resultado = "C (media alta)";
        } else if(sumaPuntos >= 166 && sumaPuntos <=204){
            resultado = "C+ (alta)";
        } else if(sumaPuntos >= 205){
            resultado = "A/B (muy alta)";
        }
        return resultado;
    }
}
