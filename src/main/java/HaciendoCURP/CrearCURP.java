/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HaciendoCURP;

import java.lang.String;
import java.util.Arrays;

/**
 *
 * @author chilamguzman
 */
public class CrearCURP {
    
    private String[] VOCALES = {"A","E","I","O","U"};
    
    private String[] CONSONANTES = {"B","C","D","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};
    
    private String MESES[]
        = { "Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto",
            "Septiembre", "Octubre", "Noviembre", "Diciembre" };
    
    private String MESES_NUM[]
        = { "01", "02", "03", "04",
            "05", "06", "07", "08",
            "09", "10", "11", "12" };
    
    private String[] ENTIDAD_FEDERATIVA = {"AGUASCALIENTES",
                                           "BAJA CALIFORNIA NTE.",
                                           "BAJA CALIFORNIA SUR",
                                           "CAMPECHE",
                                           "COAHUILA",
                                           "COLIMA",
                                           "CHIAPAS",
                                           "CHIHUAHUA",
                                           "DISTRITO FEDERAL",
                                           "DURANGO",
                                           "GUANAJUATO",
                                           "GUERRERO",
                                           "HIDALGO",
                                           "JALISCO",
                                           "MEXICO",
                                           "MICHOACAN",
                                           "MORELOS",
                                           "NAYARIT",
                                           "NUEVO LEON",
                                           "OAXACA",
                                           "PUEBLA",
                                           "QUERETARO",
                                           "QUINTANA ROO",
                                           "SAN LUIS POTOSI",
                                           "SINALOA",
                                           "SONORA",
                                           "TABASCO",
                                           "TAMAULIPAS",
                                           "TLAXCALA",
                                           "VERACRUZ",
                                           "YUCATAN",
                                           "ZACATECAS",
                                           "SERV. EXTERIOR MEXICANO",
                                           "NACIDO EN EL EXTRANJERO"};
    
    private String[] ENTIDAD_FEDERATIVA_VALOR = {"AS",
                                                 "BC",
                                                 "BS",
                                                 "CC",
                                                 "CL",
                                                 "CM",
                                                 "CS",
                                                 "CH",
                                                 "DF",
                                                 "DG",
                                                 "GT",
                                                 "GR",
                                                 "HG",
                                                 "JC",
                                                 "MC",
                                                 "MN",
                                                 "MS",
                                                 "NT",
                                                 "NL",
                                                 "OC",
                                                 "PL",
                                                 "QT",
                                                 "QR",
                                                 "SP",
                                                 "SL",
                                                 "SR",
                                                 "TC",
                                                 "TS",
                                                 "TL",
                                                 "VZ",
                                                 "YN",
                                                 "ZS",
                                                 "SM",
                                                 "NE"};
    
    public String validacionAlfabetica(String nombre, String ape_paterno, String ape_materno){
        String digito1, digito3, digito4;
        String digito2 = "";
        char[] arrayNombre = nombre.toCharArray();
        char[] arrayApaterno = ape_paterno.toCharArray();
        char[] arrayAmaterno = ape_materno.toCharArray();
        
        //Letra inicial del primer apellido
        digito1 = String.valueOf(arrayApaterno[0]);

        //Primera vocal interna del primer apellido
        for(int i = 0; i<=(arrayApaterno.length)-1; i++){
            boolean contains = Arrays.stream(VOCALES).anyMatch(String.valueOf(arrayApaterno[i])::equals);
            if(contains){
                //System.out.println(arrayApaterno[i]);
                digito2 = String.valueOf(arrayApaterno[i]);
                break;
            }
        }

        //Letra inicial del segundo apellido
        digito3 = String.valueOf(arrayAmaterno[0]);

        //Primera letra del nombre 
        digito4 = String.valueOf(arrayNombre[0]);
        
        //Concatenación
        String validacionAlfabetica = digito1 + digito2 + digito3 + digito4;
        
        return validacionAlfabetica;
    }
    
    
    
    public String validacionNumerica(String dia, String mes, String anio){
        String digito5, digito6;
        String digito7y8 = "";
        String digito9y10 = "";

        char[] arrayAnio = anio.toCharArray();
        
        //Penúltimo dígito del año de nacimiento 
        digito5 = String.valueOf(arrayAnio[2]);

        //Último dígito del año de nacimiento 
        digito6 = String.valueOf(arrayAnio[3]);

        //Primer y segundo dígito del mes de nacimiento
        for(int i = 0; i<=(MESES.length)-1; i++){
            if(MESES[i].equals(mes)){
                digito7y8 = MESES_NUM[i];
            }
        }

        //Primer y segundo dígito del día de nacimiento 
        digito9y10 = dia;
        
        String validacionNumerica = digito5 + digito6 + digito7y8 + digito9y10;
        return validacionNumerica;
    }
    
    
    public String validacionAlfabeticaPte2(String sexo, String lugar_nac, String nombre, String ape_paterno, String ape_materno){
        String digito11 = "";
        String digito12y13 = "";
        String digito14 = "";
        String digito15 = "";
        String digito16 = "";
        
        char[] arrayNombre = nombre.toCharArray();
        char[] arrayApaterno = ape_paterno.toCharArray();
        char[] arrayAmaterno = ape_materno.toCharArray();
        
        //Sexo: H para hombre y M para mujer
        digito11 = sexo;

        //Lugar de nacimiento codificado en dos posiciones conforme al catálogo para la conformación de la CURP 
        for(int i = 0; i<=(ENTIDAD_FEDERATIVA.length)-1; i++){
            if(ENTIDAD_FEDERATIVA[i].equals(lugar_nac)){
                digito12y13 = ENTIDAD_FEDERATIVA_VALOR[i];
            }
        }

        //Primera consonante interna del primer apellido
        int count = 0;
        for(int i = 0; i<=(arrayApaterno.length)-1; i++){
            boolean contains = Arrays.stream(CONSONANTES).anyMatch(String.valueOf(arrayApaterno[i])::equals);
            if(contains){
                count++;
                if(count==2){
                    digito14 = String.valueOf(arrayApaterno[i]);
                    break;
                }
            }
        }

        //Primera consonante interna del segundo apellido
        int count2 = 0;
        for(int i = 0; i<=(arrayAmaterno.length)-1; i++){
            boolean contains = Arrays.stream(CONSONANTES).anyMatch(String.valueOf(arrayAmaterno[i])::equals);
            if(contains){
                count2++;
                if(count2==2){
                    digito15 = String.valueOf(arrayAmaterno[i]);
                    break;
                }
            }
        }

        //Primera consonante interna del nombre
        int count3 = 0;
        for(int i = 0; i<=(arrayNombre.length)-1; i++){
            boolean contains = Arrays.stream(CONSONANTES).anyMatch(String.valueOf(arrayNombre[i])::equals);
            if(contains){
                count3++;
                if(count3==2){
                    digito16 = String.valueOf(arrayNombre[i]);
                    break;
                }
            }
        }
        
        String validacionAlfabeticaPte2 = digito11 + digito12y13 + digito14 + digito15 + digito16;
        return validacionAlfabeticaPte2;
    }
    
    
    
    
    
}
